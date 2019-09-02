package com.ungmee.web.entity;

public class Partner {
//	"USER_ID" NUMBER(20,0) DEFAULT NULL NOT NULL ENABLE, 
//	"B_NAME" NVARCHAR2(100) NOT NULL ENABLE, 
//	"PHONE" NUMBER(20,0), 
//	"P_NAME" NVARCHAR2(200), 
//	"P_TYPE" NVARCHAR2(100), 
//	"ADDRESS" NVARCHAR2(500), 
//	"D_TYPE" NVARCHAR2(20), 
//	"STARTDATE" NUMBER(20,0), 
//	"ENDDATE" NUMBER(20,0), 
//	"CON_STATUS" NVARCHAR2(100),
	
	private int userId;
	private String bName;
	private int phone;
	private String pName;
	private String pType;
	private String address;
	private String dDate;
	private int startDate;
	private int endDate;
	private String conStatus;

	public Partner() {
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getdDate() {
		return dDate;
	}

	public void setdDate(String dDate) {
		this.dDate = dDate;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public String getConStatus() {
		return conStatus;
	}

	public void setConStatus(String conStatus) {
		this.conStatus = conStatus;
	}

	@Override
	public String toString() {
		return "Partner [userId=" + userId + ", bName=" + bName + ", phone=" + phone + ", pName=" + pName + ", pType="
				+ pType + ", address=" + address + ", dDate=" + dDate + ", startDate=" + startDate + ", endDate="
				+ endDate + ", conStatus=" + conStatus + "]";
	}
	
	
	
}	
	
	
