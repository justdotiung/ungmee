package com.ungmee.web.dao;


import java.util.List;

import com.ungmee.web.entity.Partner;

public interface PartnerDao {
	public List<Partner> getList();
	
	public Partner get(Integer id);
	public Partner getEmail(String email);
	
	public int insert(Partner partner);
	public int edit(Partner partner);
	public int delete(Partner id);
}
