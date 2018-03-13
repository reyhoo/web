package com.spring.ass.exe.pojo;

public class JuiceMaker2 {

	
	private String beverageShop;
	private Source source;
	
	public String getBeverageShop() {
		return beverageShop;
	}
	public void setBeverageShop(String beverageShop) {
		this.beverageShop = beverageShop;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	@Override
	public String toString() {
		return "JuiceMaker2 [beverageShop=" + beverageShop + ", source="
				+ source + "]";
	}
	
	
	public String makeJuice(){
		String juice = "这是一杯由"+beverageShop+"饮品店，提供的"+source.getSize()+
				source.getSugar()+source.getFruit();
		return juice;
	}
	
	
}
