package ungmee.web.service;



import java.util.Date;

import ungmee.web.entity.Couple;



public interface CoupleService {

	public Couple getCoupleInfo(int id, int uId);

	public int regInfo(Couple couple, Date sloveDate);

	public int proposeCancel(int pId);

}