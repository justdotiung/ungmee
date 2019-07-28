package ungmee.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ungmee.web.dao.MemberDao;
import ungmee.web.entity.Member;
@Repository
public class MyBatisMemberDao implements MemberDao{
	
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public Member get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Member member) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		return dao.insert(member);
	}

	@Override
	public int edit(Member user) {
		// TODO Auto-generated method stub
		return 0;
	}





}
