package ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/couple/")
public class CoupleController {
	@RequestMapping("list")
	public String list() {
		return "couple/list";
	}

	@RequestMapping("detail")
	public String detail() {
		return "couple/detail";
	}
}
