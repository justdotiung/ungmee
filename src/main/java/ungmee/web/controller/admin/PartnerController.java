package ungmee.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/partner")
public class PartnerController {
	
	@RequestMapping("/edit")
	public String edit() {
		return "admin/partner/edit";
	}
	@RequestMapping("/list")
	public String list() {
		return "admin/partner/list";
	}
	@RequestMapping("/detail")
	public String detail() {
		return "admin/partner/detail";
	}
}
