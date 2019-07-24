package ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	@RequestMapping("/login")
	public String login() {
		return "guest.login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "guest.logout";
	}
	@RequestMapping("/withdraw")
	public String withdraw() {
		return "guest.withdraw";
	}
}
