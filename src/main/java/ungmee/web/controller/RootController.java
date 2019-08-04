package ungmee.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.dao.UserDao;
import ungmee.web.dao.mybatis.MyBatisUserDao;
import ungmee.web.entity.User;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	private UserDao userDao;
	
	
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
	public String signup(User user ,String echeck) {
		if(echeck == null)
			user.setEcheck("ºñµ¿ÀÇ");
		user.setNickName("gd");
		String pwd = user.getPw();
		System.out.println(pwd);
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		pwd = pwdEncoder.encode(pwd);
		
		user.setPw(pwd);

		userDao.insert(user);
		return "redirect:/index" ; 
		
	}
	
	@RequestMapping("index")
	public String index() {
		return "root.index";
	}
}
