package ungmee.web.dao.mybatis;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ungmee.web.dao.SoloViewDao;
import ungmee.web.entity.SoloView;
@Repository
public class MyBatisSoloViewDao implements SoloViewDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Override
	public SoloView get(int id) {
		SoloViewDao soloDao = sqlSession.getMapper(SoloViewDao.class);
		return soloDao.get(id);
	}

}
