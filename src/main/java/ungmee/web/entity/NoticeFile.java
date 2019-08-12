package ungmee.web.entity;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class NoticeFile {
//	"ID" NUMBER(20,0) DEFAULT "UNG"."NOTICEFILE_SEQ"."NEXTVAL" NOT NULL ENABLE, 
//	"NOTICE_ID" NUMBER(20,0) NOT NULL ENABLE, 
//	"TITLE" NVARCHAR2(100), 
//	"ORGFILENAME" NVARCHAR2(100), 
//	"SAVEFILENAME" NVARCHAR2(100), 
//	"FILESIZE" NUMBER(20,0), 
//	"REGDATE" DATE
	private int id;
	private int noticeId;
	private String title;
	private String orgFileName;
	private String saveFileName;
	private long filesize;
	private Date regDate;
	
	private MultipartFile file;
	
	public NoticeFile() {
	}
	

	public NoticeFile(int id, int noticeId, String title, String orgFileName, String saveFileName, long filesize,
			Date regDate, MultipartFile file) {
		super();
		this.id = id;
		this.noticeId = noticeId;
		this.title = title;
		this.orgFileName = orgFileName;
		this.saveFileName = saveFileName;
		this.filesize = filesize;
		this.regDate = regDate;
		this.file = file;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public void setStartRowNum(int startRowNum) {
		// TODO Auto-generated method stub
		
	}


	public void setEndRowNum(int endRowNum) {
		// TODO Auto-generated method stub
		
	}


	public void setFileSize(long fileSize2) {
		// TODO Auto-generated method stub
		
	}
	
}
