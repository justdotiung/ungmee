package ungmee.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/couple")
public class CoupleController {
	
	@RequestMapping("/edit")
	public String edit() {
		return "admin/couple/edit";
	}
	@RequestMapping("/list")
	public String list() {
		return "admin/couple/list";
	}
	@RequestMapping("/detail")
	public String detail() {
		return "admin/couple/detail";
	}
}
