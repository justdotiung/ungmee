package ungmee.web.dao;

import java.util.List;

import ungmee.web.entity.Couple;

public interface CoupleDao {
//CoupleRepository (요즘유행)
//	public List<User> getList();
//	
//	public User get(Integer id);
//	public User getEmail(String id);
	
	public int insert(Couple couple);
//	public int edit(User user);
	public int delete(int proposeId);
	public List<Couple> getProposeList(int accepterId);
}
