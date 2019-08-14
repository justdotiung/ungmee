package ungmee.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ungmee.web.dao.SoloDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Solo;
import ungmee.web.entity.User;


@Service
public class CustomMemberShipService implements MemberShipService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private SoloDao soloDao;
	
	@Override
	public User getSenderDetails(int id) {
		User user = userDao.get(id);
		return user;
	}
	
	@Override
	public int soloRegistration(User user, Solo solo) {
		int result = 0;
		BCryptPasswordEncoder bpw = new BCryptPasswordEncoder();
		String pw = bpw.encode(user.getPw());
		user.setPw(pw);
		result = userDao.insert(user);
		User sUser = userDao.getEmail(user.getEmail());
		solo.setId(sUser.getId());
		result = soloDao.insert(solo);
		
		return result;
		
	}
}
