package ungmee.web.controller.couple;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungmee.web.entity.Couple;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.CoupleService;


@RestController("CoupleInfoRestController")
@RequestMapping("/couple/info/")
public class InfoRestController {
	
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
	@PostMapping("accept")
	public int accept(Authentication auth , int coupleId) {
		CustomUserDetails cUser = (CustomUserDetails) auth.getPrincipal();
		int id = cUser.getId();
		int result = coupleService.proposeAccept(coupleId,id);
		return result;
	}
	@GetMapping("refuse")
	public int reject(Authentication auth, int coupleId) {
		CustomUserDetails cUser = (CustomUserDetails) auth.getPrincipal();
		int id = cUser.getId();
		int result = coupleService.prposeRefuse(coupleId, id);
		return result;
	}
}

