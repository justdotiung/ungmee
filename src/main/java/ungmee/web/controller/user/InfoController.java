package ungmee.web.controller.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ungmee.web.dao.UserDao;
import ungmee.web.entity.User;
import ungmee.web.security.CustomUserDetails;




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
	@ResponseBody
	private String delete(Authentication auth) {
		CustomUserDetails custom = (CustomUserDetails) auth.getPrincipal();
		int id = custom.getId();
		//return "redirect:/index";
		return ""+id;
	}
	
}


