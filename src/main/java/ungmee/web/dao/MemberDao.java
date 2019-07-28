package ungmee.web.dao;


import ungmee.web.entity.Member;

public interface MemberDao {
	public Member get(int id);
	
	public int insert(Member member);
	public int edit(Member member);
}
