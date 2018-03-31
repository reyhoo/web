package com.red.packet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.red.packet.mapper.RedPacketDao;
import com.red.packet.pojo.RedPacket;
import com.red.packet.service.RedPacketService;
@Service
public class RedPacketServiceImpl implements RedPacketService {

	@Autowired
	private RedPacketDao redPacketDao;
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Override
	public RedPacket getRedPacket(Long id) {
		return redPacketDao.getRedPacket(id);
	}
	
	
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Override
	public int decreaseRedRedPacket(Long id) {
		return redPacketDao.decreaseRedRedPacket(id);
	}

}
