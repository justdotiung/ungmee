package ungmee.web.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("GuestDiaryController")
@RequestMapping("/")
public class DiaryController {
	@RequestMapping("list")
	public String login() {
		return "list";
	}
	@RequestMapping("detail")
	public String signup() {
		return "detail";
	}
}
