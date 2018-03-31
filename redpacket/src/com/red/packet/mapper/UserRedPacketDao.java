package com.red.packet.mapper;

import org.springframework.stereotype.Repository;

import com.red.packet.pojo.UserRedPacket;
@Repository
public interface UserRedPacketDao {

	int grapRedPacket(UserRedPacket userRedPacket);
}
