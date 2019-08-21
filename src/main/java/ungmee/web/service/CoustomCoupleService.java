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
	
	@Override
	public Couple getCoupleInfo(int uId) {
		Couple couple = coupleDao.get(uId);
		return couple;
	}

	@Override
	public int regInfo(Couple couple, @DateTimeFormat(pattern = "yyyy-MM-dd")Date sloveDate,int id) {
		couple.setLoveDate(sloveDate);
		couple.setProposeId(id);
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

	@Override
	public int proposeAccept(int id,int uId) {
		Solo acceptSolo = soloDao.get(uId); //수락자 아이디 
		Couple couple = coupleDao.get(id,uId); //커플 수락 아이디
		Solo proposeSolo = soloDao.get(couple.getProposeId());//프로포즈 아이디

		acceptSolo.setcState(1);
		soloDao.update(acceptSolo);
		
		proposeSolo.setcState(1);
		soloDao.update(proposeSolo);
		
		couple.setAccept(1);
		int result  = coupleDao.edit(couple);
		
		return result;
	}

	@Override
	public int prposeRefuse(int coupleId, int id) {
		Couple couple = coupleDao.get(coupleId,id); //커플 수락 아이디
		couple.setAccept(0);
		int result = coupleDao.edit(couple);
		return result;
	}


}
