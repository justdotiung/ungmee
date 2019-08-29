package ungmee.web.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ungmee.web.dao.PartnerDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Partner;
import ungmee.web.entity.Solo;
import ungmee.web.entity.SoloView;
import ungmee.web.entity.User;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.MemberShipService;
import ungmee.web.service.PushService;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PartnerDao partnerDao;
	@Autowired
	private PushService pushService;
	@Autowired
	private MemberShipService msService;
	
	
	@GetMapping("login")
	public String login() {
		return "root.login";
	}
	
	@RequestMapping("withdraw")
	public String withdraw() {
		return "root.withdraw";
	}
	@GetMapping("signup")
	public String signup() {
		return "root.signup";
	}
//	@GetMapping("map")
//	public String map() {
//		return "root.map";
//	}
//	

	
	//스프링만 사용할 때 ENTITY와 JSP 변수명 연결해주기 1
//	@PostMapping("partner-signup")
//	public String partnersignup(User user, Partner partner, @RequestParam("boss-name")String bName, 

//		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
//		pwd = pwdEncoder.encode(pwd);
//		
//		user.setPw(pwd);
		
//스프링만 사용할 때 ENTITY와 JSP 변수명 연결해주기 2		
//		partner.setbName(bName); //사장님이름
//		partner.setpName(pName); //상호명
//		partner.setpType(pType); //업종
		
		
		//user는 공통회원정보를 담고있는 객체(이메일,비번,닉네임) db 커밋되기 객체 다. 
		//insertUser 는 지금 회원 가입한 사람의 정보를 담고 있는 객체 db 커밋된 객체 를 가져온다.
		

//		
//		return "redirect:/index" ; 	
//	}
	@RequestMapping("index")
	public String index(Model model,Authentication auth,HttpServletRequest req) {
		
		model.addAttribute("title","qkRNa");
//		if(auth != null) {
//			CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
//			int id = user.getId();
//			SoloView solo = msService.getSoloInfo(id);			
//			int count = pushService.getNewPushCount(id);
//			List<Map<String,Object>> list = pushService.getNewPushList(id);
//			model.addAttribute("count", count);
//			model.addAttribute("list", list);
//			model.addAttribute("user", solo);
//		}
//		int count = pushService.getNewPushedCount();

//		Map<String, Object> map = pushService.getNewPushedList();
//		model.addAttribute("eventList", map.get("eventList"));
		return "root.index";
	}
}
