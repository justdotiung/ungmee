package ungmee.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungmee.web.dao.CoupleDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Couple;
import ungmee.web.entity.User;


@Service
public class CoupleService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CoupleDao coupleDao;

	public Couple getCoupleInfo(int id, int uId) {
		User user = userDao.get(uId);
		user.setcState(1);
		userDao.edit(user);
		
		
	}
}
