package ungmee.web.controller.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ungmee.web.dao.UserDao;
import ungmee.web.entity.SoloView;
import ungmee.web.entity.User;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.MemberShipService;

@Controller
@RequestMapping("/user/")
public class InfoController {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private MemberShipService service;
	
	@GetMapping("detail")
	public String detail(Model model,Authentication auth) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		SoloView solo =  service.getSoloInfo(user.getId());
		model.addAttribute("solo", solo);
		return "user.detail";
	}
	@GetMapping("sender")
	public String index(Model model,int id) {
		SoloView user = service.getSoloInfo(id);
		model.addAttribute("user", user);
		return "user/sender";
	}
	
}


