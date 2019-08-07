package ungmee.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.dao.UserDao;
import ungmee.web.entity.User;
import ungmee.web.security.CustomUserDetails;

@Controller
@RequestMapping("/user/")
public class InfoController {
	@Autowired
	private UserDao userdao;
	@GetMapping("detail")
	public String index(Model model,Authentication auth) {
		CustomUserDetails cUser = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.get(cUser.getId());
		model.addAttribute("user", user);
		return "user.detail";
	}
}


