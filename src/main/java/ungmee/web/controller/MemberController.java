package ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
	@RequestMapping("/withdraw")
	public String withdraw() {
		return "detail";
	}
}
