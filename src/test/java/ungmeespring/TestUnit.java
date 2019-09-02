package ungmeespring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ungmee.web.dao.CoupleDao;
import ungmee.web.dao.SoloDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Couple;
import ungmee.web.entity.Solo;
import ungmee.web.entity.User;
import ungmee.web.service.CoupleService;
import ungmee.web.service.CoustomCoupleService;

public class TestUnit {

	
	@Test
	public void cancel() {
		String testEmail = "ssong3@c.com";
		CoupleService cTest = new CoustomCoupleService();	
		assertEquals(1, cTest.proposeCancel(testEmail));
	}

}
