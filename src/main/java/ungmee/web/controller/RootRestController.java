package ungmee.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungmee.web.entity.Solo;
import ungmee.web.entity.User;
import ungmee.web.service.MemberShipService;


@RestController
@RequestMapping("/")
public class RootRestController {
	
	@Autowired
	private MemberShipService memberShipService;
	
	@PostMapping("solo-signup")
	public String signUp(User user, Solo solo) {
		memberShipService.soloRegistration(user, solo);
		return "index";
	}
}
