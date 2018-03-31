package com.red.packet.pojo;

import java.io.Serializable;
import java.util.Date;

public class RedPacket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2961631421426929888L;

	private Long id;
	private Long userId;
	private Double amount;
	private Date sendDate;
	private Long total;
	private Double unitAmount;
	private Integer stock;
	private Integer version;
	private String note;
	public Long getId() {
		return id;
	}
	public Long getUserId() {
		return userId;
	}
	public Double getAmount() {
		return amount;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public Long getTotal() {
		return total;
	}
	public Double getUnitAmount() {
		return unitAmount;
	}
	public Integer getStock() {
		return stock;
	}
	public Integer getVersion() {
		return version;
	}
	public String getNote() {
		return note;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
