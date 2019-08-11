package ungmee.web.dao;

import java.util.List;

import ungmee.web.entity.Couple;

public interface CoupleDao {
//CoupleRepository (요즘유행)
	public Couple get(int id);
	public int insert(Couple couple);
	public int delete(int proposeId);
	public int edit(Couple couple);
	
	public List<Couple> getProposeList(int accepterId);
	
	public int getProposeCount(int accepterId);
}
