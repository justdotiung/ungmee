package ungmee.web.dao;

import java.util.List;

import ungmee.web.entity.Notice;


public interface NoticeDao {
	public Notice get(int id);
	public int insert(Notice notice);
	public int detail(Notice notice);
	public int update(Notice notice);
	public int delete(Integer id);
	
	List<Notice> getList();
	
	
}
