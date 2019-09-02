package com.ungmee.web.entity;

import java.util.Date;

public class SoloView {

	   private int id;
	   private String email;
	   private String pw;
	   private Date regDate;
	   private int enabled;
	   private int roleId;
	   private String echeck;
	   private String nickname;
	   private String profile;
	   private int birthday;
	   private int cState;
	   private int gender;
	   
	   
	
	
	public SoloView() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	
	public String getEcheck() {
		return echeck;
	}

	public void setEcheck(String echeck) {
		this.echeck = echeck;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public int getcState() {
		return cState;
	}
	public void setcState(int cState) {
		this.cState = cState;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserView [id=" + id + ", email=" + email + ", pw=" + pw + ", regDate=" + regDate + ", enabled="
				+ enabled + ", roleId=" + roleId + ", echeck=" + echeck + ", nickname=" + nickname + ", profile="
				+ profile + ", birthday=" + birthday + ", cState=" + cState + ", gender=" + gender + "]";
	}


}
