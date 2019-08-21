package ungmee.web.dao.mybatis;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ungmee.web.dao.CoupleDao;
import ungmee.web.entity.Couple;

@Repository
public class MyBatisCoupleDao implements CoupleDao{
	
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Couple couple) {
		CoupleDao coupleDao = sqlSession.getMapper(CoupleDao.class);
		return coupleDao.insert(couple);
	}

	@Override
	public int delete(int proposeid) {
		CoupleDao coupleDao = sqlSession.getMapper(CoupleDao.class);
		return coupleDao.delete(proposeid);
	}

	@Override
	public List<Couple> getProposeList(int accepterId) {		
		return getProposeList(accepterId, 2);
	}

	@Override
	public List<Couple> getProposeList(int accepterId, int state) {
		CoupleDao coupleDao = sqlSession.getMapper(CoupleDao.class);
		return coupleDao.getProposeList(accepterId, state);
	}

	@Override
	public int getNewProposeCount(int accepterId) {
		CoupleDao coupleDao = sqlSession.getMapper(CoupleDao.class);
		return coupleDao.getNewProposeCount(accepterId);
	}

	@Override
	public Couple get(int id) {
		return get(id,-1);
	}
	
	@Override
	public Couple get(int id, int pId) {
		CoupleDao coupleDao = sqlSession.getMapper(CoupleDao.class);
		return coupleDao.get(id,pId);
	}

	@Override
	public Couple getUser(int id) {
		CoupleDao coupleDao = sqlSession.getMapper(CoupleDao.class);	
		return coupleDao.getUser(id);
	}

	@Override
	public int edit(Couple couple) {
		CoupleDao coupleDao = sqlSession.getMapper(CoupleDao.class);
		return coupleDao.edit(couple);
	}


	
}
