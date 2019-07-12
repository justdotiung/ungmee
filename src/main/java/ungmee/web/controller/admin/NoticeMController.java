package ungmee.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/notice")
public class NoticeMController {
	@RequestMapping("/reg")
	public String reg() {
		return "admin/notice/reg";
	}
	@RequestMapping("/edit")
	public String edit() {
		return "admin/notice/edit";
	}
	@RequestMapping("/list")
	public String list() {
		return "admin/notice/list";
	}
	@RequestMapping("/detail")
	public String detail() {
		return "admin/notice/detail";
	}
}
