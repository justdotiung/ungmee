package ungmee.web.entity;

import java.sql.Date;
import java.util.List;

public class Event {
//	"ID" NUMBER(10,0) DEFAULT "UNG"."EVENT_SEQ"."NEXTVAL" NOT NULL ENABLE, 
//	"ADMIN_ID" NUMBER(10,0) DEFAULT 61 NOT NULL ENABLE, 
//	"CATEGORY" NVARCHAR2(100), 
//	"CONTENT" CLOB NOT NULL ENABLE, 
//	"REGDATE" DATE DEFAULT SYSDATE

	private int id;
	private int adminId;
	private String category;
	private String content;
	private Date regDate;
	private List<EventFile> files;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "Event [id=" + id + ", adminId=" + adminId + ", category=" + category + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}

	public void setFiles(List<EventFile> files) {
		this.files = files;
	}

	public List<EventFile> getFiles() {
		return files;
	}


}
