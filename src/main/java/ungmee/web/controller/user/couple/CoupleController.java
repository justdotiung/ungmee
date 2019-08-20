package ungmee.web.controller.user.couple;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.entity.Couple;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.CoupleService;


@Controller("UserCoupleController")
@RequestMapping("/user/couple/")
public class CoupleController {
	
	@Autowired
	private CoupleService coupleService;

	@RequestMapping("index")
	public String index(Model model ,Authentication auth) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		int uId = user.getId();
		Couple couple = coupleService.getCoupleInfo(uId);
		model.addAttribute("couple", couple);
		return "user/couple/index";
	}
}
