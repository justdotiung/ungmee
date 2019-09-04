<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/admin/aside.css">

	
	<section id="aside">
	 	<%-- <div id="aside-list">
			<ul>
				<li><a href="${ctxName }/admin/member/list">회원관리</a></li>
				<li>파트너관리</li>
				<li><a href="${ctxName }/admin/event/list">이벤트관리</a></li>
				<li>커플관리</li>
				<li><a href="${ctxName }/admin/notice/list">공지사항관리</a></li>
			</ul>
		</div> --%>
		
		<!-- Sidebar: Main -->
		<aside id="sideBar">
		   <div class="sideBar">
		   <!--사이드메뉴닫기버튼-->
		   <a href="javascript:void(0)" id="close_sidebar" class="right" title="Close Menu" onclick="sidebar_close()"><b id="close">X</b></a>
		   <h4><b>Admin menu</b></h4>
			   <div id="menu-list">
				   <div><a href="${ctxName }/admin/member/list">회원관리</a><br></div>
				   <div><a href="">파트너관리</a><br></div>
				   <div><a href="${ctxName }/admin/event/list">이벤트관리</a><br></div>
				   <div><a href="${ctxName }/admin/notice/list">공지사항관리</a><br></div>
			   </div>
		   </div>
		</aside> 
	</section>

 