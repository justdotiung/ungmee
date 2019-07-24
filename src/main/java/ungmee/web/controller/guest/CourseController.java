package ungmee.web.controller.guest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {

	@RequestMapping("/list")
	public String list(String type) {
			return "guest/course/"+type+"list" ;
	}

	@RequestMapping("/detail")
	public String detail() {
		return "course/detail";
	}
}
