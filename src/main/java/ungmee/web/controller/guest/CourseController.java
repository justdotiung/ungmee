package ungmee.web.controller.guest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {

	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		String t = request.getParameter("type");
		if (t == null &&"".equals(t))
			return "error";
		else
			return "course/"+t+"list";
	}

	@RequestMapping("/detail")
	public String detail() {
		return "course/detail";
	}
}
