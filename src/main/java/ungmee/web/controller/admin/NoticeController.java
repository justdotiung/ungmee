package ungmee.web.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;

import ungmee.web.dao.NoticeDao;
import ungmee.web.entity.Event;
import ungmee.web.entity.EventFile;
import ungmee.web.entity.Notice;
import ungmee.web.entity.NoticeView;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.NoticeService;

@Controller("adminNoticeController")
@RequestMapping("/admin/notice/")
public class NoticeController {
	@Autowired
//	private NoticeDao noticeDao;
	private NoticeService noticeService;
	@GetMapping("reg")
	public String reg(Model model, Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		String nickName = details.getNickName();
		model.addAttribute("writer", nickName);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		model.addAttribute("time",sdf.format(date));
		//model.addAttribute("notice",notice);
		return "admin.notice.reg";
	}

	@PostMapping("reg")
	public String reg(Notice notice, Authentication auth)
			throws IOException {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		int id = details.getId();//유저아이디( 관리자 아이디 primaryKey )
		notice.setWriterId(id); //notice 객체에  작성자 아이디 세팅 해줌.
		/* ,Authentication auth */
		//notice.setAdminId(61);
		// CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
		// notice.setAdminId(userDetails.getId()); 
		// UserDetails p.640
		// System.out.println(principal.getName());
		//noticeDao.insert(notice);

		noticeService.regNotice(notice);
		return "redirect:list";
	}
	
	@GetMapping("edit")
	public String edit(int id, Model model) {
		//model.addAttribute("notice", noticeDao.get(eid));
		//System.out.println(noticeDao.get(eid));
		
		model.addAttribute("notice",noticeService.getNoticeView(id));
		return "admin.notice.edit";
	}

	@PostMapping("edit")
	public String edit(Notice notice) {

//		Notice n = noticeDao.get(notice.getId());
//		n.setCategory(notice.getCategory());
//		n.setTitle(notice.getTitle());
//		n.setContent(notice.getContent());
//		noticeDao.update(n);
		
		int result = noticeService.updateNotice(notice);
		if(result == 1 )
			return "redirect:list";
		else  
			return  "error";
	} 

	@RequestMapping("list")
	public String list(@RequestParam(name="p", defaultValue="1") Integer page, 
			Model model, Authentication auth) {
		
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		String nickName = details.getNickName();
		model.addAttribute("writer", nickName);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		model.addAttribute("time",sdf.format(date));
//		List<Notice> notice = noticeDao.getList();
//		model.addAttribute("notice", notice);
//		int p = 1;
//		if(page !=null)
//			p= page;
		List<NoticeView> pageList = noticeService.getNoticeViewList(page);
		model.addAttribute("noticeView", pageList);
		
		return "admin.notice.list";
	}
	
	@GetMapping("list-json")
	@ResponseBody
	public String listJson(@RequestParam(name="p", defaultValue="1") Integer page, 
			Model model, Authentication auth) {
		
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		String nickName = details.getNickName();
		model.addAttribute("writer", nickName);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		model.addAttribute("time",sdf.format(date));
//		List<Notice> notice = noticeDao.getList();
//		model.addAttribute("notice", notice);
//		int p = 1;
//		if(page !=null)
//			p= page;
		
//		page =1;
		List<NoticeView> noticeList = noticeService.getNoticeViewList(page);
		Gson gson = new Gson();
		
		
		return gson.toJson(noticeList);
	}
	

	@GetMapping("del")
	public String del(int id) {
		noticeService.deleteNotice(id);
//		System.out.println(noticeDao.get(did));
//		noticeDao.delete(did);
		return "redirect:list";
	}
	
//	@PostMapping("upload")
//	@ResponseBody
//	public String upload(MultipartFile file, HttpServletRequest request)
//			throws IOException {
//		
//		
//		noticeService.upload(file, request);
//		return "/upload/"+ fileName;
//	}
	
	// 스마트에디터 파일
//	@RequestMapping(value="/upload", method=RequestMethod.POST)
//	public @ResponseBody String photoUpload(MultipartHttpServletRequest request, HttpServletResponse response, Model model){
//	        System.out.println("upload controller");
//	 
//	        try {
//	            Iterator<String> itr = request.getFileNames();
//	            MultipartFile mpf;
//	 
//	            while (itr.hasNext()) {
//	                mpf = request.getFile(itr.next());
//	                System.out.println(mpf.getOriginalFilename());
//	                
//	                String filename = mpf.getOriginalFilename();
//	                String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
//	                filename_ext = filename_ext.toLowerCase();
//	                String dftFilePath = request.getSession().getServletContext().getRealPath("/");
//	 
//	                //파일 기본경로 _ 상세경로
//	                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
//	                String folderName = formatter.format(new java.util.Date());     
//	                
//	                String filePath = dftFilePath +  "upload" + File.separator + folderName + File.separator;
//	                
//	              
//	                //String filePath = dftFilePath + "images" + File.separator + "upload" + File.separator + folderName + File.separator;
//	                //C:\Users\wook\Desktop\eGov\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\BizV3\images\photo_upload\201703
//	                System.out.println("filePath = " + filePath);
//	 
//	                String realFileNm = "";
//	                formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//	                String today= formatter.format(new java.util.Date());
//	                realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
//	                String rlFileNm = filePath + realFileNm;
//	                //C:\Users\wook\Desktop\eGov\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\BizV3\images\photo_upload\201703\2017030809570465a56af2-b3d6-4283-a0ae-1f0b19434864.jpg
//	                System.out.println("rlFileNm = " + rlFileNm);
//	                
//	                try {                
//	                    File file = new File(rlFileNm);
//	                    if(!file.exists()) {
//	                        file.mkdirs();
//	                    }                    
//	                    mpf.transferTo(file);
//	                } catch (IOException e) {
//	                    e.printStackTrace();
//	                }                
//	 
//	                String json = "";
//	                json +=    "{\"files\":[{";
//	                json +=    "\"name\":\""+realFileNm+"\",";
//	                json +=    "\"url\":\""+request.getContextPath()+"upload/"+folderName+"/"+realFileNm+"\"";
//	
//	                json +=    "}]}";
//	                
//	                return json;
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        
//	        return "";
//	    }

	

}