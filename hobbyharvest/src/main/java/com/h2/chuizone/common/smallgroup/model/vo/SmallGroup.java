package com.h2.chuizone.common.smallgroup.model.vo;

public class SmallGroup {
	private int smallGroupNo;
	private String smallGroupName;
	
	public SmallGroup(int smallGroupNo, String smallGroupName) {
		this.smallGroupNo = smallGroupNo;
		this.smallGroupName = smallGroupName;
	}
	
	public SmallGroup() {
	}

	public int getSmallGroupNo() {
		return smallGroupNo;
	}
	
	public void setSmallGroupNo(int smallGroupNo) {
		this.smallGroupNo = smallGroupNo;
	}
		
	public String getSmallGroupName() {
		return smallGroupName;
	}
	
	public void setSmallGroupName(String smallGroupName) {
		this.smallGroupName = smallGroupName;
	}

	@Override
	public String toString() {
		return "SmallGroup [smallGroupNo=" + smallGroupNo + ", smallGroupName="
				+ smallGroupName + "]";
	}
}
