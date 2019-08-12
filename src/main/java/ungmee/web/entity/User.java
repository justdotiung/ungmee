package ungmee.web.entity;

import java.util.Date;

public class User {
    private int id;
    private String email;
    private String pw;
    private Date regDate;
    private int enabled;
    private int roleId;
    private String echeck;
    private String nickName;
    private String profile;

	public User() {
	
    }

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

	public void setRegDate(Date regdate) {
		this.regDate = regdate;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", pw=" + pw + ", regDate=" + regDate + ", enabled=" + enabled
				+ ", roleId=" + roleId + ", echeck=" + echeck + ", nickName=" + nickName + ", profile=" + profile
				+ "]";
	}

	
}
