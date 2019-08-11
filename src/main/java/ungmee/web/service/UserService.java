package ungmee.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ungmee.web.dao.UserDao;
import ungmee.web.entity.User;


@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User getSenderDetails(int id) {
		User user = userDao.get(id);
		
		return user;
	}
}
