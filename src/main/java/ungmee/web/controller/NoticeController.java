package ungmee.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.dao.NoticeDao;
import ungmee.web.entity.Notice;
import ungmee.web.service.NoticeService;


@Controller("NoticeController")
@RequestMapping("/notice/")
public class NoticeController  {
	
//	@Autowired
//	private NoticeService noticeService;
//	//private NoticeDao noticeDao;
//	
//	@RequestMapping("list")
//	public String list(HttpServletRequest request){
//		noticeService.getPageList(request);
//		return "notice/list";
//	}
//	
//	@RequestMapping("detail")
//	public String detail(Notice notice) {
//		noticeService.getDetail(notice);
//		return "notice/detail";
//	}
	
//	@RequestMapping("list")
//	public String list(Model model) {	
//		List<Notice> notice = noticeDao.getList();
//		model.addAttribute("notice", notice);
//		return "notice/list";
//	}
	
//	@RequestMapping("detail")
//	public String detail(Integer id, Model model) {
//		
//		Notice notice = noticeDao.get(id);
//		model.addAttribute("notice", notice);
//		
//		return "notice/detail";
//	}
}
