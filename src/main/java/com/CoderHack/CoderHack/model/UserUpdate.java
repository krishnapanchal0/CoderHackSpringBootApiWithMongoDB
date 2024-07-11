package com.CoderHack.CoderHack.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class UserUpdate {
	private String userId;
	private int score;
	private List<String> badge;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	public UserUpdate(String userId, int score, List<String> badge) {
		super();
		this.userId = userId;
		this.score = score;
		this.badge = badge;
	}
	public List<String> getBadge() {
		return badge;
	}
	public void setBadge(List<String> badge) {
		this.badge = badge;
	}
	public UserUpdate() {
		
	}
}
