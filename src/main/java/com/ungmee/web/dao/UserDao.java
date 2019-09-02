package com.ungmee.web.dao;


import java.util.List;

import com.ungmee.web.entity.User;

public interface UserDao {
	public List<User> getList();
	
	public User get(int id);
	public User getEmail(String email);
	
	public int insert(User user);
	public int edit(User user);
	public int delete(int id);
}
