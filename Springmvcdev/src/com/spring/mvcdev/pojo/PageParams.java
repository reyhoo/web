package com.spring.mvcdev.pojo;

public class PageParams {

	private int start;
	private int limit;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	@Override
	public String toString() {
		return "PageParams [start=" + start + ", limit=" + limit + "]";
	}
	
	
}
