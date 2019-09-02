package com.ungmee.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ungmee.web.dao.EventFileDao;
import com.ungmee.web.entity.EventFile;



@Repository
public class MyBatisEventFileDao implements EventFileDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<EventFile> getListByEventId(int eventId) {
		EventFileDao eventFileDao = sqlSession.getMapper(EventFileDao.class);
		return eventFileDao.getListByEventId(eventId);
	}

	@Override
	public int insert(EventFile eventFile) {
		EventFileDao eventFileDao = sqlSession.getMapper(EventFileDao.class);
		return eventFileDao.insert(eventFile);
	}

	@Override
	public int update(EventFile eventFile) {
		EventFileDao eventFileDao = sqlSession.getMapper(EventFileDao.class);
		return eventFileDao.update(eventFile);
	}

	@Override
	public int delete(Integer id) {
		EventFileDao eventFileDao = sqlSession.getMapper(EventFileDao.class);
		return eventFileDao.delete(id);
	}

	







}
