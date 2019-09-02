package ungmeespring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ungmee.web.dao.CoupleDao;
import com.ungmee.web.dao.SoloDao;
import com.ungmee.web.dao.UserDao;
import com.ungmee.web.entity.Couple;
import com.ungmee.web.entity.Solo;
import com.ungmee.web.entity.User;
import com.ungmee.web.service.CoupleService;
import com.ungmee.web.service.CoustomCoupleService;

public class TestUnit {

	
	@Test
	public void cancel() {
		String testEmail = "ssong7@c.com";
		CoupleService cTest = new CoustomCoupleService();	
		assertEquals(1, cTest.proposeCancel(testEmail));
	}

}
