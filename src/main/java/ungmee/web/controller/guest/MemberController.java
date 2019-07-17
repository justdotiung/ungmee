package ungmee.web.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/index";
	}
	@RequestMapping("/withdraw")
	public String withdraw() {
		return "redirect:/index";
	}
}
