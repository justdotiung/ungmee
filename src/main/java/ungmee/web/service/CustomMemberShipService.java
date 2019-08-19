package ungmee.web.service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ungmee.web.dao.SoloDao;
import ungmee.web.dao.SoloViewDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Solo;
import ungmee.web.entity.SoloView;
import ungmee.web.entity.User;
import ungmee.web.security.CustomUserDetails;


@Service
public class CustomMemberShipService implements MemberShipService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private SoloDao soloDao;
	@Autowired
	private SoloViewDao soloViewDao; 
	
	
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
	@Override
	public boolean duplicateUserEmail(String email) {
		User user = userDao.getEmail(email);	
		if(user != null)//존재하면 
			return true;
		return false;
	}
	
	@Override
	public SoloView getSoloInfo(int id) {
		soloViewDao.get(id);		
		return soloViewDao.get(id);
	}

	@Override
	public int editSoloNickName(int id , String nickName) {
		User user = userDao.get(id);
		user.setNickName(nickName);
		return userDao.edit(user);
	}
	
	@Override
	public int editSoloProfile(int id,String profile) {
		User user = userDao.get(id);
		user.setProfile(profile);
		return userDao.edit(user);
	}

	@Override
	public int editSoloPassword(int id, String pwd) {
		User user = userDao.get(id);
		user.setPw(pwd);
		return userDao.edit(user);
	}
	
	@Override
	public int editSoloEvent(int id, String e) {
		User user = userDao.get(id);
		if(e.equals("T"))
			user.setEcheck("F");
		else
			user.setEcheck("T");
		return userDao.edit(user);
	}

	@Override
	public User getEmail(String email) {
		User user = userDao.getEmail(email);
		return user;
	}
}
