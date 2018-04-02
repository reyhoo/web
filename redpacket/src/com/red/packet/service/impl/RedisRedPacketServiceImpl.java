package com.red.packet.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.red.packet.pojo.UserRedPacket;
import com.red.packet.service.RedisRedPacketService;

@Service
public class RedisRedPacketServiceImpl implements RedisRedPacketService {

	private static final String PREFIX = "red_packet_list_";

	private static final int TIME_SIZE = 1000;

	@Autowired
	private RedisTemplate redisTemplate = null;

	@Autowired
	private DataSource dataSource;

	// 开启新线程
	@Async
	@Override
	public void saveUserRedPacketByRedis(Long redPacketId, Double unitAmount) {
		System.err.println("开始保存数据");
		System.err.println("ThreadName:"+Thread.currentThread().getName());
		Long start = System.currentTimeMillis();
		BoundListOperations ops = redisTemplate.boundListOps(PREFIX + redPacketId);
		Long size = ops.size();
		Long times = size % TIME_SIZE == 0 ? size / TIME_SIZE : size / TIME_SIZE + 1;
		int count = 0;
		List<UserRedPacket> userRedPacketList = new ArrayList<>();
		for (int i = 0; i < times; i++) {
			// 获取至多TIME_SIZE个抢红包信息
			List userIdList = null;
			if (i == 0) {
				// 0到1000
				userIdList = ops.range(i * TIME_SIZE, (i + 1) * TIME_SIZE);
			} else {
				userIdList = ops.range(i * TIME_SIZE + 1, (i + 1) * TIME_SIZE);
			}
			userRedPacketList.clear();
			for (int j = 0; j < userIdList.size(); j++) {
				String args = userIdList.get(j).toString();
				String[] arr = args.split("-");
				String userIdStr = arr[0];
				String timeStr = arr[1];
				Long userId = Long.parseLong(userIdStr);
				Long time = Long.parseLong(timeStr);

				UserRedPacket userRedPacket = new UserRedPacket();
				userRedPacket.setRedPacketId(redPacketId);
				userRedPacket.setUserId(userId);
				userRedPacket.setAmount(unitAmount);
				userRedPacket.setGrabTime(new Date(time));
				userRedPacket.setNote("抢红包 " + redPacketId);
				userRedPacketList.add(userRedPacket);
			}
			count += executeBatch(userRedPacketList);
		}
		redisTemplate.delete(PREFIX + redPacketId);
		Long end = System.currentTimeMillis();
		System.err.println("保存数据结束，耗时" + (end - start) + "毫秒，共" + count + "条记录被保存");
	}

	private int executeBatch(List<UserRedPacket> userRedPacketList) {
		Connection conn = null;
		Statement stmt = null;
		int [] count = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			for (UserRedPacket userRedPacket : userRedPacketList) {
				String sql1 = "update t_red_packet set stock = stock-1 where id="+userRedPacket.getRedPacketId();
				String sql2 = "insert into t_user_red_packet(red_packet_id,user_id,amount,grab_time,note) values ("
						+ userRedPacket.getRedPacketId()+","
						+ userRedPacket.getUserId()+","
						+ userRedPacket.getAmount()+",'"
						+ sdf.format(userRedPacket.getGrabTime())+"','"
						+ userRedPacket.getNote()
						+ "')";
				stmt.addBatch(sql1);
				stmt.addBatch(sql2);
			}
			count = stmt.executeBatch();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		return count.length / 2;
	}
}
