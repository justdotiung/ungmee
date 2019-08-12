package ungmee.web.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootRestController {

	@PostMapping("solo/signup")
	public String signUp() {
			
		return null;
	}
}
