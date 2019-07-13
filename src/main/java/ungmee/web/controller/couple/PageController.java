package ungmee.web.controller.couple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/couple/page/")
public class PageController {
	
	@RequestMapping("index")
	private String index() {
		return "couple/page/index";
	}
	@RequestMapping("detail")
	private String detail() {
		return "couple/page/index";
	}
}
