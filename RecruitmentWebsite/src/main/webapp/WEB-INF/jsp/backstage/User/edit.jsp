<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<form action="doUpdateAdminuser.controller" method="post" class="definewidth m20">
<input type="hidden" name="aid" value="${adminuser.aid }" />
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">登录名</td>
            <td><input type="text" name="ausername" oninput="tishik()" value="${adminuser.ausername}"/>&nbsp;&nbsp;<span id="tishi"></span></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="apassword"/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="qapassword"/></td>
        </tr>
        <!-- <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="realname" value="{$user.realname}"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email" value="{$user.email}"/></td>
        </tr> -->
        <tr>
            <td class="tableleft">权限</td>
            <td>
                <input type="radio" name="astatus" value="0" <c:if test="${adminuser.astatus eq '0'}">checked</c:if>
                     /> 普通管理员
              <input type="radio" name="astatus" value="1"
                    <c:if test="${adminuser.astatus eq '1'}">checked</c:if> > 高级管理员
            </td>
        </tr>
        <!-- <tr>
            <td class="tableleft">角色</td>
            <td>{$role_checkbox}</td>
        </tr> -->
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">保存</button>				 &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/webjars/jquery/3.2.1/jquery.js"></script>
<script>
    $(function () {       
		$('#backid').click(function(){
				/* window.location.href="{:U('User/index')}"; */
				history.go(-1);
		 });

    });
    function tishik(){
    	var zhi = $("input[name='ausername']").val();
    	//alert(zhi);
    	$.ajax({
    		type:"post",
    		url:"ajaxQueryAdminuserByName.controller",
    		data:{"ausername":zhi},
    		success:function(resultData,status){
    			if("success"==status){
    				if(!$.isEmptyObject(resultData)){
        				$("#tishi").html("用户名占用！");
        			}else{
        				$("#tishi").html("用户名可用！");
        				
        			}
    			}
    			
    		}	
    	})
    }
</script>
</body>
</html>
