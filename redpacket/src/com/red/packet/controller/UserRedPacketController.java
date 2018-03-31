package com.red.packet.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("/page")
	public String page() {
		return "page";
	}
}
