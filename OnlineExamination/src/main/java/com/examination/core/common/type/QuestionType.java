package com.examination.core.common.type;

public enum QuestionType {

	MultipleChoice("Multiple Choice");
	
	private String value;
	QuestionType(String value){
		this.value=value;
	}
	public String getValue() {
		return value;
	}
//	
//	public String[] getEnumValues(){
//		String[] values=null;
//		int index=0;
//		for(QuestionType coin: QuestionType.values()){ 
//			values[index]=coin.value;
//			index++;
//		}
//		return values;
//	}
}
