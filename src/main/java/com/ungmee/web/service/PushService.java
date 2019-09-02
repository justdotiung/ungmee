package com.ungmee.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ungmee.web.entity.Couple;
import com.ungmee.web.entity.SoloView;

@Service
public interface PushService {

	//보낸사람 정보
	//public SoloView getSendUserDetails(int id, int pId);
	//보낸 내용중 프로포즈 정보
	public Couple getProposeDetail(int id);
	//새로운 알람 갯수
	public int getNewPushCount(int userNum);
	//알람 리스트
	public List<Map<String, Object>> getList(int accepterId);
	//새로운 알람 리스트
	public List<Map<String,Object>> getNewPushList(int userNum);
	//알람 내용 정보
	public Map<String,Object> getPushDetails(String type, int id);
}
