package com.drkiettran.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carriers")
public class Carrier {
	
	private String Code;
	private String Description;
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
}
