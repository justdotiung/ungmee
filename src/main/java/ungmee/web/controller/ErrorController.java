package ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ErrorController")
@RequestMapping("/error/")
public class ErrorController {
	
	@RequestMapping("403")
	private String error403() {
		return "error/403";
	}

}
