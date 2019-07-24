package ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("CoupleController")
@RequestMapping("/couplediary/")
public class CoupleController {
	@RequestMapping("list")
	public String list() {
		return "couplediary/list";
	}

	@RequestMapping("detail")
	public String detail() {
		return "couplediary/detail";
	}
	
	
	
}
