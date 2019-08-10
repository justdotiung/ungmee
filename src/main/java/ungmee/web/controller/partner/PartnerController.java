package ungmee.web.controller.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ungmee.web.dao.PartnerDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Partner;
import ungmee.web.entity.User;


@Controller
@RequestMapping("/partner/")
public class PartnerController {
	@Autowired
	private PartnerDao partnerDao;
	@Autowired
	private UserDao userDao;
	

	@GetMapping("partner-signup")
	public String signup() {
		return "partner/signup";
	}
	
	@PostMapping("partner-signup")
	public String signup(User user, Partner partner, @RequestParam("boss-name")String bName, 
			@RequestParam("partner-name")String pName, @RequestParam("partner-type")String pType ) {
		
		String pwd = user.getPw();
		System.out.println("signup-pwd:"+ pwd);
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		pwd = pwdEncoder.encode(pwd);
		
		user.setPw(pwd);
		partner.setbName(bName);
		partner.setpName(pName);
		partner.setpType(pType);

		partnerDao.insert(partner);
		
		
		return "redirect:/index" ; 
		
	}
	

	
}
