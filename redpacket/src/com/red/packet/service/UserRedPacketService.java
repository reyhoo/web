package com.red.packet.service;

public interface UserRedPacketService {
	int grapRedPacket(Long redPacketId,Long userId);
	
	int grapRedPacketForVersion(Long redPacketId,Long userId);
	
	Long grapRedPacketForRedis(Long redPacketId,Long userId);
}
