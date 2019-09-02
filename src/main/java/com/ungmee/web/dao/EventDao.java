package com.ungmee.web.dao;

import java.util.List;

import com.ungmee.web.entity.Event;
import com.ungmee.web.entity.EventFile;
import com.ungmee.web.entity.EventView;




public interface EventDao {
	public Event get(int id);
	public int insert(Event event);
	public int detail(Event event);
	public int update(Event evnet);
	public int delete(Integer id);

	
	List<Event> getList();
	public int getLastId();
	
	
}
