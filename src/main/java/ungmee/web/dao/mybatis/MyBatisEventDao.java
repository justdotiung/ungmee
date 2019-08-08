package ungmee.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ungmee.web.dao.EventDao;
import ungmee.web.entity.Event;
import ungmee.web.entity.EventFile;
import ungmee.web.entity.EventView;




@Repository
public class MyBatisEventDao implements EventDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Event get(int id) {
		EventDao eventDao = sqlSession.getMapper(EventDao.class);
		return eventDao.get(id);
	}

	@Override
	public int insert(Event event) {
		EventDao eventDao = sqlSession.getMapper(EventDao.class);
		return eventDao.insert(event);
	}

	@Override
	public int detail(Event event) {
		EventDao eventDao = sqlSession.getMapper(EventDao.class);
		return eventDao.detail(event);
	}

	@Override
	public int update(Event event) {
		EventDao eventDao = sqlSession.getMapper(EventDao.class);
		return eventDao.update(event);
	}

//	@Override
//	public List<EventView> getList() {
//		EventDao eventDao = sqlSession.getMapper(EventDao.class);
//		return eventDao.getList();
//	}

	@Override
	public int delete(Integer id) {
		EventDao eventDao = sqlSession.getMapper(EventDao.class);
		return eventDao.delete(id);
		
	}

	@Override
	public int getLastId() {
		EventDao eventDao = sqlSession.getMapper(EventDao.class);
		return eventDao.getLastId();
	}


	@Override
	public List<Event> getList() {
		EventDao eventDao = sqlSession.getMapper(EventDao.class);
		return eventDao.getList();
	}





}
