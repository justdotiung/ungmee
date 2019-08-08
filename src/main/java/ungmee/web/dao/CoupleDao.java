package ungmee.web.dao;

import ungmee.web.entity.Couple;

public interface CoupleDao {
//	public List<User> getList();
//	
//	public User get(Integer id);
//	public User getEmail(String id);
	
	public int insert(Couple couple);
//	public int edit(User user);
//	public int delete(Integer id);

	public int delete(int proposeId);
}
