package com.shopsaree.stock.bean.response;

import com.shopsaree.stock.security.UserDetailsBean;

public class AuthResBean implements ResponseData{
	
	private String token;
	private UserDetailsBean userInfo;
	private boolean firstTimeLogin = false;
	
	
	public AuthResBean() {
		this.userInfo = new UserDetailsBean();
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserDetailsBean getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserDetailsBean userInfo) {
		this.userInfo = userInfo;
	}
	
	// 417810 : New property first time login flag included
	public boolean isFirstTimeLogin() {
		return firstTimeLogin;
	}
	public void setFirstTimeLogin(boolean firstTimeLogin) {
		this.firstTimeLogin = firstTimeLogin;
	}
	
}
