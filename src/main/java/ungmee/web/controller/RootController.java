package ungmee.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.dao.MemberDao;
import ungmee.web.dao.mybatis.MyBatisMemberDao;
import ungmee.web.entity.Member;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	private MemberDao memberDao;
	
	
	@GetMapping("login")
	public String login() {
		return "root.login";
	}
	
	@RequestMapping("withdraw")
	public String withdraw() {
		return "root.withdraw";
	}
	@GetMapping("signup")
	public String signup() {
		return "root.signup";
	}
	
	@PostMapping("signup")
	public String signup(Member member ,String echeck) {
		if(echeck == null)
			member.setEcheck("ºñµ¿ÀÇ");
		String pwd = member.getPw();
		System.out.println(pwd);
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		pwd = pwdEncoder.encode(pwd);
		
		member.setPw(pwd);

		memberDao.insert(member);
		return "redirect:/index" ; 
		
	}
	
	@RequestMapping("index")
	public String index() {
		return "root.index";
	}
}
