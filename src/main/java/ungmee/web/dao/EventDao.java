package ungmee.web.dao;

import java.util.List;

import ungmee.web.entity.Event;
import ungmee.web.entity.EventFile;
import ungmee.web.entity.EventView;




public interface EventDao {
	public Event get(int id);
	public int insert(Event event);
	public int detail(Event event);
	public int update(Event evnet);
	public int delete(Integer id);

	
	List<Event> getList();
	public int getLastId();
	
	
}
