package com.ungmee.web.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sse-event/")
public class SseEventController {
	@RequestMapping("pratice")
	public String sseEvent() {
		return "practice";
	}
}
