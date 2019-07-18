package ungmee.web.entity;

import java.util.Date;

public class Couple {
	  private int id;
	  private Date loveDay;
	  private int black;
	  private String profile;
	  private long phone;
	  private int sns;
	  private String cName;
	public Couple() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Couple(int id, Date loveDay, int black, String profile, long phone, int sns, String cName) {
		this.id = id;
		this.loveDay = loveDay;
		this.black = black;
		this.profile = profile;
		this.phone = phone;
		this.sns = sns;
		this.cName = cName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getLoveDay() {
		return loveDay;
	}
	public void setLoveDay(Date loveDay) {
		this.loveDay = loveDay;
	}
	public int getBlack() {
		return black;
	}
	public void setBlack(int black) {
		this.black = black;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getSns() {
		return sns;
	}
	public void setSns(int sns) {
		this.sns = sns;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
}
