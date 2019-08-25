package ungmee.web.service;



import ungmee.web.entity.Solo;
import ungmee.web.entity.SoloView;
import ungmee.web.entity.User;

public interface MemberShipService {
	public int soloRegistration(User user, Solo solo);
	public SoloView getSoloInfo(int id);
	boolean duplicateUserEmail(String email);
	
	public int editSoloNickName(int id, String nickName);
	public int editSoloProfile(int id, String file);
	public int editSoloPassword(int id, String pw);
	public int editSoloEvent(int id, String e);
	public User getEmail(String email);
}
