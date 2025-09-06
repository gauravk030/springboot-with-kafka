package com.test.dto;

public class UserEvent {
	private String userId;
	private String name;
	private String action;

	public UserEvent() {
	}

	public UserEvent(String userId, String name, String action) {
		this.userId = userId;
		this.name = name;
		this.action = action;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}