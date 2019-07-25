package ungmee.web.controller.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import ungmee.web.dao.CoupleDao;
import ungmee.web.entity.Couple;

@Controller
@RequestMapping("/user/info/")
public class InfoController {

	@GetMapping("detail")
	private String index() {
		return "user/info/detail";
	}
	
}


