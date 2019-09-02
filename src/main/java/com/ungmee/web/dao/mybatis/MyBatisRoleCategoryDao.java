package com.ungmee.web.dao.mybatis;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ungmee.web.dao.RoleCategoryDao;
import com.ungmee.web.entity.RoleCategory;

@Repository
public class MyBatisRoleCategoryDao implements RoleCategoryDao{
	@Autowired
	private SqlSessionTemplate sqlSesstion;
	
	
	@Override
	public RoleCategory get(int id) {
		RoleCategoryDao roleCategoryDao = sqlSesstion.getMapper(RoleCategoryDao.class);
		return roleCategoryDao.get(id);
	}

	
}
