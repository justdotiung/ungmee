package ungmee.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ungmee.web.dao.UserDao;
import ungmee.web.entity.Member;
@Repository
public class MyBatisUserDao implements UserDao{
	
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member get(int id) {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		return dao.get(id);
	}

	@Override
	public int insert(Member user) {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		return dao.insert(user);
	}

	@Override
	public int edit(Member user) {
		// TODO Auto-generated method stub
		return 0;
	} 


}
