package com.ungmee.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungmee.web.entity.Partner;
import com.ungmee.web.entity.Solo;
import com.ungmee.web.entity.User;
import com.ungmee.web.service.KakaoAPI;
import com.ungmee.web.service.MemberShipService;

//return값이 html이 아닌 text 형태로 responseBody해줌
@RestController
@RequestMapping("/")
public class RootRestController {
	
	@Autowired
	private MemberShipService memberShipService;
	
	@PostMapping("solo-signup")
	public String signUp(User user, Solo solo) {
		System.out.println(user.toString());
		System.out.println(solo.toString());
		memberShipService.soloRegistration(user, solo);
		return "index";
	}
	
	@GetMapping("duplicate")
	public boolean duplicate(String email) {
		boolean dup = memberShipService.duplicateUserEmail(email);
		return dup;
	}
	
	@PostMapping("partner-signup")
	public int partnersignup(User user, Partner partner) {	
	
		int result = memberShipService.partnerReg(user, partner);
		
		return result ; 	
	}
	
	
}
