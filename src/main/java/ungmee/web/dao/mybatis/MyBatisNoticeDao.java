package ungmee.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ungmee.web.dao.NoticeDao;
import ungmee.web.entity.Notice;
import ungmee.web.entity.NoticeView;


@Repository
public class MyBatisNoticeDao implements NoticeDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public NoticeView get(int id) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.get(id);
	}

	@Override
	public int insert(Notice notice) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.insert(notice);
	}

	@Override
	public int detail(Notice notice) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.detail(notice);
	}

	@Override
	public int update(Notice notice) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.update(notice);
	}

	

	@Override
	public int delete(Integer id) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.delete(id);
		
	}


	@Override
	public List<NoticeView> getList() {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getList();
	}

	@Override
	public List<NoticeView> getList(int page) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getList(page);
	}

	@Override
	public int getCount(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
