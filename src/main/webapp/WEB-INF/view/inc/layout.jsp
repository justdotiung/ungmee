<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${ctxName}/resource/css/member/index.css">
    <title>Document</title>
</head>
<body>
<!-- header -->

<tiles:insertAttribute name="header"/>
<!-- body -->
<tiles:insertAttribute name="main"/>
<!-- footer -->
<tiles:insertAttribute name="footer"/>

</body>
</html>