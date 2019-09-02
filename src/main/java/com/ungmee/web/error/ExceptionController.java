package com.ungmee.web.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error/")
public class ExceptionController {
	@GetMapping("couple")
	public String couple() {
		return "error.couple";
	}
	@GetMapping("solo")
	public String solo() {
		return "error.solo";
	}
}
