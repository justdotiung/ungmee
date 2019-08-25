package ungmee.web.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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

import ungmee.web.dao.EventDao;
import ungmee.web.dao.EventFileDao;
import ungmee.web.entity.Event;
import ungmee.web.entity.EventFile;
import ungmee.web.entity.EventView;
import ungmee.web.entity.Notice;
import ungmee.web.security.CustomUserDetails;

@Controller("adminEventController")
@RequestMapping("admin/event/")
public class EventController {
	@Autowired
	private EventDao eventDao;

	@Autowired
	private EventFileDao eventFileDao;

	@GetMapping("reg")
	public String reg(Model model, Authentication auth) {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		String nickName = details.getNickName();
		model.addAttribute("writer", nickName);
		
		return "admin/event/reg";
	}

	@PostMapping("reg")
	public String reg(Event event, EventFile eventFile, Authentication auth, String category, MultipartFile[] file, HttpServletRequest request)
			throws IOException {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
		int id = details.getId();
		event.setAdminId(id);
		System.out.println(event);
		eventDao.insert(event);
		eventFileDao.insert(eventFile);
		return "redirect:list";
	}
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile[] file, HttpServletRequest request)
			throws IOException {
		System.out.println("여기왔지?");
		String fileName;
		String urlPath = "/upload";
		String realPath = request.getServletContext().getRealPath(urlPath);
			if(file ==null)
			System.out.println("data");

			fileName = file[0].getOriginalFilename();
			String path = realPath + File.separator + fileName;

			System.out.println(realPath);

			File filePath = new File(realPath);
			if (!filePath.exists())
				filePath.mkdirs();

			File sameFile = new File(path);
			if (sameFile.exists()) {
				int ne = fileName.lastIndexOf(".");
				String name = fileName.substring(0, ne);
				String suffix = fileName.substring(ne);
				int parenS = name.lastIndexOf("(");
				int parenE = name.lastIndexOf(")");

				if (parenE == -1) {
					fileName = name + "(" + 1 + ")" + suffix;
					path = realPath + File.separator + fileName;
					System.out.println(path);
				} else {
					String indexC = name.substring(parenS + 1, parenE);
					int indexN = Integer.parseInt(indexC);
					indexN++;
					fileName = fileName.substring(0, parenS + 1) + indexN + ")" + suffix;
					path = realPath + File.separator + fileName;
					System.out.println(path);
				}
			
			InputStream fis = file[0].getInputStream();
			OutputStream fos = new FileOutputStream(path);

			int j = 0;
			byte[] arr = new byte[1024];

			while ((j = fis.read(arr)) != -1) {
				fos.write(arr, 0, j);
			}
			

			fos.close();
			fis.close();

		}
		return "/upload/"+ fileName;
	}

	@GetMapping("edit")
	public String edit(Integer eid, Model model) {
		model.addAttribute("event", eventDao.get(eid));
		System.out.println(eventDao.get(eid));
		return "admin/event/edit";
	}

	@PostMapping("edit")
	public String edit(Event event) {

		Event n = eventDao.get(event.getId());
		n.setCategory(event.getCategory());
		n.setContent(event.getContent());

		eventDao.update(n);
		return "redirect:list";
	}

	@RequestMapping("list")
	public String list(Model model) {

		List<Event> events = eventDao.getList();
		
		for (Event e : events) {
			List<EventFile> efiles = eventFileDao.getListByEventId(e.getId());
			System.out.println("filesize:" + efiles.size());
			e.setFiles(efiles);
			for (EventFile efile : efiles) {
				System.out.println(efile);
			}
		}

		model.addAttribute("events", events);

		return "admin/event/list";
	}

	@GetMapping("del")
	public String del(Integer did) {
		System.out.println(eventDao.get(did));
		eventDao.delete(did);
		return "redirect:list";
	}

}