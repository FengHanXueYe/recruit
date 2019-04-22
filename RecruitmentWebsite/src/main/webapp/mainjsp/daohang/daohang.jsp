<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div id="header">
			<div class="wrapper">
				<a href="index.html" class="logo"> <img
					src="style/images/logo.png" width="229" height="43"
					alt="拉勾招聘-专注互联网招聘" />
				</a>
				<ul class="reset" id="navheader">
					<li class="current"><a href="toIndex.controller">首页</a></li>
					<li><a href="queryListCompany.controller">公司</a></li>
					<li><a href="h/toForum.html" target="_blank">论坛</a></li>
					<li><a href="toResume.controller" rel="nofollow">我的简历</a></li>
					<li><a href="tocreate.controller" rel="nofollow">发布职位</a></li>
				</ul>
				<c:choose>
					<c:when test="${empty loginUser }">
						<jsp:include page="/mainjsp/login/registerSignin.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="/mainjsp/navigation/navigation.jsp"></jsp:include>
					</c:otherwise>
				</c:choose>
				<!--   <ul class="loginTop">
            	<li><a href="login.html" rel="nofollow">登录</a></li> 
            	<li>|</li>
            	<li><a href="register.html" rel="nofollow">注册</a></li>
            </ul> -->
			</div>
		</div>
</body>
</html>