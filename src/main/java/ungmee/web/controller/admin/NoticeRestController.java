package ungmee.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ungmee.web.dao.mybatis.MyBatisNoticeDao;
import ungmee.web.service.NoticeService;

@RestController("adminNoticeRestController")
@RequestMapping("/notice/")


public class NoticeRestController{

	@Autowired 
	private NoticeService ns;
	
	@GetMapping("list/ajax")
	public String list(Model model, @RequestParam(name="p", defaultValue="1") Integer page) {
		Gson gson = new Gson();
		
		ns.getNoticeViewList(page);
		String json = gson.toJson(ns.getNoticeViewList(page));
		
		System.out.println("제이슨노티스리스트:" + json);
		return json;
	}

	
//   int page = 1;
//   String p_ = req.getParameter("p");
//   if(p_!=null && !p_.equals(""))
//      page = Integer.parseInt(p_);
//   
//   
//   
//   NoticeDao nd = new MyBatisNoticeDao();
//   List<NoticeView> list = null;
//   
//   try {
//      list=nd.getList(page);
//   } catch (ClassNotFoundException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//   } catch (SQLException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//   }
//   
//   resp.setCharacterEncoding("UTF-8"); 
//   resp.setContentType("text/txt:charset=utf-8");
//   
//   PrintWriter out = resp.getWriter();
//   
//   
//  
//   StringBuilder json = new StringBuilder();
//   json.append("[");
//  
//   for(int i=0; i<list.size(); i++) {
//	   NoticeView n = list.get(i);
//	   
//	   json.append("{");
//	   json.append(String.format("\"categoryName\" : %s,", n.getCategoryName()));
//	   json.append(String.format(" \"writerId\" : \"%d\",", n.getWriterId()));
//	   json.append(String.format(" \"regDate\" :\"%s\",", n.getRegDate()));
//	   json.append(String.format(" \"title\" : %s", n.getTitle()));
//	   json.append(String.format(" \"content\" : \"%s\",", n.getContent()));
//	   json.append("}");
//	   
////       json.append("{");
////       json.append(String.format("\"id\" : %d," ,n.getId()));
////       json.append(String.format("\"title\" : \"%s\"," ,n.getTitle()));
////       json.append(String.format("\"content\" : \"%s\"," ,n.getContent()));
////       json.append(String.format("\"writerId\" : \"%s\","  ,n.getWriterId()));
////       json.append(String.format("\"regDate\" : \"%s\"," ,n.getRegDate()));
////       json.append(String.format("\"hit\" : %d",n.getHit()));
////       json.append("}");
//	   
//	   if(i != (list.size()) - 1)
//	   json.append(",");
//	   
//   }
//   json.append("]");
//   
//   
//   //int id, String title, String content, String writerId, Date regDate, int hit,int commentCount
////   	for(NoticeView a : list) {
////   		
////   		String col = "{" +
////   					"\"id\" : " + a.getId() + "," +
////   					"\"title\" : " + a.getTitle() + "," +
////   					"\"content\" : " + a.getContent() + "," +
////   					"\"writerId\" : " + a.getWriterId()+ "," +
////   					"\"regDate\" : " + a.getRegDate() + "," +
////   					"\"Hit\" : " + a.getHit() + "," +
////   					"\"commentCount\" : " + a.getCommentCount() + 
////   					"}";
////   	json += col;
////   	}
////   	
////   	json += "]";
////   
//   out.write(json.toString());
//}

}