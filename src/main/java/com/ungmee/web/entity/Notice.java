package com.ungmee.web.entity;

import java.sql.Date;

public class Notice {
//COMMENT ON COLUMN NOTICE.ID IS '아이디';
//COMMENT ON COLUMN NOTICE.WRITER_ID IS '관리자아이디,닉네임';
//COMMENT ON COLUMN NOTICE.TITLE IS '제목';
//COMMENT ON COLUMN NOTICE.CONTENT IS '내용';
//COMMENT ON COLUMN NOTICE.REGDATE IS '등록일';
//COMMENT ON COLUMN NOTICE.CATEGORY_ID IS '카테고리 1.회원공지사항 2.제휴사공지사항';

	private int id;
	private int writerId;
	private String title;
	private String content;
	private Date regdate;
	private int categoryId;
	private int hit;

	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", writerId=" + writerId + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", categoryId=" + categoryId + ", hit=" + hit + "]";
	}
	
	

}
