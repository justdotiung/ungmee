package ungmee.web.controller.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungmee.web.entity.Couple;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.PushService;


@RestController
@RequestMapping("/user/alert/")
public class AlertRestController {
	
	@Autowired
	private PushService pushService;

	@GetMapping("detail1")
	private String detail(Model model , int id) {
		Couple couple = pushService.getProposeDetail(id);
		model.addAttribute("couple", couple);
		return "user/alert/detail";
	}
	@GetMapping("list1")
	public String propose(Model model,Authentication auth) {
		CustomUserDetails cUser = (CustomUserDetails) auth.getPrincipal();
		int userNum = cUser.getId();
		List<Map<String,Object>> list = pushService.getNewPushList(userNum);
		model.addAttribute("list", list);
		return "user/alert/list";
	}
}
