package com.red.packet.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.red.packet.service.UserRedPacketService;

@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

	
	@Autowired
	private UserRedPacketService userRedPacketService;
	@ResponseBody
	@RequestMapping("/grapRedPacket")
	public Map<String, Object>grapRedPacket(Long redPacketId,Long userId){
		Map<String, Object> map = new HashMap<>();
		int result = userRedPacketService.grapRedPacket(redPacketId, userId);
		boolean flag = result > 0;
		map.put("success", flag);
		map.put("message", flag?"抢红包成功":"抢红包失败");
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("/grapRedPacketForVersion")
	public Map<String, Object>grapRedPacketForVersion(Long redPacketId,Long userId){
		Map<String, Object> map = new HashMap<>();
		int result = userRedPacketService.grapRedPacketForVersion(redPacketId, userId);
		boolean flag = result > 0;
		map.put("success", flag);
		map.put("message", flag?"抢红包成功":"抢红包失败");
		return map;
	}
	/****
	 * 调用之前手动添加redis数据
	 * hset red_packet_{id} stock 20000
	 * hset red_packet_{id} unit_amount 10
	 * @param redPacketId
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/grapRedPacketByRedis")
	public Map<String, Object>grapRedPacketByRedis(Long redPacketId,Long userId){
		Map<String, Object> map = new HashMap<>();
		long result = userRedPacketService.grapRedPacketForRedis(redPacketId, userId);
		boolean flag = result > 0;
		map.put("success", flag);
		map.put("message", flag?"抢红包成功":"抢红包失败");
		return map;
	}
	
	
	
	@RequestMapping("/page")
	public String page() {
		return "page";
	}
	@ResponseBody
	@RequestMapping("/testJson")
	public Map<String,Object> testJson() {
		Map<String, Object> map = new HashMap<>();
		map.put("name","姚磊");
		map.put("role", "hello");
		return map;
	}
}
