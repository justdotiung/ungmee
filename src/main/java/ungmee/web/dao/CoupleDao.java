package ungmee.web.dao;

import ungmee.web.entity.Couple;

public interface CoupleDao {
	public Couple get(int id);
	
	public int edit(Couple couple);


}
