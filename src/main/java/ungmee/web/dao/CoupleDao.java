package ungmee.web.dao;

import java.util.List;

import ungmee.web.entity.Couple;

public interface CoupleDao {
//CoupleRepository (요즘유행)
	public Couple get(int id);//해당 아이디 커플  정보
	public Couple get(int id, int pId);//해당 커플아이디 프로포즈아이디 커플정보
	public Couple getUser(int id);//해당유저 커플 정보
	
	public int insert(Couple couple);
	public int delete(int proposeId);
	public int edit(Couple couple);
	
	public List<Couple> getProposeList(int accepterId);
	public List<Couple> getProposeList(int accepterId,int state);
	
	public int getNewProposeCount(int accepterId);
}
