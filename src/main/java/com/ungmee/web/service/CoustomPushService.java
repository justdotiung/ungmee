package com.ungmee.web.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.ungmee.web.dao.CoupleDao;
import com.ungmee.web.dao.EventDao;
import com.ungmee.web.dao.NoticeDao;
import com.ungmee.web.dao.SoloViewDao;
import com.ungmee.web.dao.UserDao;
import com.ungmee.web.entity.Couple;
import com.ungmee.web.entity.Event;
import com.ungmee.web.entity.Notice;
import com.ungmee.web.entity.SoloView;
import com.ungmee.web.entity.User;
import com.ungmee.web.security.CustomUserDetails;

@Service
public class CoustomPushService implements PushService{
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private EventDao eventDao;
	@Autowired
	private CoupleDao coupleDao;
	@Autowired
	private SoloViewDao svDao;
	
	@Override
	public Couple getProposeDetail(int id) {
		Couple couple = coupleDao.get(id);
		couple.setRead(1);
		coupleDao.update(couple);
		couple = coupleDao.get(id);
		return couple;
	
	}
	
	@Override
	//푸쉬알림 리스트 
	public List<Map<String,Object>> getList(int accepterId){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(); 
		SoloView user = null;
		
		//프로포즈한 상대리스트 
		List<Couple> coupleList = coupleDao.getProposeList(accepterId);
		
		Map<String,Object> couple ;
		//원하는 정보만 가져온다.
		for(Couple c : coupleList) {
			couple = new HashMap<String, Object>();
			user = svDao.get(c.getProposeId());
			couple.put("regDate",c.getAsk());
			couple.put("id", c.getId());
			couple.put("profile",user.getProfile());
			couple.put("sender",user.getId());
			couple.put("title", user.getNickname()+"님이 커플맺기를 신청하셨습니다.");
			couple.put("type","c");
			list.add(couple);
		}
		System.out.println("list " +list.size());
		return list;
		
		
	}
	@Override
	public int getNewPushCount(int userNum) {	
		int pCount = coupleDao.getNewProposeCount(userNum);
		return pCount;
	}

	@Override
	public Map<String,Object> getPushDetails(String type, int id) {
		Notice notice = new Notice();
		Event event = new Event();

		Couple couple = new Couple();
		SoloView sender = new SoloView();
		Map<String,Object> map = new HashMap<String, Object>();
		if(type.equals("c")) {
			couple = coupleDao.get(id);
			couple.setRead(1);
			coupleDao.update(couple);
			couple = coupleDao.get(id);
			System.out.println("durl : "+couple.getId());
			sender = svDao.get(couple.getProposeId());
			map.put("id", couple.getId());
			map.put("profile",sender.getProfile());
			map.put("nickName", sender.getNickname());

			return map;
		}
		else if(type.equals("n")) {
			return map;
		}
		else if(type.equals("e")) {
			return map;
		}
		else
			return null;
	}
	
	@Override
	public List<Map<String,Object>> getNewPushList(int userNum){
		List<Map<String, Object>> list = new ArrayList<>();
		int newList = 0;
		//User user = new User();
		SoloView user = null;
		//System.out.println("AccepterId : "+userNum);
		List<Couple> coupleList = coupleDao.getProposeList(userNum,newList);
	//System.out.println("list : "+coupleList.get(0).getAccepterId());
		Map<String,Object> couple ;
		for(Couple c : coupleList) {
			user = svDao.get(c.getProposeId());
			couple = new HashMap<String, Object>();
			couple.put("regDate",c.getAsk());
			couple.put("id", c.getId());
			couple.put("profile",user.getProfile());
			couple.put("sender",user.getId());
			couple.put("title", user.getNickname()+"님이 커플맺기를 신청하셨습니다.");
			couple.put("type","c");
			list.add(couple);
		}
		System.out.println("new LIst"+list.size());
		return list;
	}
//	public int getNewPushedCount() {
//
//		List<Notice> noticeList = noticeDao.getListByMemberId(1);
//		List<Event> eventList = eventDao.getListByMemberId(1);
//
//		int count = noticeList.size() + eventList.size();
//
//		return count;
//
//	}
//
//	public Map<String, Object> getNewPushedList() {
//
//		List<Notice> noticeList = noticeDao.getListByMemberId(1);
//		List<Event> eventList = eventDao.getListByMemberId(1);
//
//		Map<String, Object> model = new HashMap<String, Object>();
//
//		model.put("noticeList", noticeList);
//		model.put("noticeList", noticeList);
//
//		return model;
//
//	}
//
//	public List<Map<String, Object>> getNewPushedList1() {
//	List<Map<String, Object>> list = new ArrayList<>();
//		
//		List<Notice> noticeList = noticeDao.getListByMemberId(1);
//		Map<String, Object> notice = null;
//		
//		for(Notice n : noticeList) {
//			notice = new HashMap<String, Object>();
//			notice.put("title", n.getTitle());
//			notice.put("regDate", n.getRegDate());
//			notice.put("type", "notice");
//			list.add(notice);
//		}		
//		
//		List<Event> eventList = eventDao.getListByMemberId(1);
//		Map<String, Object> event = null;
//		
//		for(Event n : eventList) {
//			event = new HashMap<String, Object>();
//			event.put("title", n.getTitle());
//			event.put("regDate", n.getRegDate());
//			event.put("type", "notice");
//			list.add(event);
//		}
//		
//		
//		Collections.sort(list, new Comparator<Map<String, Object>>() {
//            /*@Override
//            public int compare(Student s1, Student s2) {
//                if (s1.getScore() < s2.getScore()) {
//                    return -1;
//                } else if (s1.getScore() > s2.getScore()) {
//                    return 1;
//                }
//                return 0;
//            }*/
//
//			@Override
//			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
//				
//				Date d1 = (Date) o1.get("regDate");
//				Date d2 = (Date) o2.get("regDate");				
//				
//				if (d1 < d2) {
//                    return -1;
//                } else if (d1 > d2) {
//                    return 1;
//                }
//                return 0;
//			}
//		}
//		
//		return list;
//
//}


	
}
