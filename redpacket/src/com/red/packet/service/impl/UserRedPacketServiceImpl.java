package com.red.packet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.red.packet.mapper.RedPacketDao;
import com.red.packet.mapper.UserRedPacketDao;
import com.red.packet.pojo.RedPacket;
import com.red.packet.pojo.UserRedPacket;
import com.red.packet.service.RedisRedPacketService;
import com.red.packet.service.UserRedPacketService;

import redis.clients.jedis.Jedis;

@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

	@Autowired
	private UserRedPacketDao userRedpacketDao;

	@Autowired
	private RedPacketDao redPacketDao;
	@Autowired
	private RedisRedPacketService redisRedPacketService;
	@Autowired
	private RedisTemplate redisTemplate = null;
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int grapRedPacket(Long redPacketId, Long userId) {
		// RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
		//并发引起数据不统一
//		RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
		//用悲观锁实现数据统一
		 RedPacket redPacket = redPacketDao.getRedPacketForUpdate(redPacketId);
		if (redPacket.getStock() > 0) {
			redPacketDao.decreaseRedRedPacket(redPacketId);
			UserRedPacket userRedPacket = new UserRedPacket();
			userRedPacket.setUserId(userId);
			userRedPacket.setAmount(redPacket.getUnitAmount());
			userRedPacket.setRedPacketId(redPacketId);
			userRedPacket.setNote("抢红包" + redPacketId);
			return userRedpacketDao.grapRedPacket(userRedPacket);
		}
		return 0;
	}
	
	

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int grapRedPacketForVersion(Long redPacketId, Long userId) {
		//用次数设置重入限制,提高成功率
		
		for (int i = 0; i < 3; i++) {
			RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
			if(redPacket.getStock()>0) {
				int update = redPacketDao.decreaseRedRedPacketForVersion(redPacketId, redPacket.getVersion());
				if(update == 0) {
					continue;
				}
				UserRedPacket userRedPacket = new UserRedPacket();
				userRedPacket.setUserId(userId);
				userRedPacket.setAmount(redPacket.getUnitAmount());
				userRedPacket.setRedPacketId(redPacketId);
				userRedPacket.setNote("抢红包" + redPacketId);
				return userRedpacketDao.grapRedPacket(userRedPacket);
			}else {
				return 0;
			}
		}
		return 0;
		
		
		//用时间戳设置重入限制
//		long start = System.currentTimeMillis();
//		while(true) {
//			long end = System.currentTimeMillis();
//			if(end-start>500) {
//				return 0;
//			}
//			RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
//			if(redPacket.getStock() > 0) {
//				int result = redPacketDao.decreaseRedRedPacketForVersion(redPacketId, redPacket.getVersion());
//				if(result == 0) {
//					continue;
//				}
//				UserRedPacket userRedPacket = new UserRedPacket();
//				userRedPacket.setUserId(userId);
//				userRedPacket.setAmount(redPacket.getUnitAmount());
//				userRedPacket.setRedPacketId(redPacketId);
//				userRedPacket.setNote("抢红包" + redPacketId);
//				return userRedpacketDao.grapRedPacket(userRedPacket);
//			}else {
//				return 0;
//			}
//		}
		//乐观锁会导致失败率，用重入的方式可以提高成功率
//		RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
//		if (redPacket.getStock() > 0) {
//			int result = redPacketDao.decreaseRedRedPacketForVersion(redPacketId, redPacket.getVersion());
//			if(result == 0) {
//				return 0;
//			}
//			UserRedPacket userRedPacket = new UserRedPacket();
//			userRedPacket.setUserId(userId);
//			userRedPacket.setAmount(redPacket.getUnitAmount());
//			userRedPacket.setRedPacketId(redPacketId);
//			userRedPacket.setNote("抢红包" + redPacketId);
//			return userRedpacketDao.grapRedPacket(userRedPacket);
//		}
//		return 0;
	}

	private String script = "local listKey = 'red_packet_list_'..KEYS[1] \n"
			+ "local redPacket = 'red_packet_'..KEYS[1] \n"
			+ "local stock = tonumber(redis.call('hget',redPacket,'stock')) \n"
			+ "if stock <= 0 then return 0 end \n"
			+ "stock = stock - 1 \n"
			+ "redis.call('hset',redPacket,'stock',tostring(stock)) \n"
			+ "redis.call('rpush',listKey,ARGV[1]) \n"
			+ "if stock == 0 then return 2 end \n"
			+ "return 1 \n";
	
	
	private String sha1 = null;
	

	@Override
	public Long grapRedPacketForRedis(Long redPacketId, Long userId) {
		String args = userId + "-" + System.currentTimeMillis();
		Long result = null;
		Jedis jedis = (Jedis) redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		try {
			
		
		if(sha1 == null) {
			sha1 = jedis.scriptLoad(script);
		}
		Object res = jedis.evalsha(sha1, 1, redPacketId + "",args);
		result = (Long) res;
		if(result == 2) {
			String unitAmountStr = jedis.hget("red_packet_"+redPacketId, "unit_amount");
			Double unitAmount = Double.parseDouble(unitAmountStr);
			System.err.println("ThreadName:"+Thread.currentThread().getName());
			redisRedPacketService.saveUserRedPacketByRedis(redPacketId, unitAmount);
		}
		} finally {
			if(jedis!=null && jedis.isConnected()) {
				jedis.close();
			}
		}
		return result;
	}
	
	
	
	

}
