package ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("CourseController")
@RequestMapping("/course/")
public class CourseController {
	@GetMapping("reg")
	public String reg() {
		return "course.reg";
	}
}
