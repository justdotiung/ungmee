package ungmee.web.service;



import java.util.Date;

import ungmee.web.entity.Couple;



public interface CoupleService {

	public Couple getCoupleInfo(int id);

	public int regInfo(Couple couple, Date sloveDate, int id);

	public int proposeCancel(int pId);

	public int Accept(int uId);

}