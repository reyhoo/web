package com.red.packet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.red.packet.mapper.RedPacketDao;
import com.red.packet.mapper.UserRedPacketDao;
import com.red.packet.pojo.RedPacket;
import com.red.packet.pojo.UserRedPacket;
import com.red.packet.service.UserRedPacketService;

@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

	@Autowired
	private UserRedPacketDao userRedpacketDao;

	@Autowired
	private RedPacketDao redPacketDao;

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
		//用次数设置重入限制
		
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
		//乐观锁会导致失败率，用重入的方式可以提高失败率
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
	
	
	
	

}
