package ungmee.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course/")
public class CourseController {

	@RequestMapping("list")
	public String list(String type) {
		System.out.println("type:"+type);
			return "course."+type;
	}

	@RequestMapping("detail")
	public String detail() {
		return "course.detail";
	}
}
