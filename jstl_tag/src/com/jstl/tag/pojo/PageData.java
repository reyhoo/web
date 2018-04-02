package com.jstl.tag.pojo;

import java.util.List;

public class PageData<T> {

	private List<T> dataList;
	private int start;
	private int limit;
	private int total;
	public List<T> getDataList() {
		return dataList;
	}
	public int getStart() {
		return start;
	}
	public int getLimit() {
		return limit;
	}
	public int getTotal() {
		return total;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
}
