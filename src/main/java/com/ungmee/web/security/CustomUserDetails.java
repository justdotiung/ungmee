package com.ungmee.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ungmee.web.dao.RoleCategoryDao;
import com.ungmee.web.entity.RoleCategory;
import com.ungmee.web.entity.User;

public class CustomUserDetails extends User implements UserDetails {

	
	private RoleCategoryDao categoryDao;


	public void setCategoryDao(RoleCategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public CustomUserDetails() {
		// TODO Auto-generated constructor stub
	}

	public CustomUserDetails(User user) {
		setId(user.getId());
		setEmail(user.getEmail());
		setPw(user.getPw());
		setEnabled(user.getEnabled());
		setRoleId(user.getRoleId());
		setNickName(user.getNickName());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println(getRoleId());
		RoleCategory category = categoryDao.get(getRoleId());
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(category.getAuth()));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getPw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		boolean enabled = false;
		int result = getEnabled();

		if (result == 1)
			enabled = true;
		return enabled;
	}

}
