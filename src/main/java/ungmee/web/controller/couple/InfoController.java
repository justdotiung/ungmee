package ungmee.web.controller.couple;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.entity.Couple;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.CoupleService;


@Controller("coupleInfoController")
@RequestMapping("/couple/info/")
public class InfoController {
	
	@Autowired
	private CoupleService coupleService;

	@RequestMapping("index")
	public String index(Model model ,Authentication auth) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		int uId = user.getId();
		Map<String,Object > map = coupleService.getCoupleInfo(uId);
		if(map != null) {
			Couple couple = (Couple) map.get("info");
			model.addAttribute("couple", map);
			model.addAttribute("title",couple.getName());
			return "couple.info.index";
		}
		return "redirect:/error/solo";
	}
	@GetMapping("detail")
	public String detail(Model model ,Authentication auth) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		int uId = user.getId();
		Map<String,Object > map = coupleService.getCoupleInfo(uId);
		if(map != null) {
			Couple couple = (Couple) map.get("info");
			model.addAttribute("couple", map);
			model.addAttribute("title",couple.getName());
			return "couple.info.detail";
		}
		return "redirect:/error/solo";
	}
}

