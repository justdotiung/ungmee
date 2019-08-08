package ungmee.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ungmee.web.dao.PartnerDao;
import ungmee.web.entity.Partner;


@Repository
public class MyBatisPartnerDao implements PartnerDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Partner> getList() {
		PartnerDao partnerDao = sqlSession.getMapper(PartnerDao.class);
		return partnerDao.getList();
	}

	@Override
	public Partner get(Integer id) {
		PartnerDao partnerDao = sqlSession.getMapper(PartnerDao.class);
		return partnerDao.get(id);
	}

	@Override
	public Partner getEmail(String email) {
		PartnerDao partnerDao = sqlSession.getMapper(PartnerDao.class);
		return partnerDao.getEmail(email);
	}

	@Override
	public int insert(Partner partner) {
		PartnerDao partnerDao = sqlSession.getMapper(PartnerDao.class);
		return partnerDao.insert(partner);
	}

	@Override
	public int edit(Partner partner) {
		PartnerDao partnerDao = sqlSession.getMapper(PartnerDao.class);
		return partnerDao.edit(partner);
	}

	@Override
	public int delete(Partner id) {
		PartnerDao partnerDao = sqlSession.getMapper(PartnerDao.class);
		return partnerDao.delete(id);
	}


	

}
