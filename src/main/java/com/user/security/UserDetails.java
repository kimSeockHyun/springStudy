package com.user.security;

import java.io.Serializable;

public class UserDetails implements Serializable{
	
	private static final long serialVersionUID = -4450269958885980297L;
	
	private String userId;
	private String userPassword;
	private String userBrith;
	private String userPhone;
	private String userAddr1;
	private String userAddr2;
	
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddr1() {
		return userAddr1;
	}
	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}
	public String getUserAddr2() {
		return userAddr2;
	}
	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserBrith() {
		return userBrith;
	}
	public void setUserBrith(String userBrith) {
		this.userBrith = userBrith;
	}
	
}
