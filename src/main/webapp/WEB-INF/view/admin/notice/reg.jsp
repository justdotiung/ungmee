<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 공지사항 REG 페이지</title>
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/lib/editor/editor.css">
<link rel="stylesheet" type="text/css"
	href="${ctxName}/resource/css/admin/notice/reg.css">
<script src="${ctxName}/resource/lib/editor/util.js"></script>
<script src="${ctxName}/resource/lib/editor/editor.js"></script>
</head>
<main>
<form action="reg?${_csrf.parameterName}=${_csrf.token}" method="post"
	enctype="multipart/form-data">
	<div class="regform">

		<select name="category">
			<option value="공지사항">공지사항</option>
			<option value="사내이벤트">사내이벤트</option>
			<option value="외부이벤트">외부이벤트</option>
		</select>

		<div>${n.regdate}</div>
		<div class="title">
			<input name="title" placeholder="제목 입력할꺼지?">
		</div>
		<div class="file">
			<input type="file" name="file">파일첨부
		</div>
		<div class="content">
			<textarea class="textarea"
				style="width: 100%; height: 300px; border: 1px solid gray;"></textarea>
			<div class="com newlecture single-editor">

				<div class="toolbar">
					<span class="panel"> <input type="button" value="bold"
						class="btn btn-text btn-bold" /> <input type="button"
						value="underline" class="btn btn-underline" /> <input
						type="button" value="italic" class="btn btn-italic" />
					</span> <span class="panel"> <input type="button" value="left"
						class="btn btn-left" /> <input type="button" value="center"
						class="btn btn-center" /> <input type="button" value="right"
						class="btn btn-right" />
					</span> <span class="panel"> <input type="button" value="font-size"
						class="btn btn-font-size" /> <input type="button"
						value="font-color" class="btn btn-font-color" /> <!-- <input type="button" value="font-family" class="btn btn-font-family"/> -->
					</span> <span class="panel"> <input type="button" value="image"
						class="btn btn-image" /> <span class="btn btn-text btn-link">link</span>
						<!-- <input type="button" value="html" class="btn btn-html" /> -->
					</span> <span> <input type="file" class="file-button"
						style="display: none;" />
					</span>
				</div>

				<div class="option-bar hidden">
					<div class="url-box hidden">
						<label>링크텍스트:</label> <input type="text" class="link-text" /> <label>url:</label>
						<input type="text" class="link-url" /> <input type="button"
							value="적용" class="btn btn-text btn-add-link" />
					</div>
					<div class="font-color-box" style="display: none;">
						<label>색상선택:</label> <input type="button" value="color-warning"
							class="btn btn-color btn-color-warning" /> <input type="button"
							value="color-notice" class="btn btn-color btn-color-notice" /> <input
							type="button" value="color-highlight"
							class="btn btn-color btn-color-highlight" /> <input
							type="button" value="color-normal"
							class="btn btn-color btn-color-normal" /> <input type="button"
							value="color-strong" class="btn btn-color btn-color-strong" />
					</div>
					<div class="font-size-box hidden">
						<label>크기선택:</label> <input type="button" value="T"
							class="btn btn-size btn-size-sm" /> <input type="button"
							value="T" class="btn btn-size btn-size-md" /> <input
							type="button" value="T" class="btn btn-size btn-size-lg" /> <input
							type="button" value="T" class="btn btn-size btn-size-xlg" /> <input
							type="button" value="T" class="btn btn-size btn-size-xxlg" />
					</div>
				</div>

				<div class="html-area" contenteditable="true"
					style="height: inherit;"></div>
			</div>
		</div>
	</div>
</form>
<div class="button-box">
	<input type="submit" value="저장"> <a href="list">취소</a>
</div>




</main>
</html>
