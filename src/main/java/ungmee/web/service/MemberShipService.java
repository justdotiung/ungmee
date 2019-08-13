package ungmee.web.service;

import ungmee.web.entity.Solo;
import ungmee.web.entity.User;

public interface MemberShipService {
	public User getSenderDetails(int id);
	public int soloRegistration(User user, Solo solo);
}
