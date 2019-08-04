package ungmee.web.entity;

import java.util.Date;

public class User {
    private int id;
    private String email;
    private String pw;
    private Date regDate;
    private int enabled;
    private String authority;
    private String gender;
    private String echeck;
    private String nickName;
    private int birthday;
    private String profile;
    private int cState;
   


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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getcState() {
		return cState;
	}
	
	public void setcState(int cState) {
		this.cState = cState;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", pw=" + pw + ", regdate=" + regDate + ", enabled=" + enabled
				+ ", authority=" + authority + ", gender=" + gender + ", echeck=" + echeck + ", nickName=" + nickName
				+ ", birthday=" + birthday + ", profile=" + profile + ", cState=" + cState + "]";
	}
	
	
}
