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
		System.out.println(user);
		model.addAttribute("user", user);
		return "user.detail";
	}
	
	@GetMapping("delete")
	@ResponseBody
	public String delete(Authentication auth) {
		CustomUserDetails custom = (CustomUserDetails) auth.getPrincipal();
		int id = custom.getId();
		//return "redirect:/index";
		return ""+id;
	}
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile file,HttpServletRequest request,Authentication authentication) throws IOException {
		String urlPath="/upload";
		String realPath =request.getServletContext().getRealPath(urlPath);
		String fileName=file.getOriginalFilename();
		String Path= realPath+File.separator+fileName;
		
		System.out.println(realPath);
		
		File filePath = new File(realPath);
		if(!filePath.exists())
			filePath.mkdirs();
		
		File sameFile = new File(Path);
		if(sameFile.exists()) {
			int ne = fileName.lastIndexOf(".");
			String name = fileName.substring(0,ne);
			String suffix = fileName.substring(ne);
			int parenS = name.lastIndexOf("(");
			int parenE = name.lastIndexOf(")");
			
			if(parenE == -1) {
				fileName = name + "("+1+")"+suffix;
				Path = realPath+File.separator+fileName;
				System.out.println(filePath);
			}else {
				String indexC = name.substring(parenS+1, parenE);
				int indexN = Integer.parseInt(indexC);
				indexN++;
				fileName = fileName.substring(0, parenS +1)+indexN + ")" + suffix;
				Path = realPath+File.separator+fileName;
				System.out.println(filePath);
			}
		}
		InputStream fis =file.getInputStream();
		OutputStream fos =new FileOutputStream(filePath);
		
		int i= 0;
		byte[] arr = new byte[1024];
		
		while((i=fis.read(arr)) != -1) {
			fos.write(arr, 0, i);
		}
		fos.close();
		fis.close();
		CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();	
		User user = userdao.get(details.getId());
		user.setProfile(fileName);
		userdao.edit(user);
		return "kk";
	}
	
	
}


