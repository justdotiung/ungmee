package com.ungmee.web.controller.couple;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ungmee.web.security.CustomUserDetails;

@RestController
@RequestMapping("/couple/course/")
public class CourseRestController {
	@PostMapping("spot-img")
	public String reg(MultipartFile[] file,HttpServletRequest req,Authentication auth) throws IOException {
		UUID uuid = UUID.randomUUID();
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		int id = user.getId();
		for(int i = 0; i<file.length; i++) {
			String url = "/upload";
			String realPath =req.getServletContext().getRealPath(url);
			String fileName=uuid.toString() + "_" + file[i].getOriginalFilename();//고유값을 가진 파일이름
			String path= realPath+File.separator+fileName;
			System.out.println(req.getServletContext());
			System.out.println(req.getServletContext().getRealPath("/"));
			System.out.println(realPath);
			
			File filePath = new File(realPath);
			if(!filePath.exists())
				filePath.mkdirs();
			
			
			
			InputStream fis =file[i].getInputStream();
			OutputStream fos =new FileOutputStream(path);
			
			int j= 0;
			byte[] arr = new byte[1024];
			
			while((j=fis.read(arr)) != -1) {
				fos.write(arr, 0, i);
			}
			fos.close();
			fis.close();
		}
		return "couple.course.reg";
	}
}
