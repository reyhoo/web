package com.red.packet.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.red.packet.pojo.RedPacket;

@Repository
public interface RedPacketDao {
	/***
	 * ���淽��,�߲���ʱ�������ݲ�ͳһ
	 * 
	 * @param id
	 * @return
	 */
	RedPacket getRedPacket(Long id);

	/***
	 * ʹ��for update������
	 * 
	 * @param id
	 * @return
	 */
	RedPacket getRedPacketForUpdate(Long id);

	int decreaseRedRedPacket(Long id);

	int decreaseRedRedPacketForVersion(@Param("id") Long id, @Param("version") Integer version);
}
