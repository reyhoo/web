package com.red.packet.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.red.packet.pojo.RedPacket;

@Repository
public interface RedPacketDao {
	/***
	 * 常规方法,高并发时导致数据不统一
	 * 
	 * @param id
	 * @return
	 */
	RedPacket getRedPacket(Long id);

	/***
	 * 使用for update语句加锁
	 * 
	 * @param id
	 * @return
	 */
	RedPacket getRedPacketForUpdate(Long id);

	int decreaseRedRedPacket(Long id);

	int decreaseRedRedPacketForVersion(@Param("id") Long id, @Param("version") Integer version);
}
