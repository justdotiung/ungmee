package ungmee.web.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error/")
public class ExceptionController {
	@RequestMapping("couple")
	public String couple() {
		return "error.couple";
	}
}
