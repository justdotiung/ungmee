package ungmee.web.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("CoupleController")
@RequestMapping("/couplediary/")
public class CoupleController {
	@RequestMapping("list")
	public String list() {
		return "guest/couplediary/list";
	}

	@RequestMapping("detail")
	public String detail() {
		return "guest/couplediary/detail";
	}
	
	
	
}
