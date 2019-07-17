package ungmee.web.controller.couple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("CoupleDiaryController")
@RequestMapping("/couple/page/")
public class DiaryController {
	
	@RequestMapping("index")
	private String index() {
		return "couple/page/index";
	}
	@RequestMapping("detail")
	private String detail() {
		return "couple/page/detail";
	}
}
