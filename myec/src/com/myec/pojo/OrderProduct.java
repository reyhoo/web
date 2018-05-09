package com.myec.pojo;

public class OrderProduct {

	private Long id;
	private Product product;
	private String productName;
	private Double productUnitPrice; 
	private Integer productQuantity;
	private Double productAmount;
	private Long orderId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(Double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Double getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", product=" + product + ", productName=" + productName
				+ ", productUnitPrice=" + productUnitPrice + ", productQuantity=" + productQuantity + ", productAmount="
				+ productAmount + ", orderId=" + orderId + "]";
	}
	
	
	
}
