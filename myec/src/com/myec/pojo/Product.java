package com.myec.pojo;

public class Product {

	private Long id;
	private String productName;
	private Integer stock;
	private Double price;
	private User merchant;
	private Integer version;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User getMerchant() {
		return merchant;
	}
	public void setMerchant(User merchant) {
		this.merchant = merchant;
	}

	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", stock=" + stock + ", price=" + price
				+ ", merchant=" + merchant + ", version=" + version + "]";
	}



	
	
}
