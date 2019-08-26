package ungmee.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ungmee.web.dao.UserDao;
import ungmee.web.entity.User;
@Repository
public class MyBatisUserDao implements UserDao{
	
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<User> getList() {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		return dao.getList();
	}

	@Override
	public User get(int id) {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		return dao.get(id);
	}
	
	@Override
	public User getEmail(String email) {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		return dao.getEmail(email);
	}

	@Override
	public int insert(User user) {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		return dao.insert(user);
	}

	@Override
	public int edit(User user) {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		return dao.edit(user);
	}


	@Override
	public int delete(int id) {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		return dao.delete(id);
	}



}
