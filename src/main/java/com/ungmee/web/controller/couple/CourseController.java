package com.ungmee.web.controller.couple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("coupleCourseController")
@RequestMapping("/couple/course/")
public class CourseController {
	@GetMapping("reg")
	public String reg() {
		return "couple.course.reg";
	}
}
