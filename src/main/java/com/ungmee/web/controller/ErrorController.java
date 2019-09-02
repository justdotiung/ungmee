package com.ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("errorController")
@RequestMapping("/error/")
public class ErrorController {
	
	@RequestMapping("403")
	public String error403() {
		return "error/403";
	}
	@RequestMapping("access")
	public String errorAccess() {
		return "error/access";
	}

}
