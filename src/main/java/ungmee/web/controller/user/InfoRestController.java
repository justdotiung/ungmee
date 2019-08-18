package ungmee.web.controller.user;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import ungmee.web.dao.CoupleDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Couple;
import ungmee.web.entity.Solo;
import ungmee.web.entity.User;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.CustomMemberShipService;
import ungmee.web.service.MemberShipService;




@RestController
@RequestMapping("/user/")
public class InfoRestController {
	@Autowired
	private UserDao userdao;
	@Autowired
	private CoupleDao coupledao;
	@Autowired
	private MemberShipService msService;
	
	@GetMapping("get")
	public String get(Authentication auto) {
		CustomUserDetails details = (CustomUserDetails) auto.getPrincipal();
		User user = userdao.get(details.getId());
		Gson gson = new Gson();
		String json = gson.toJson(user);
		System.out.println("내정보 :"+json);
		
		return json;
	}

	
	@GetMapping("partner")
	public String get(String email) {
		System.out.println("상대방 email :"+email);
		User user = userdao.getEmail(email);
		if(user == null)
			return null;
		System.out.println("상대방 user :"+user);
		Gson gson = new Gson();
		String json = gson.toJson(user);
		
		return json;
	}
	
	@PostMapping("upload")
	public int upload(MultipartFile file,HttpServletRequest request,Authentication authentication) throws IOException {
		System.out.println(file);
		String urlPath="/upload";
		String realPath =request.getServletContext().getRealPath(urlPath);
		String fileName=file.getOriginalFilename();
		String path= realPath+File.separator+fileName;
		
		System.out.println(realPath);
		
		File filePath = new File(realPath);
		if(!filePath.exists())
			filePath.mkdirs();
		
		File sameFile = new File(path);
		if(sameFile.exists()) {
			int ne = fileName.lastIndexOf(".");
			String name = fileName.substring(0,ne);
			String suffix = fileName.substring(ne);
			int parenS = name.lastIndexOf("(");
			int parenE = name.lastIndexOf(")");
			
			if(parenE == -1) {
				fileName = name + "("+1+")"+suffix;
				path = realPath+File.separator+fileName;
				System.out.println(path);
			}else {
				String indexC = name.substring(parenS+1, parenE);
				int indexN = Integer.parseInt(indexC);
				indexN++;
				fileName = fileName.substring(0, parenS +1)+indexN + ")" + suffix;
				path = realPath+File.separator+fileName;
				System.out.println(path);
			}
		}
		InputStream fis =file.getInputStream();
		OutputStream fos =new FileOutputStream(path);
		
		int i= 0;
		byte[] arr = new byte[1024];
		
		while((i=fis.read(arr)) != -1) {
			fos.write(arr, 0, i);
		}
		fos.close();
		fis.close();
		
		CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();
		System.out.println(fileName);
		System.out.println(details.getId());
		System.out.println(details.getRoleId());
		System.out.println(userdao.get(details.getId()).toString());
		
		int result = msService.editSoloProfile(details.getId(), fileName);
		
		return result;
	}
	
	@GetMapping("nickname")
	public int name(String nickName ,Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		int result = msService.editSoloNickName(details.getId(), nickName);		
		return result;
	}
	
	@PostMapping("password/update")
	public int password(String pwd,Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		pwd = passwordEncoder.encode(pwd);
		int result = msService.editSoloPassword(details.getId(), pwd);
		return result;
	}
	
	
	@PostMapping("propose")
	public String propose(Solo solo,Couple couple,@DateTimeFormat(pattern = "yyyy-MM-dd")Date sloveDate, Authentication auth,Model model) {
		System.out.println("propose couple : "+couple.toString());
		CustomUserDetails custom = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.getEmail(custom.getEmail());	
		couple.setLoveDate(sloveDate);
		coupledao.insert(couple);		
		user.setcState(0);//신청중 상태
		userdao.edit(user);
		System.out.println("신청자 프로포즈 신청 상황 :"+user.getcState());
		model.addAttribute("user", user);
		return "check";
	}
	
	@GetMapping("propose/cancel")
	public String proposeCancel(Authentication auth) {
		CustomUserDetails custom = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.getEmail(custom.getEmail());
		System.out.println("proposeId : "+user.getId());
		coupledao.delete(user.getId());
		user.setcState(-1);//대기중 상태
		userdao.edit(user);
		System.out.println("신청자 프로포즈 취소 상황 :"+user.getcState());
			
		return "check";
	}
	@GetMapping("event/update")
	public String event(String e ,Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.get(details.getId());
		if(e.contentEquals("T"))
			user.setEcheck("F");
		else
			user.setEcheck("T");
		
		userdao.edit(user);
		System.out.println("이벤트값 : "+user.getEcheck());
		
		return "변경되었습니다.";
	}
	
//	@GetMapping("delete")
//	@ResponseBody
//	public String delete(Authentication auth) {
//		CustomUserDetails custom = (CustomUserDetails) auth.getPrincipal();
//		int id = custom.getId();
//		//return "redirect:/index";
//		return ""+id;
//	}
	
	
	
	
}


