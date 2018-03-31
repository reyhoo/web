package com.red.packet.service;

import com.red.packet.pojo.RedPacket;

public interface RedPacketService {
	
	
	RedPacket getRedPacket(Long id);
	
	int decreaseRedRedPacket(Long id);
}
