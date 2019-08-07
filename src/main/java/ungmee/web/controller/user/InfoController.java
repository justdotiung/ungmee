package ungmee.web.controller.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.dao.CoupleDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Couple;
import ungmee.web.entity.User;
import ungmee.web.security.CustomUserDetails;

@Controller
@RequestMapping("/user/")
public class InfoController {
	
	@Autowired
	private UserDao userdao;
	@Autowired
	private CoupleDao coupledao;
	
	
	@GetMapping("detail")
	public String index(Model model,Authentication auth) {
		CustomUserDetails cUser = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.get(cUser.getId());
		model.addAttribute("user", user);
		return "user.detail";
	}
	@PostMapping("propose")
	public String propose(Couple couple,String email,@DateTimeFormat(pattern = "yyyy-MM-dd")Date sloveDate, Authentication auth,Model model) {
		System.out.println("propose couple : "+couple.toString());
		System.out.println("propose email : "+email);
		
		CustomUserDetails custom = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.getEmail(custom.getEmail());
		User aUser = userdao.getEmail(email);
		
		couple.setAccepterId(aUser.getId());
	
		couple.setLoveDate(sloveDate);
		coupledao.insert(couple);
		
		
		user.setcState(0);
		userdao.edit(user);
		System.out.println("신청자 프로포즈 신청 상황 :"+user.getcState());
		model.addAttribute("user", user);
		return "user.detail";
	}
}


