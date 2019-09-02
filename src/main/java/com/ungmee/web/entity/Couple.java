package com.ungmee.web.entity;

import java.util.Date;

public class Couple {
	/*
	 * COMMENT ON COLUMN "UNG"."COUPLE"."ID" IS '아이디'; COMMENT ON COLUMN
	 * "UNG"."COUPLE"."PROPOSE_ID" IS '신청회원아이디'; COMMENT ON COLUMN
	 * "UNG"."COUPLE"."ACCEPTER_ID" IS '수락아이디'; COMMENT ON COLUMN
	 * "UNG"."COUPLE"."COUPLE_NAME" IS '커플이름 '; COMMENT ON COLUMN
	 * "UNG"."COUPLE"."MESSAGE" IS '커플상태메세지 '; COMMENT ON COLUMN
	 * "UNG"."COUPLE"."LOVEDATE" IS '사귄날짜'; COMMENT ON COLUMN
	 * "UNG"."COUPLE"."COUPLE_PROFILE" IS '커플사진'; COMMENT ON COLUMN
	 * "UNG"."COUPLE"."OLD_DATA" IS '1.현재커플유지중 0.헤어짐'; COMMENT ON COLUMN
	 * "UNG"."COUPLE"."ASK" IS '신청날짜'; COMMENT ON COLUMN 
	 * "UNG"."COUPLE"."READ" IS '커프읽음/안읽음'; COMMENT ON COLUMN 
	 * "UNG"."COUPLE"."ACCEPT" IS '커플수락/거절';
	 */
	
    private int id;
    private int proposeId;
    private int accepterId;
    private String name;
    private String message;
    private Date loveDate;
    private String profile;
    private int oldData;
    private Date ask;
    private int read;
    private int accept;
	private int pseudo;

	public int getPseudo() {
		return pseudo;
	}

	public void setPseudo(int pseudo) {
		this.pseudo = pseudo;
	}

	public Couple() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProposeId() {
		return proposeId;
	}

	public void setProposeId(int proposeId) {
		this.proposeId = proposeId;
	}

	public int getAccepterId() {
		return accepterId;
	}

	public void setAccepterId(int accepterId) {
		this.accepterId = accepterId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getLoveDate() {
		return loveDate;
	}

	public void setLoveDate(Date loveDate) {
		this.loveDate = loveDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getOldData() {
		return oldData;
	}

	public void setOldData(int oldData) {
		this.oldData = oldData;
	}

	public Date getAsk() {
		return ask;
	}

	public void setAsk(Date ask) {
		this.ask = ask;
	}

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public int getAccept() {
		return accept;
	}

	public void setAccept(int accept) {
		this.accept = accept;
	}

	@Override
	public String toString() {
		return "Couple [id=" + id + ", proposeId=" + proposeId + ", accepterId=" + accepterId + ", name=" + name
				+ ", message=" + message + ", loveDate=" + loveDate + ", profile=" + profile + ", oldData=" + oldData
				+ ", ask=" + ask + ", read=" + read + ", accept=" + accept + ", pseudo=" + pseudo + "]";
	}



	
	
	
	
}
