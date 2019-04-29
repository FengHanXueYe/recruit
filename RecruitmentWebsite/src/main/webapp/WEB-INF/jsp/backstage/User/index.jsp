<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="backstagestyle/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="backstagestyle/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="backstagestyle/Css/style.css" />
    <script type="text/javascript" src="backstagestyle/Js/jquery.js"></script>
    <script type="text/javascript" src="backstagestyle/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="backstagestyle/Js/bootstrap.js"></script>
    <script type="text/javascript" src="backstagestyle/Js/ckform.js"></script>
    <script type="text/javascript" src="backstagestyle/Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="index.html" method="get">    
    用户名称：
    <input type="text" name="ausername" oninput="selectAdminuser()" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <!-- <button type="submit" class="btn btn-primary">查询</button >-->
    &nbsp;&nbsp;<c:if test="${loginUserAdmin.astatus eq '1' }"><button type="button" class="btn btn-success" id="addnew">新增用户</button></c:if> 
</form>
<table class="table table-bordered table-hover definewidth m10" id="cunselectAdmin">
    <thead>
    <tr>
        <th>用户id</th>
        <th>用户名称</th>
        <th>权限</th>
        <th>上次操作时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:if test="${loginUserAdmin.astatus eq '1' }">
    <c:forEach items="${listAdminuser }" var="item">
	     <tr id="${item.aid }">
            <td>${item.aid }</td>
            <td>${item.ausername }</td>
            <td><c:if test="${item.astatus eq '1'}">高级管理员</c:if><c:if test="${item.astatus eq '0'}">普通管理员</c:if> </td>
            <td><fmt:formatDate value="${item.adatatime }" pattern="yyyy-MM-dd  HH:mm:ss"/> </td>
            <td>
                <a href="toUserEdit.controller?aid=${item.aid }">编辑</a>              
                <a href="javascript:void(0)" onclick="deleteAdmin(${item.aid })">删除</a>
                             
            </td>
        </tr>
    </c:forEach>	
    </c:if>   
     <c:if test="${loginUserAdmin.astatus eq '0' }">
    <c:forEach items="${listAdminuser }" var="item">
	     <tr>
            <td>${item.aid }</td>
            <td>${item.ausername }</td>
            <td><c:if test="${item.astatus eq '1'}">高级管理员</c:if><c:if test="${item.astatus eq '0'}">普通管理员</c:if> </td>
            <td><fmt:formatDate value="${item.adatatime }" pattern="yyyy-MM-dd  HH:mm:ss"/> </td>
            <td>
                <a href="javascript:void(0)">权限不够</a>              
            </td>
        </tr>
    </c:forEach>	
    </c:if>   
</table>
<script type="text/javascript" src="${pageContext.request.contextPath }/webjars/jquery/3.2.1/jquery.js"></script>
<script>
	/* ajax查询 */
	function selectAdminuser(){
		var value = $("input[name='ausername']").val();
		/* $.post("ajaxListAdminUser.controller","ausername="+value,function(data){
			alert("ajax");
			
		}) */
		
		 $.ajax({
			type:"post",
			url:"ajaxListAdminUser.controller",
			data:{"ausername":value},
			success:function(data){
				$("#cunselectAdmin").html("");
				html="<thead>"
						    +"<tr>"
						        +"<th>用户id</th>"
						        +"<th>用户名称</th>"
						        +"<th>权限</th>"
						        +"<th>上次操作时间</th>"
						        +"<th>操作</th>"
					   		+"</tr>"
					+"</thead>";
				
				$.each(data,function(index,item){
					var date = new Date(item.adatatime);
					var d = date.getFullYear() + "-" + (Number(date.getMonth())+Number(1)) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
					var qx = "";
					if(item.astatus==1){
						qx="高级管理员";
					}else{
						qx="普通管理员";
					}
					var astatus = '${loginUserAdmin.astatus}';
					if(astatus==1){
						html+="<tr id="+item.aid+">"
					           +"<td>"+item.aid+"</td>"
					           +"<td>"+item.ausername+"</td>"
					           +"<td>"+qx+"</td>"
					           +"<td>"+d+"</td>"
					           +"<td>"
					               +"<a href='toUserEdit.controller?aid="+item.aid+"'>编辑</a>     "                
					               +"<a href='javasript:void(0)' onclick='deleteAdmin("+item.aid+")'>删除</a>"                
					           +"</td>"
					       +"</tr>";
					}else {
						html+="<tr>"
					           +"<td>"+item.aid+"</td>"
					           +"<td>"+item.ausername+"</td>"
					           +"<td>"+qx+"</td>"
					           +"<td>"+d+"</td>"
					           +"<td>"
					               +"<a href='javasript:void(0)'>权限不够</a>"                
					           +"</td>"
					       +"</tr>";
					}
					
				})
				$("#cunselectAdmin").html(html);
				 
			}
			
		})
		
		
	}
    $(function () {
    	/* 判断管理员上线 */
        var admincount = '${admincount}';
        if(admincount.length>0){
        	$("#addnew").html(admincount);
        }

		$('#addnew').click(function(){

				window.location.href="toUserAdd.controller";
		 });


    });

    /* ajax删除 */
	function deleteAdmin(aid){
		var flg = confirm("确定要删除吗？");
		if(flg){
			$.post("ajaxDeleteAdminuser.controller","aid="+aid,function(data){
				if(data){
					$("#"+aid).remove();
				}
			}) 
		}
	
			/* var url = "toUserIndex.controller";
			
			window.location.href=url;		 */
	
	}
</script>
</body>
</html>
