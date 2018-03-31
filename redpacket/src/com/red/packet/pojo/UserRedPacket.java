package com.red.packet.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserRedPacket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2763184105327589411L;

	
	private Long id;
	private Long redPacketId;
	private Long userId;
	private Double amount;
	private Date grabTime;
	private String note;
	public Long getId() {
		return id;
	}
	public Long getRedPacketId() {
		return redPacketId;
	}
	public Long getUserId() {
		return userId;
	}
	public Double getAmount() {
		return amount;
	}
	public Date getGrabTime() {
		return grabTime;
	}
	public String getNote() {
		return note;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setRedPacketId(Long redPacketId) {
		this.redPacketId = redPacketId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setGrabTime(Date grabTime) {
		this.grabTime = grabTime;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
