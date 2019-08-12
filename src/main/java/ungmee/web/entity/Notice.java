package ungmee.web.entity;

import java.sql.Date;

public class Notice {
//	"ID" NUMBER DEFAULT "UNG"."NOTICE_SEQ"."NEXTVAL" NOT NULL ENABLE, 
//	"WRITER_ID" NUMBER DEFAULT 61 NOT NULL ENABLE, 
//	"TITLE" NVARCHAR2(300), 
//	"CONTENT" CLOB, 
//	"REGDATE" DATE DEFAULT sysdate NOT NULL ENABLE, 
//	"CATEGORY_ID" NUMBER(1,0), 
//	"HIT" NUMBER
	
	private Integer id;
	private int writerId;
	private String title;
	private String content;
	private Date regDate;
	private int categoryId;
	private int hit;
	private int startRowNum;
	private int endRowNum;
	private int prevNum;
	private int nextNum;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", writerId=" + writerId + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", categoryId=" + categoryId + ", hit=" + hit + ", startRowNum="
				+ startRowNum + ", endRowNum=" + endRowNum + ", prevNum=" + prevNum + ", nextNum=" + nextNum + "]";
	}

	

	
	}
