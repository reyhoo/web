package com.gradle.mvc.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class FormatPojo {

	@NotNull
	@NumberFormat(pattern="#,###.00")
	private BigDecimal amount1;
	@NotNull
//	@DateTimeFormat(pattern="yyyyMMdd")
	private Date date1;
	public BigDecimal getAmount1() {
		return amount1;
	}
	public Date getDate1() {
		return date1;
	}
	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	
	
}
