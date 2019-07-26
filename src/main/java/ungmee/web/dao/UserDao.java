package ungmee.web.dao;

import java.util.List;

import ungmee.web.entity.Member;

public interface UserDao {
	public List<Member> getList();
	
	public Member get(int id);
	
	public int insert(Member user);
	public int edit(Member user);
}
