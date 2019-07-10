package ungmee.web.controller.member.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller {
	private String list;
	public void setList(String list) {
		this.list = list;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("type");
		System.out.println(id);
		ModelAndView mv = new ModelAndView();
		
		if(id.equals("who")) {
			mv = new ModelAndView("/WEB-INF/view/user/courses/wholist.jsp");
		}
		
		return mv;
	}

}
