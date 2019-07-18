package ungmee.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;

import ungmee.web.dao.CoupleDao;
import ungmee.web.entity.Couple;

public class MyBatisCoupleDao implements CoupleDao {
	
	
	
	private SqlSession sqlSession; 
	
	@Override
	public Couple get(int id) {
		sqlSession.getMapper(null);
		return null;
	}

	@Override
	public int edit(Couple couple) {
		// TODO Auto-generated method stub
		return 0;
	}

}
