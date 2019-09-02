package com.ungmee.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ungmee.web.dao.NoticeDao;
import com.ungmee.web.entity.Notice;
import com.ungmee.web.service.NoticeService;


@Controller("noticeController")
@RequestMapping("/notice/")
public class NoticeController  {
	
	@RequestMapping("list")
	public String list() {
		return "notice.list";
	}
	@RequestMapping("detail")
	public String detail() {
		return "notice.detail";
	}
}
