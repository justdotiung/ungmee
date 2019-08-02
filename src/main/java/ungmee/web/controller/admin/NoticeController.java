package ungmee.web.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ungmee.web.dao.NoticeDao;
import ungmee.web.entity.Notice;
import ungmee.web.security.CustomUserDetails;

@Controller("adminNoticeController")
@RequestMapping("admin/notice/")
public class NoticeController {
	@Autowired
	private NoticeDao noticeDao;
	
	@GetMapping("reg")
	public String reg() {
		return "admin/notice/reg";
	}
	@PostMapping("reg")
	public String reg(Notice notice
			,String category
			/*,Authentication auth*/) {
		notice.setAdminId(61);
		//CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
		//notice.setAdminId(userDetails.getId()); //����� �α��� ����
		//UserDetails p.640
		//System.out.println(principal.getName());
		System.out.println(notice);
		noticeDao.insert(notice);
		
		return "redirect:list";
	}
	@GetMapping("edit")
	public String edit(Integer id, Model model) {
		model.addAttribute("notice",noticeDao.get(id));
		
		return "admin/notice/edit";
	}
	@PostMapping("edit")
	public String edit(Notice notice) {
		
		Notice n = noticeDao.get(notice.getId());
		n.setTitle(notice.getTitle());
		n.setContent(notice.getContent());
		
		noticeDao.update(n);
		return "redirect:detail?id="+notice.getId();
	}
	@RequestMapping("list")
	public String list(Model model) {
		
		List<Notice> notice = noticeDao.getList();
		model.addAttribute("notice",notice);
		
		return "admin/notice/list";
	}
	@GetMapping("detail")
	public String detail(Integer id, Model model) {
		
		Notice notice = noticeDao.get(id);
		model.addAttribute("notice",notice);
		
		return "admin/notice/detail";
	}
}