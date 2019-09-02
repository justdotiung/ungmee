package com.ungmee.web.dao;

import com.ungmee.web.entity.Solo;

public interface SoloDao {
	public Solo get(int id);
	public int insert(Solo solo);
	public int update(Solo solo);
	
	
	
}
