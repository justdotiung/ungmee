package ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController  {
	
	@RequestMapping("/list")
	public String name() {
		return "list";
	}
	
	@RequestMapping("/detail")
	public String dfsf() {
		return "detail";
	}
}
