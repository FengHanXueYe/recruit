<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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

<form class="form-inline definewidth m20" action="toRecuitUserIndex.controller" method="post">  
    用户名称：
    <input type="text" name="username"  id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
   <input type="submit"  class="btn btn-primary" value="查询">&nbsp;&nbsp;
    
    <!-- <button type="button" class="btn btn-success" id="addnew">新增角色</button> -->
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>用户id</th>
        <th>用户名</th>
        <!-- <th>登录密码</th> -->
        <th>身份证号</th>
        <th>性别</th>
        <th>邮箱</th>
        <th>电话</th>
        <th>学历</th>
        <th>工作经验</th>
        <!-- <th>用户头像</th> -->
        <th>注册修改时间</th>
        <th>求职状态</th>
        <th>权限</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${listrecuit}" var="list">
	     <tr class="del${list.userid }">
	        <td>${list.userid}</td>
            <td>${list.username}</td>
            <%-- <td>${list.password}</td> --%>
            <td>${list.identity}</td>
            
            <td>
            <c:if test="${list.gender eq '1'}">女</c:if>
            <c:if test="${list.gender eq '2'}">男</c:if>
           </td>
            <td>${list.email}</td>
            <td>${list.telephone}</td>
            
            <td>
            <c:if test="${list.education eq '1'}">大专</c:if>
            <c:if test="${list.education eq '2'}">本科</c:if>
            <c:if test="${list.education eq '3'}">硕士</c:if>
            <c:if test="${list.education eq '4'}">博士</c:if>
            <c:if test="${list.education eq '5'}">其他</c:if>
           </td>
           <td>
            <c:if test="${!empty list.userlog }"><c:if test="${list.userlog eq '1'}">应届毕业生</c:if><c:if test="${list.userlog eq '2'}">1年</c:if><c:if test="${list.userlog eq '3'}">2年</c:if><c:if test="${list.userlog eq '4'}">3年</c:if><c:if test="${list.userlog eq '5'}">4年</c:if><c:if test="${list.userlog eq '6'}">5年</c:if><c:if test="${list.userlog eq '7'}">6年</c:if><c:if test="${list.userlog eq '8'}">7年</c:if><c:if test="${list.userlog eq '9'}">8年</c:if><c:if test="${list.userlog eq '10'}">9年</c:if><c:if test="${list.userlog eq '11'}">10年</c:if><c:if test="${list.userlog eq '12'}">10年以上</c:if><br></c:if>
           </td>                              
            <td><fmt:formatDate value="${list.registrationTime}" pattern="yyyy-MM-dd  HH:mm:ss"/> </td>
            
            
            <td>${list.currentstate}</td>
           <td> <c:if test="${list.quanxian eq '0'}">账号可用
            </c:if>
            <c:if test="${list.quanxian eq '1'}">账号不可用
            </c:if></td>
            <td>
                  <a href="toeditUser.controller?userid=${list.userid}">编辑</a>
                  <a href="javascript:void(0)" onclick="JingyongUser(${list.userid})" id="quanxian">禁用</a>
                  <a href="javascript:void(0)" onclick="deleteUser(${list.userid})">删除</a>
            </td>
        </tr>
        </c:forEach>
        </table>
        
<script type="text/javascript" src="${pageContext.request.contextPath }/webjars/jquery/3.2.1/jquery.js"></script>

<script type="text/javascript">

function finds(){
    var username =$("#username").val();
    if(username==""){
        alert("用户名不能为空！");
        return false;
    }
    else
    {
    	
    	
/*     $.ajax({
        type:'post',
        url:'toRecuitUserIndex.controller',
        dataType:"json",//注意使用的是打他dataType，而不是Content-Type
        async: true,
        data:{username:username},
        success:function(data){
            if(data==null){
                alert("没有这个用户！")
            }
            else{
                window.location.href ="toRecuitUserIndex.controller";
            }
         }
    }); */
    }
    }
</script>

 <script>
  /*   $(function () {
        
    	/* $('#addnew').click(function(){
				window.location.href="toRoleAdd.controller";
		 });
    });
	function del(id)
	{
		if(confirm("确定要删除吗？"))
		{
			var url = "toRoleIndex.controller";
			window.location.href=url;		
		}
		
		alert('1');
		
	} */
</script>
<script type="text/javascript">
            
      
    	  /* ajax删除 */
    		function deleteUser(userid){
    			var flg = confirm("确定要删除吗？");
    			if(flg){
    				$.post("ajaxDeleteUser.controller","pk="+userid,function(data){
    					if(data){
    						$(".del"+userid).remove();
    					}
    				}) 
    			}
    		}
     		function JingyongUser(userid) {
    			  
    				  var flg = confirm("确定要禁用吗？");
    	    			if(flg){
    	    				$.post("ajaxJingyongUser.controller","userid="+userid,function(data){
    	    					if(data){
    	    						location.reload();
    	    					}
    	    				})
    	    				
    	    			}
    	    			
    	    			
    			}
    	   

</script>

</body>
</html>
