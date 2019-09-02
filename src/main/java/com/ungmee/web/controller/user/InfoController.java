package com.ungmee.web.controller.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ungmee.web.dao.UserDao;
import com.ungmee.web.entity.SoloView;
import com.ungmee.web.entity.User;
import com.ungmee.web.security.CustomUserDetails;
import com.ungmee.web.service.CoupleService;
import com.ungmee.web.service.MemberShipService;
import com.ungmee.web.service.PushService;

@Controller
@RequestMapping("/user/")
public class InfoController {
	
	@Autowired
	private MemberShipService service;
	
	@GetMapping("detail")
	public String detail(Model model,Authentication auth) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		SoloView solo =  service.getSoloInfo(user.getId());
		model.addAttribute("solo", solo);
		return "user.detail";
	}
	
	
}


