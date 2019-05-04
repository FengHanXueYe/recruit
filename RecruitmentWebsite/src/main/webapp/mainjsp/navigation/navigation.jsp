<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<dl class="collapsible_menu">
            	<dt>
           			<span>
           				<c:if test="${empty loginUser.username }">${loginUser.email }</c:if>
           				<c:if test="${!empty loginUser.username }">${loginUser.username }</c:if>
           			</span> 
            		<span class="red dn" id="noticeDot-1"></span>
            		<i></i>
            	</dt>
                	<dd><a href="toNavController.controller">去企业版</a></dd>
                    <dd><a href="queryByOstateController.controller?ostate=0&pk=${companys.cid}">我发布的职位</a></dd>
                	<dd><a href="doListCompanyresume.controller">我收到的简历</a></dd>
                	<dd><a href="doMyNews.controller">我收到的消息</a></dd>
                	<dd class="btm"><a href="tomyhome.controller">我的公司主页</a></dd>
                	<dd><a href="jianli.html">我要找工作</a></dd>
                	<dd><a href="doListDeliverypost.controller">我投递的职位</a></dd>
                    <dd><a href="toAccountSettings.controller">帐号设置</a></dd>
                    <dd class="logout"><a rel="nofollow" href="doRemoveSession.controller">退出</a></dd>
            </dl>
</body>
</html>