package ungmee.web.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import ungmee.web.dao.CoupleDao;
import ungmee.web.dao.SoloDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Couple;
import ungmee.web.entity.Solo;
import ungmee.web.entity.User;


@Service
public class CoustomCoupleService implements CoupleService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CoupleDao coupleDao;
	@Autowired
	private SoloDao soloDao;

	public Couple getCoupleInfo(int id, int uId) {
		User user = userDao.get(uId);
	//	user.setcState(1);
		userDao.edit(user);
		Couple couple = coupleDao.get(id);
		couple.setAccept("true");
		return null;
	}

	@Override
	public int regInfo(Couple couple, @DateTimeFormat(pattern = "yyyy-MM-dd")Date sloveDate) {
		couple.setLoveDate(sloveDate);
		coupleDao.insert(couple);
		Solo solo = soloDao.get(couple.getProposeId());
		solo.setcState(0);
		int result = soloDao.update(solo);
		return result;
	}

	@Override
	public int proposeCancel(int pId) {
		coupleDao.delete(pId);
		Solo solo = soloDao.get(pId);
		solo.setcState(-1);
		int result = soloDao.update(solo);
		
		return result;
	}


}
