package com.myec.pojo;

import java.util.Date;
import java.util.List;

public class Order {
	private Long id;
	private Date createTime;
	private Date payTime;
	private OrderStatusEnum status;// unpaid,paid,cancelled
	private String addr;
	private String mobile;
	private String nickname;
	private Long consumeId;
	private Double totalAmount;

	private List<OrderProduct> productList;

	private Integer version;
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public OrderStatusEnum getStatus() {
		return status;
	}

	public void setStatus(OrderStatusEnum status) {
		this.status = status;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getConsumeId() {
		return consumeId;
	}

	public void setConsumeId(Long consumeId) {
		this.consumeId = consumeId;
	}

	public List<OrderProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<OrderProduct> productList) {
		this.productList = productList;
	}
	
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", createTime=" + createTime + ", payTime=" + payTime + ", status=" + status
				+ ", addr=" + addr + ", mobile=" + mobile + ", nickname=" + nickname + ", consumeId=" + consumeId
				+ ", totalAmount=" + totalAmount + ", productList=" + productList + ", version=" + version + "]";
	}

	
}
