package com.ungmee.web.entity;



public class NoticeFile {

	private int id;
	private int noticeId;
	private String fileName;
	
	
	public NoticeFile() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNoticeId() {
		return noticeId;
	}


	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public String toString() {
		return "NoticeFile [id=" + id + ", noticeId=" + noticeId + ", fileName=" + fileName + "]";
	}
	
	

	
}
