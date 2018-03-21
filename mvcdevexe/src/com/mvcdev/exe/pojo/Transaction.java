package com.mvcdev.exe.pojo;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Transaction {

	@NotNull
	private Long productId;
	@NotNull
	private Long userId;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Future
	private Date date;
	@NotNull
	@DecimalMin(value="0.1")
	private Double price;
	@NotNull
	@Max(100)
	@Min(1)
	private Integer quantity;
	@NotNull
	@DecimalMin(value="0.1")
	@DecimalMax(value="50000.00")
	private Double amount;
	@Pattern(regexp="^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@"
			+ "([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$",message="不符合邮件格式")
	private String email;
	@Size(min=0,max=255)
	private String note;
	public Long getProductId() {
		return productId;
	}
	public Long getUserId() {
		return userId;
	}
	public Date getDate() {
		return date;
	}
	public Double getPrice() {
		return price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public String getEmail() {
		return email;
	}
	public String getNote() {
		return note;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Transaction [productId=" + productId + ", userId=" + userId
				+ ", date=" + date + ", price=" + price + ", quantity="
				+ quantity + ", amount=" + amount + ", email=" + email
				+ ", note=" + note + "]";
	}
	
	
}
