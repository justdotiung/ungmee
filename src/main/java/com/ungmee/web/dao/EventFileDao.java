package com.ungmee.web.dao;

import java.util.List;

import com.ungmee.web.entity.EventFile;

public interface EventFileDao {
	List<EventFile> getListByEventId(int eventId);

	int insert(EventFile eventFile);
	int update(EventFile eventFile);
	int delete(Integer id);
	
	
}
