package ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PublicController {
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	@RequestMapping("signup")
	public String signup() {
		return "signup";
	}
	@RequestMapping("index")
	public String index() {
		return "index";
	}
}
