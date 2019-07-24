package ungmee.web.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest/")
public class PublicController {
	@RequestMapping("login")
	public String login() {
		return "guest/login";
	}
	@GetMapping("signup")
	public String signup() {
		return "guest/signup";
	}
	@PostMapping("signup")
	public String signup(String type
			,String name
			,String email
			,String pw
			,String terms1
			,String terms2
			,String bDay
			,String lDay
			,String gender		
			) {
	
		
		System.out.println(type);
		System.out.println(name);
		System.out.println(email);
		System.out.println(pw);
		System.out.println(terms1);
		System.out.println(terms2);
		System.out.println(bDay);
		System.out.println(lDay);
		System.out.println(gender);
		
		return "guest/login";
	}
	
	@RequestMapping("index")
	public String index() {
		return "root.index";
	}
}
