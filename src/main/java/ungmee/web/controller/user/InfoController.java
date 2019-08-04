package ungmee.web.controller.user;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ungmee.web.dao.UserDao;
import ungmee.web.entity.User;
import ungmee.web.security.CustomUserDetails;




@Controller
@RequestMapping("/user/")
public class InfoController {
	@Autowired
	private UserDao userdao;
	
	@GetMapping("detail")
	public String index(Model model,Authentication auth) {
		CustomUserDetails cUser = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.get(cUser.getId());
		model.addAttribute("user", user);
		return "user.detail";
	}

	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile file,HttpServletRequest request,Authentication authentication) throws IOException {
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
		System.out.println("qlalfqjsgh"+details.getPw());
		
		User user = userdao.get(details.getId());
		System.out.println(user.toString());
		user.setProfile(fileName);
		userdao.edit(user);
		return "변경되었습니다.";
	}
	
	@GetMapping("nickname")
	@ResponseBody
	public String name(String nickName ,Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.get(details.getId());
		user.setNickName(nickName);
		userdao.edit(user);
		System.out.println(user);
		
		return "변경되었습니다.";
	}
	
	@PostMapping("changepw")
	@ResponseBody
	public String password(String pwd,Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.get(details.getId());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		pwd = passwordEncoder.encode(pwd);
		user.setPw(pwd);
		System.out.println(user.getPw());
		System.out.println(user);
		userdao.edit(user);
		return "변경되었습니다.";
	}
	
	@GetMapping("changeev")
	@ResponseBody
	public String event(String eCheck ,Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.get(details.getId());
		user.setEcheck(eCheck);
		userdao.edit(user);
		System.out.println(user);
		
		return "변경되었습니다.";
	}
	
	@GetMapping("propose")
	public String propose() {
		return "user/propose";
	}
	
	@PostMapping("propose")
	public String propose() {
		
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


