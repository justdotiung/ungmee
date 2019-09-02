package com.ungmee.web.dao;

import java.util.List;

import com.ungmee.web.entity.Couple;

public interface CoupleDao {
//CoupleRepository (요즘유행)
	public Couple get(int id);//해당 아이디 커플  정보
	public Couple getUser(int id);//해당유저 커플 정보
	public Couple getSender(int id);//프로포즈아이디한 커플 정보
	
	public int insert(Couple couple);
	public int update(Couple couple);
	public int delete(int coupleId);
	
	public List<Couple> getProposeList(int accepterId);
	public List<Couple> getProposeList(int accepterId,int state);
	
	public int getNewProposeCount(int accepterId);
}
