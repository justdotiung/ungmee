package ungmee.web.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest/notice")
public class NoticeController  {
	
	@RequestMapping("/list")
	public String name() {
		return "guest.notice.list";
	}
	
	@RequestMapping("/detail")
	public String dfsf() {
		return "guest.notice.detail";
	}
}
