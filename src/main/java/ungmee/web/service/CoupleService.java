package ungmee.web.service;



import java.util.Date;

import ungmee.web.entity.Couple;



public interface CoupleService {
	//커플정보
	public Couple getCoupleInfo(int id);
	//커플등록
	public int regInfo(Couple couple, Date sloveDate, int id);
	//프로포즈 취소
	public int proposeCancel(int pId);
	//프로포즈 수락
	public int proposeAccept(int coupleId, int uId);
	//프로포즈 거절
	public int prposeRefuse(int coupleId, int uId);

}