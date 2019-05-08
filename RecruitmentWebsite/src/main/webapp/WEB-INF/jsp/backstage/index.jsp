<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>拉勾网后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="backstagestyle/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="backstagestyle/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="backstagestyle/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath }/webjars/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript">
	
	function timesUp(){
		var myDate = new Date();
		myDate.getYear();        //获取当前年份(2位)
		myDate.getFullYear();    //获取完整的年份(4位,1970-????)
		myDate.getMonth();       //获取当前月份(0-11,0代表1月)
		myDate.getDate();        //获取当前日(1-31)
		myDate.getDay();         //获取当前星期X(0-6,0代表星期天)
		myDate.getTime();        //获取当前时间(从1970.1.1开始的毫秒数)
		myDate.getHours();       //获取当前小时数(0-23)
		myDate.getMinutes();     //获取当前分钟数(0-59)
		myDate.getSeconds();     //获取当前秒数(0-59)
		myDate.getMilliseconds();    //获取当前毫秒数(0-999)
		myDate.toLocaleDateString();     //获取当前日期
		var mytime=myDate.toLocaleTimeString();     //获取当前时间
		myDate.toLocaleString( );        //获取日期与时间
		//alert("asd");
		$("#shijianjs").html(mytime);
	}
	setInterval("timesUp()",1000);
	
</script>
<div class="header">

    <div class="dl-title">
        现在时间：<span id="shijianjs"></span>
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${loginUserAdmin.ausername }</span><a href="doOutAdminuser.controller" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>		<!-- <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li> -->

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="backstagestyle/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="backstagestyle/assets/js/bui-min.js"></script>
<script type="text/javascript" src="backstagestyle/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="backstagestyle/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{text:'系统管理',items:[{id:'12',text:'公司管理',href:'toNodeIndex.controller'},{id:'3',text:'用户管理',href:'toRecuitUserIndex.controller'},{id:'4',text:'管理员',href:'toUserIndex.controller'},{id:'6',text:'职位管理',href:'toMenuIndex.controller'}]}]},{id:'7',homePage : '9',menu:[{text:'业务管理',items:[{id:'9',text:'查询业务',href:'toNodeIndex.controller'}]}]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>
