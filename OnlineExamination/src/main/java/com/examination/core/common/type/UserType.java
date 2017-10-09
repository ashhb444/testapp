package com.examination.core.common.type;

public enum UserType {

	ADMIN("ADMIN"), EXAMINOR("EXAMINOR"), EXAMINEE("EXAMINEE");
	
	private String value;
	UserType(String value){
		this.value=value;
	}
	public String getValue() {
		return value;
	}
}
