package com.ungmee.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ungmee.web.entity.Notice;
import com.ungmee.web.entity.NoticeView;


public interface NoticeDao {
	public NoticeView getView(int id);
	public Notice get(int id);
	public int insert(Notice notice);
	public int detail(Notice notice);
	public int update(Notice notice);
	public int delete(Integer id);

	public int getCount(Notice notice);

	
	public List<NoticeView> getList();
	public List<NoticeView> getList(Integer page);
	public List<NoticeView> getList(Integer page, @Param("field")String field, String query);
	
	Notice getPrev(int id) throws ClassNotFoundException, SQLException;
	Notice getNext(int id) throws ClassNotFoundException, SQLException;
	
}
