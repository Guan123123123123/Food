package com.wzs.utils;

import java.util.List;

public class PageData<T> {
	//当前第几页
	private Integer curPage;
	//总记录数
	private Integer totalCount;
	//总页数 count
	private Integer count;
	private Integer totalPage;
	//当前页的数据
	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	//每页记录数
	private Integer pageSize;
	//状态码
	private Integer code=0;
	
	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public PageData(){}


	public Integer getCurPage() {
		return curPage;
	}


	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}


	public Integer getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}


	public Integer getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}





	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "PageData [curPage=" + curPage + ", totalCount=" + totalCount + ", count=" + count + ", totalPage="
				+ totalPage + ", data=" + data + ", pageSize=" + pageSize + ", code=" + code + "]";
	}


	

	


	
}
