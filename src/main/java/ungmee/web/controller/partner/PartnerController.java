package ungmee.web.controller.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.dao.PartnerDao;
import ungmee.web.entity.Partner;


@Controller
@RequestMapping("/partner/")
public class PartnerController {
	@Autowired
	private PartnerDao partnerDao;
	

	@GetMapping("signup")
	public String signup() {
		return "partner/signup";
	}
	
	@PostMapping("signup")
	public String signup(Partner partner) {
		
		String pwd = partner.getPw();

		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		pwd = pwdEncoder.encode(pwd);
		
		partner.setPw(pwd);

		partnerDao.insert(partner);
		return "redirect:/index" ; 
		
	}
	

	
}
