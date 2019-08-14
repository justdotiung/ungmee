package ungmee.web.entity;

import java.sql.Date;

public class NoticeView {
	private Integer id;
	private int writerId;
	private String title;
	private String content;
	private Date regDate;
	private int hit;
	private String categoryName;
	private String nickname;
	
	public NoticeView() {
		// TODO Auto-generated constructor stub
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "NoticeView [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", hit=" + hit + ", categoryName=" + categoryName + ", nickname=" + nickname + "]";
	}
	
	
	
}
