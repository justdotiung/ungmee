package com.ungmee.web.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ungmee.web.dao.RoleCategoryDao;
import com.ungmee.web.dao.UserDao;
import com.ungmee.web.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleCategoryDao categoryDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails details = null;
		User user = userDao.getEmail(username);
		details = new CustomUserDetails(user);
		details.setCategoryDao(categoryDao);
		
		System.out.println("CustomUserDetails : "+details.getEmail());
		return details;
	}
}
