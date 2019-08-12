package ungmee.web.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.CoupleService;


@Controller("UserCoupleController")
@RequestMapping("/user/couple/")
public class CoupleController {
	
	@Autowired
	private CoupleService coupleService;

	@RequestMapping("index")
	public String index(int id,Authentication auth) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		int uId = user.getId();
		coupleService.getCoupleInfo(id, uId);
		return "user/couple/index";
	}
}
