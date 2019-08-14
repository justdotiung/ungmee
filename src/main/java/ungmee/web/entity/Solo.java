package ungmee.web.entity;

public class Solo {
	/*
	 * COMMENT ON COLUMN SOLO.ID IS '회원아이디';
	 * COMMENT ON COLUMN SOLO.BIRTHDAY IS '월일4자';
	 * COMMENT ON COLUMN SOLO.GENDER IS '성별 1.male 2.female';
	 * COMMENT ON COLUMN SOLO.C_STATE IS '1커플 0커플신청중 -1솔로';
	 */ 
	private int id;
    private int birthday;
    private int gender;
    private int cState;
	
    public Solo() {}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getcState() {
		return cState;
	}
	public void setcState(int cState) {
		this.cState = cState;
	}
    
    
}
