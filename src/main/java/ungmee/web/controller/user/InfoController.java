package ungmee.web.controller.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.dao.UserDao;
import ungmee.web.entity.User;




@Controller
@RequestMapping("/user/")
public class InfoController {
	@Autowired
	private UserDao userdao;
	
	@GetMapping("detail")
	private String index(Principal principal) {
		//System.out.println(principal.getName());
		
		return "user/detail";
	}
	
	@GetMapping("delete")
	private String delete(Principal principal) {
		//System.out.println(principal.getName());
		principal.getName();
		System.out.println(principal.getName());
		User user =	userdao.getEmail(principal.getName());
		user.setProfile("1");
		System.out.println(user);
		userdao.edit(user);
		return "redirect:/index";
	}
	
}


