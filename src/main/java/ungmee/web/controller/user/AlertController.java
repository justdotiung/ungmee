package ungmee.web.controller.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ungmee.web.entity.Couple;
import ungmee.web.entity.SoloView;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.MemberShipService;
import ungmee.web.service.PushService;


@Controller
@RequestMapping("/user/alert/")
public class AlertController {
	
	@Autowired
	private PushService pushService;
	@Autowired
	private MemberShipService msService;

	@GetMapping("sender")
	public String sender(Model model,int id) {
		SoloView sender = msService.getSoloInfo(id);
		model.addAttribute("user", sender);				
		return "user.alert.sender";
	}
	
	@GetMapping("detail")
	private String detail(Model model , @RequestParam(name="t")String type,@RequestParam(name="n")int id) {		
		Map<String,Object> detail = pushService.getPushDetails(type,id);
		model.addAttribute("cUser", detail);
		return "user.alert.detail";
	}
	
	@GetMapping("list")
	public String list(Model model,Authentication auth) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		int accepterId = user.getId();
		List<Map<String,Object>> list = pushService.getList(accepterId);
		model.addAttribute("allList", list);
		return "user.alert.list";
	}
}
