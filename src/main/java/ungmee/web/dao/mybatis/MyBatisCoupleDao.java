package ungmee.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ungmee.web.dao.CoupleDao;
import ungmee.web.entity.Couple;
@Repository
public class MyBatisCoupleDao implements CoupleDao {
	
	
	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public Couple get(int id) {
		CoupleDao coupleDao = sqlSession.getMapper(CoupleDao.class);
		return coupleDao.get(1);
	}

	@Override
	public int edit(Couple couple) {
		// TODO Auto-generated method stub
		return 0;
	}

}
