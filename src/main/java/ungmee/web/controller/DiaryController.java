package ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("DiaryController")
@RequestMapping("/diary")
public class DiaryController {
	@RequestMapping("list")
	public String login() {
		return "diary/list";
	}
	@RequestMapping("detail")
	public String signup() {
		return "diary/detail";
	}
}
