package com.examination.core.common.type;

public enum StatusType {

	ACTIVE("Active"), INACTIVE("In-Active");
	
	private String value;
	StatusType(String value){
		this.value=value;
	}
	public String getValue() {
		return value;
	}
}
