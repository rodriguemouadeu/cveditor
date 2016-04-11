package com.rodriguemouadeu.core.model;
public enum Gender {
	MALE("Male"),
	FEMALE("Female");
	
	private String label;
	
	private Gender(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}

	public String toString(){
		return label;
	}
}