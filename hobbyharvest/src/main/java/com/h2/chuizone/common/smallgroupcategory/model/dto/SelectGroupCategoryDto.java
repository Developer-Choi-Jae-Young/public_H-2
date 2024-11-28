package com.h2.chuizone.common.smallgroupcategory.model.dto;

public class SelectGroupCategoryDto {
	private int smallGroupId; 
	private int categoryId;
	
	public SelectGroupCategoryDto(int smallGroupId, int categoryId) {
		this.smallGroupId = smallGroupId;
		this.categoryId = categoryId;
	}	
}
