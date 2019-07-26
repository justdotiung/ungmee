package ungmee.web.entity;

import java.util.Date;

public class Member {
    private int id;
    private String email;
    private String pw;
    private Date regdate;
    private int enabled;
    private String authority;
    private String gender;
    private int echeck;

    public Member() {
	
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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

	public int getEcheck() {
		return echeck;
	}

	public void setEcheck(int echeck) {
		this.echeck = echeck;
	}

	
}
