<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section>
	<div>
		<div>
			<div>
				<div>
					<p>우리커플을 소개합니다.</p>	
				</div>
				<div>
					<p>${couple.coupleName } 커플은 99일째 반하고 있는 중입니다.</p>
				</div>
			</div>
			<div>
				알람 
			</div>
			<div>
				<div>
					<ul>
						<li><img src=""></li>
						<li>${couple.message }</li>
						<li>팔로워</li>
						<li>팔로잉</li>
						<li>왕관</li>
						<li>좋아요</li>
						<li>게시글</li>
					</ul>
				</div>
				<div>
					<button>팔로잉</button>
				</div>
			</div>
		</div>
	</div>
	<div>
		<div>
			
		</div>
	</div>	
</section>