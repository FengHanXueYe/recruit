<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
﻿<!DOCTYPE HTML>
<html>
<head>
<script id="allmobilize" charset="utf-8" src="style/js/allmobilize.min.js"></script>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate" media="handheld"  />
<!-- end 云适配 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录-拉勾网-最专业的互联网招聘平台</title>
<meta property="qc:admins" content="23635710066417756375" />
<meta content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网" name="description">
<meta content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招" name="keywords">

<meta name="baidu-site-verification" content="QIQ6KC1oZ6" />

<!-- <div class="web_root"  style="display:none">h</div> -->
<script type="text/javascript">
var ctx = "h";
console.log(1);
</script>
<link rel="Shortcut Icon" href="h/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="style/css/style.css"/>

<script src="style/js/jquery.1.10.1.min.js" type="text/javascript"></script>

<script type="text/javascript" src="style/js/jquery.lib.min.js"></script>
<script type="text/javascript" src="style/js/core.min.js"></script>


<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script type="text/javascript" src="style/js/conv.js"></script>
</head>
<%
    String username = "";
    String password = "";
    //获取当前站点的所有Cookie
    Cookie[] cookies = request.getCookies();
    //有cookie数据的时候再去遍历人家
    if(cookies!=null){
    	 if(cookies.length>0){
        	 for (int i = 0; i < cookies.length; i++) {//对cookies中的数据进行遍历，找到用户名、密码的数据
        	        if ("cookiename".equals(cookies[i].getName())) {
        	            username = cookies[i].getValue();
        	        } else if ("cookiepwd".equals(cookies[i].getName())) {
        	            password = cookies[i].getValue();
        	        }
        	    }
        }
    }
   
%>
<body id="login_bg">
	<div class="login_wrapper">
		<div class="login_header">
        	<a href="h/"><img src="style/images/logo_white.png" width="285" height="62" alt="拉勾招聘" /></a>
            <div id="cloud_s"><img src="style/images/cloud_s.png" width="81" height="52" alt="cloud" /></div>
            <div id="cloud_m"><img src="style/images/cloud_m.png" width="136" height="95"  alt="cloud" /></div>
        </div>
        
    	<input type="hidden" id="resubmitToken" value="" />		
		 <div class="login_box">
        	<form id="loginForm" action="userLogin.controller" method="post">
        		
				<input type="text" id="email" name="email" <c:if test="${empty username }">value="<%=username %>"</c:if><c:if test="${!empty username }">value="${username }"</c:if>  tabindex="1" placeholder="请输入登录邮箱地址" />
				<span></span>
			  	<input type="password" id="password" name="password" tabindex="2" <c:if test="${empty password }">value="<%=password %>"</c:if><c:if test="${!empty password }">value="${password }"</c:if> placeholder="请输入密码" />
			  	<span></span>
				<!-- <span class="error" style="display:none;" id="beError"></span> -->
			    <label class="fl" for="remember"><input type="checkbox" id="remember" value="yes" checked="checked" name="autoLogin" /> 记住我</label>
			    <a href="toReset.controller" class="fr">忘记密码？</a>
			    
				<input type="submit" id="submitLogin" value="登 &nbsp; &nbsp; 录" />
				<!-- <a style="color:#fff;" href="javascritp:void(0)" class="submitLogin" title="登 &nbsp; &nbsp; 录"/><input type="submit" value="提交" /></a>  -->
			    
			    <input type="hidden" id="callback" name="callback" value=""/>
                <input type="hidden" id="authType" name="authType" value=""/>
                <input type="hidden" id="signature" name="signature" value=""/>
                <input type="hidden" id="timestamp" name="timestamp" value=""/>
			</form>
			<div class="login_right">
				<div>还没有拉勾帐号？</div>
				<a  href="toRegister.controller"  class="registor_now">立即注册</a>
			    <div class="login_others">使用以下帐号直接登录:</div>
			    <a  href="h/ologin/auth/sina.html"  target="_blank" class="icon_wb" title="使用新浪微博帐号登录"></a>
			    <a  href="h/ologin/auth/qq.html"  class="icon_qq" target="_blank" title="使用腾讯QQ帐号登录"></a>
			</div>
        </div>
        <div class="login_box_btm"></div>
    </div>
<script type="text/javascript">
     $(function(){
    	 
    	  var quanxian='${cuo}';
    	 
     })

</script>



<script type="text/javascript">
$(function(){
	/* $(".submitLogin").click(function(){
		alert("asdasdas");	
		var email = $('#email').val();
		var password = $('#password').val();
		alert(email);
		alert(password);
		$("").submit();	
	}) */
	var userEmail = '${userEmail}';
	if(userEmail.length>0){
		alert(userEmail);
	}
	var loginCuowu = '${loginCuowu}';
	if(loginCuowu.length>0){
		alert(loginCuowu);
	}
	
	
	$("form#loginForm").submit(function(){
		
		
	})
	
	
	//验证表单
	 	/*$("#loginForm").validate({
	 		 onkeyup: false,
	    	focusCleanup:true, 
	        rules: {
	    	   	email: {
	    	    	required: true,
	    	    	email: true
	    	   	},
	    	   	password: {
	    	    	required: true
	    	   	}
	    	},
	    	messages: {
	    	   	email: {
	    	    	required: "请输入登录邮箱地址",
	    	    	email: "请输入有效的邮箱地址，如：vivi@lagou.com"
	    	   	},
	    	   	password: {
	    	    	required: "请输入密码"
	    	   	}
	    	},
	    	submitHandler:function(form){
	    		if($('#remember').prop("checked")){
	      			$('#remember').val(1);
	      		}else{
	      			$('#remember').val(null);
	      		}
	    		var email = $('#email').val();
	    		var password = $('#password').val();
	    		var remember = $('#remember').val();
	    		
	    		var callback = $('#callback').val();
	    		var authType = $('#authType').val();
	    		var signature = $('#signature').val();
	    		var timestamp = $('#timestamp').val();
	    		
	    		$(form).find(":submit").attr("disabled", true);
	            $.ajax({
	            	type:'POST',
	            	data:{email:email,password:password,autoLogin:remember, callback:callback, authType:authType, signature:signature, timestamp:timestamp},
	            	url:ctx+'/user/login.json'
	            }).done(function(result) {
					if(result.success){
					 	if(result.content.loginToUrl){
							window.location.href=result.content.loginToUrl;
	            		}else{
	            			window.location.href=ctx+'/';
	            		} 
					}else{
						$('#beError').text(result.msg).show();
					}
					$(form).find(":submit").attr("disabled", false);
	            }); 
	        }  
		});*/
})
</script>
</body>
</html>
