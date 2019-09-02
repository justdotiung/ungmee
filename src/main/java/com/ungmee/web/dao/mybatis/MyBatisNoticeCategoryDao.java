package com.ungmee.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ungmee.web.dao.NoticeCategoryDao;
import com.ungmee.web.dao.NoticeDao;
import com.ungmee.web.entity.Notice;
import com.ungmee.web.entity.NoticeView;


@Repository
public class MyBatisNoticeCategoryDao implements NoticeCategoryDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

//	@Override
//	public Notice get(int id) {
//		NoticeCategoryDao noticeCategoryDao = sqlSession.getMapper(noticeCategoryDao.class);
//		return noticeCategoryDao.get(id);
//	}
//
//	@Override
//	public int detail(Notice notice) {
//		NoticeCategoryDao noticeCategoryDao = sqlSession.getMapper(noticeCategoryDao.class);
//		return noticeCategoryDao.detail(notice);
//	}


	

}
