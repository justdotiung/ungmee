package com.ungmee.web.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.ungmee.web.dao.NoticeCategoryDao;
import com.ungmee.web.dao.NoticeDao;
import com.ungmee.web.dao.UserDao;
import com.ungmee.web.entity.Notice;
import com.ungmee.web.entity.NoticeCategory;
import com.ungmee.web.entity.NoticeView;

@Service
public class DefaultNoticeService implements NoticeService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private NoticeCategoryDao categoryDao;
	
	@Override
	public List<NoticeCategory> getCategoryList(int id) {
		return null;
	}
	@Override
	public List<NoticeView> getNoticeViewList(Integer page) {
		List<NoticeView> noticeViewList = noticeDao.getList(page);
		return noticeViewList;
	}
	@Override
	public int deleteNotice(int id) {
		return noticeDao.delete(id);
	}
	@Override
	public int updateNotice(Notice notice) {
		//NoticeView noticeView1 = noticeDao.get(id);
		return noticeDao.update(notice);
	}
	@Override
	public int regNotice(Notice notice) {
		return noticeDao.insert(notice);
	}
	@Override
	public NoticeView getNoticeView(int id) {
		NoticeView noticeView = noticeDao.getView(id);
		return noticeView;
	}
	@Override
	public List<NoticeView> getPageList(Integer page, String field, String query) {
		// TODO Auto-generated method stub
		return noticeDao.getList(page,"title","");
	}

}	

	
	
	

//	static final int PAGE_ROW_COUNT=5;
//	static final int PAGE_DISPLAY_COUNT=5;
//
//	@Override
//	public void getPageList(HttpServletRequest request) {
//				Notice notice = new Notice();
//
//				int pageNum=1;
//				String strPageNum=request.getParameter("pageNum");
//				if(strPageNum != null){
//					pageNum=Integer.parseInt(strPageNum);
//				}
//		
//				int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
//	
//				int endRowNum=pageNum*PAGE_ROW_COUNT;
//				
//
//				int totalRow=noticeDao.getCount(notice);
//
//				int totalPageCount=
//						(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
//	
//				int startPageNum=
//					1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
//			
//				int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
//				
//				if(totalPageCount < endPageNum){
//					endPageNum=totalPageCount; 
//
//				notice.setStartRowNum(startRowNum);
//				notice.setEndRowNum(endRowNum);
//				
//	
//				List<Notice> list=noticeDao.getList(notice);
//				
//		
//				request.setAttribute("list", list);
//				request.setAttribute("startPageNum", startPageNum);
//				request.setAttribute("endPageNum", endPageNum);
//				request.setAttribute("pageNum", pageNum);
//				request.setAttribute("totalPageCount", totalPageCount);	
//	
//				request.setAttribute("totalRow", totalRow);
//				}
//	}


	
	

