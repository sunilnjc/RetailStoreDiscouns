package com.retail.discounts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Document
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	@Id
	private String userId;
	
	private String userName;
	
	private UserType type;
	
	private String phoneNumber;
	
	private String sinceWhen;
	
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

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSinceWhen() {
		return sinceWhen;
	}

	public void setSinceWhen(String sinceWhen) {
		this.sinceWhen = sinceWhen;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", type=" + type + ", phoneNumber=" + phoneNumber
				+ ", sinceWhen=" + sinceWhen + "]";
	}
}
