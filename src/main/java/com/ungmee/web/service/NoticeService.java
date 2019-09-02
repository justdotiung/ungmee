package com.ungmee.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ungmee.web.entity.Notice;
import com.ungmee.web.entity.NoticeCategory;
import com.ungmee.web.entity.NoticeView;

public interface NoticeService {
	public List<NoticeCategory> getCategoryList(int id);
	public List<NoticeView> getNoticeViewList(Integer page);
	public int deleteNotice(int id);
	public NoticeView getNoticeView(int id);
	public int updateNotice(Notice notice);
	public int regNotice(Notice notice);
	public List<NoticeView> getPageList(Integer page, String field, String query);
	
	
	
//	public void getNoticeList(int page);
//	public void getNotice(int id);
//	public void regNotice(Notice notice);
//	public void upload(MultipartFile file, HttpServletRequest request);
//	public void getUpdateData(Model model, Integer eid);
//	public void updateContent(Notice notice);
//	public void delete(Integer did);
//	
//
//	
//	//file
//	public void getList(HttpServletRequest request);
//	public void removeFileInfo(int num, 
//			HttpServletRequest request, 
//			HttpServletResponse response);
//	public void saveFile(FileDto dto, 
//			HttpServletRequest request);
//	public void getFileData(ModelAndView mView, int num);
	

}
