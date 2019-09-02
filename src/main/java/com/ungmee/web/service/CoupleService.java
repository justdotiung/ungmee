package com.ungmee.web.service;



import java.util.Date;
import java.util.Map;

import com.ungmee.web.entity.Couple;



public interface CoupleService {
	//커플정보
	public Couple get(int id);
	//커플의 모든 정보
	public Map<String, Object> getCoupleInfo(int id);
	//커플등록
	public int regInfo(Couple couple, Date sloveDate, int id);
	//프로포즈 취소
	public int proposeCancel(String email);
	//프로포즈 수락
	public int proposeAccept(int coupleId, int aId);
	//프로포즈 거절
	public int prposeRefuse(int coupleId);
	//이름 변경
	public int nameUpdate(String name, int id);
	//상태 변경
	public int messageUpdate(String message, int id);
	//프로필 변경
	public int editProfile(int id, String fileName);
	//커플 헤어지기
	public int breakUp(int id);

}