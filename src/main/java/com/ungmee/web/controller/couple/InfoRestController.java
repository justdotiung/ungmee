package com.ungmee.web.controller.couple;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ungmee.web.entity.Couple;
import com.ungmee.web.security.CustomUserDetails;
import com.ungmee.web.service.CoupleService;


@RestController("coupleInfoRestController")
@RequestMapping("/couple/info")
public class InfoRestController {

	
	@Autowired
	private CoupleService coupleService;
	
	//날짜별 폴더생성 
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		//바꾸고자 하는 문자열로 치환 
		return str.replace("-",File.separator);
	}

	@PostMapping("accept")
	public int accept(Authentication auth , int cId) {
		CustomUserDetails aUser = (CustomUserDetails) auth.getPrincipal();
		int id = aUser.getId();
		int result = coupleService.proposeAccept(cId,id);
		return result;
	}
	
	@GetMapping("refuse")
	public int reject( int coupleId) {
		
		int result = coupleService.prposeRefuse(coupleId);
		return result;
	}
	
	@GetMapping("name-update")
	public int nameUpdate(Authentication auth, String name) {
		CustomUserDetails aUser = (CustomUserDetails) auth.getPrincipal();
		int id = aUser.getId();
		int result = coupleService.nameUpdate(name,id);
		return result;
	}
	
	@GetMapping("message-update")
	public int messageUpdate(Authentication auth, String message) {
		CustomUserDetails aUser = (CustomUserDetails) auth.getPrincipal();
		int id = aUser.getId();
		int result = coupleService.messageUpdate(message,id);
		return result;
	}
	
	@PostMapping("profile-upload")
	public int profileUpload(MultipartFile file ,HttpServletRequest req,Authentication auth) throws IOException {
		UUID uuid = UUID.randomUUID();
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		int id = user.getId();
		
		String url = "/upload";
		String realPath =req.getServletContext().getRealPath(url);
		String fileName=uuid.toString() + "_" + file.getOriginalFilename();//고유값을 가진 파일이름
		String path= realPath+File.separator+fileName;
	System.out.println(req.getServletContext());
	System.out.println(req.getServletContext().getRealPath("/"));
		System.out.println(realPath);
		
		File filePath = new File(realPath);
		if(!filePath.exists())
			filePath.mkdirs();
		
		
		
		InputStream fis =file.getInputStream();
		OutputStream fos =new FileOutputStream(path);
		
		int i= 0;
		byte[] arr = new byte[1024];
		
		while((i=fis.read(arr)) != -1) {
			fos.write(arr, 0, i);
		}
		fos.close();
		fis.close();
		
		
		System.out.println(fileName);
		
		int result = coupleService.editProfile(id, fileName);
		
		return result;
	}	
	@GetMapping("breakup")
	public int leave(Authentication auth) {
		CustomUserDetails aUser = (CustomUserDetails) auth.getPrincipal();
		int id = aUser.getId();
		int result = coupleService.breakUp(id);
		return result;
	}
}

