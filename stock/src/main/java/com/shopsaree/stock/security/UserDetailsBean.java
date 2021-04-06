package com.shopsaree.stock.security;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsBean {
    public UserDetailsBean() {
	}
	private String fristName;
    private String lastName;
    private String mobileNumber;
    private String deviceIdentifier;
	private String email;
    private List<String> role=new ArrayList<>();
    private String fcmToken;
	public String getFcmToken() {
		return fcmToken;
	}
	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDeviceIdentifier() {
		return deviceIdentifier;
	}
	public void setDeviceIdentifier(String deviceIdentifier) {
		this.deviceIdentifier = deviceIdentifier;
	}
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserDetailsBean(String fristName, String lastName, String mobileNumber, 
			String deviceIdentifier, List<String> role) {
		super();
		this.fristName = fristName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.deviceIdentifier = deviceIdentifier;
		this.role = role;
	}
}