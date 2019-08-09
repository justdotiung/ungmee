package ungmee.web.entity;

import java.sql.Date;

public class Notice {
//	"ID" NUMBER DEFAULT "UNG"."NOTICE_SEQ"."NEXTVAL" NOT NULL ENABLE, 
//	"ADMIN_ID" NUMBER NOT NULL ENABLE, 
//	"CATEGORY" NVARCHAR2(2) NOT NULL ENABLE, 
//	"TITLE" NVARCHAR2(300) NOT NULL ENABLE, 
//	"CONTENT" CLOB, 
//	"REGDATE" DATE DEFAULT sysdate NOT NULL ENABLE, 
//	 CONSTRAINT "ADMIN_BOARD_PK" PRIMARY KEY ("ID")
	
	private Integer id;
	private int adminId;
	private String category;
	private String title;
	private String content;
	private Date regDate;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	@Override
	public String toString() {
		return "Notice [id=" + id + ", adminId=" + adminId + ", category=" + category + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}


	
	}
