package ungmee.web.dao;


import java.util.List;

import ungmee.web.entity.User;

public interface UserDao {
	public List<User> getList();
	
	public User get(Integer id);
	public User getEmail(String id);
	
	public int insert(User user);
	public int edit(User user);
	public int delete(Integer id);
}
