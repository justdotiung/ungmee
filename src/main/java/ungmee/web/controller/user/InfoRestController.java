package ungmee.web.controller.user;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import ungmee.web.dao.UserDao;
import ungmee.web.entity.ExDao;
import ungmee.web.entity.User;
import ungmee.web.security.CustomUserDetails;




@RestController
@RequestMapping("/user/")
public class InfoRestController {
	@Autowired
	private UserDao userdao;

	
	@GetMapping("event/get")
	public String get(Authentication auto) {
		CustomUserDetails details = (CustomUserDetails) auto.getPrincipal();
		User user = userdao.get(details.getId());
		Gson gson = new Gson();
		String json = gson.toJson(user);
		System.out.println(json);
		return json;
	}
	
	@PostMapping("upload")
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
	public String name(String nickName ,Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.get(details.getId());
		user.setNickName(nickName);
		userdao.edit(user);
		System.out.println(user);
		
		return "변경되었습니다.";
	}
	
	@PostMapping("password/update")
	public String password(String pwd,Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.get(details.getId());
		System.out.println(pwd);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		pwd = passwordEncoder.encode(pwd);
		user.setPw(pwd);
		System.out.println(user.getPw());
		System.out.println(user);
		userdao.edit(user);
		return "변경되었습니다.";
	}
	
	@GetMapping("event/update")
	public String event(String e ,Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		User user = userdao.get(details.getId());
		user.setEcheck(e);
		userdao.edit(user);
		System.out.println(user);
		
		return "변경되었습니다.";
	}
	
	@PostMapping("propose")
	public String propose(ExDao dao) {
	System.out.println(dao.toString());
		
		return "달라졌다.";
	}
//	
//	@PostMapping("propose")
//	public String propose() {
//		
//	}
	
//	@GetMapping("delete")
//	@ResponseBody
//	public String delete(Authentication auth) {
//		CustomUserDetails custom = (CustomUserDetails) auth.getPrincipal();
//		int id = custom.getId();
//		//return "redirect:/index";
//		return ""+id;
//	}
	
	
	
	
}


