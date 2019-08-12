package ungmee.web.dao;

import java.util.List;

import ungmee.web.entity.NoticeFile;

public interface NoticeFileDao {
	public List<NoticeFile> getList(NoticeFile noticeFile);
	public void delete(int id);
	public NoticeFile getData(int id);
	public void insert(NoticeFile noticeFile);
	public int getCount(NoticeFile noticeFile);
}




