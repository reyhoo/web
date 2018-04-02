package com.red.packet.service;

public interface RedisRedPacketService {

	void saveUserRedPacketByRedis(Long redPacketId, Double unitAmount);
}
