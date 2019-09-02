package com.ungmee.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("coupleDiaryController")
@RequestMapping("/couple/diary/")
public class DiaryController {
	
	@RequestMapping("index")
	private String index() {
		return "couple/diary/index";
	}
	@RequestMapping("detail")
	private String detail() {
		return "couple/page/detail";
	}
}
