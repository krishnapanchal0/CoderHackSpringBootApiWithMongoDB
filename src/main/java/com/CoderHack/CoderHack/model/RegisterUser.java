package com.CoderHack.CoderHack.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class RegisterUser {
	private String userId;
	private String userName;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public RegisterUser(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	
	public RegisterUser() {
		
	}
}
