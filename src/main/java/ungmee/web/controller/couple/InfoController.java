package ungmee.web.controller.couple;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.entity.Couple;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.CoupleService;


@Controller("coupleInfoController")
@RequestMapping("/couple/")
public class InfoController {
	
	@Autowired
	private CoupleService coupleService;

	@RequestMapping("info")
	public String index(Model model ,Authentication auth) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		int uId = user.getId();
		Couple couple = coupleService.getCoupleInfo(uId);
		model.addAttribute("couple", couple);
		model.addAttribute("title",couple.getCoupleName());
		return "couple.info";
	}
}

