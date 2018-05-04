package com.myec.pojo;

public enum OrderStatusEnum {

	
	PAID("paid","��֧��"),UNPAID("unpaid","δ֧��"),CANCELLED("cancelled","��ȡ��");
	private String value;
	private String showText;
	OrderStatusEnum(String value,String showText){
		this.value = value;
		this.showText = showText;
	}
	
	public static OrderStatusEnum getStatusByValue(String value) {
		for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
			if(orderStatusEnum.value.equals(value)) {
				return orderStatusEnum;
			}
		}
		return null;
	}
	
	public String getValue() {
		return value;
	}
	public String getShowText() {
		return showText;
	}
	
	
}
