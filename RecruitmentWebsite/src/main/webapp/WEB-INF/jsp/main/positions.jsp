<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
﻿<!DOCTYPE HTML>
<html xmlns:wb="http://open.weibo.com/wb"><head>
<script async="" src="style/js/analytics.js"></script><script type="text/javascript" async="" src="style/js/conversion.js"></script><script src="style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script><style type="text/css"></style>
<meta content="no-siteapp" http-equiv="Cache-Control">
<link  media="handheld" rel="alternate">
<!-- end 云适配 -->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>我发布的职位-招聘服务-拉勾网-最专业的互联网招聘平台</title>
<meta content="23635710066417756375" property="qc:admins">
<meta name="description" content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网">
<meta name="keywords" content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招">
<meta content="QIQ6KC1oZ6" name="baidu-site-verification">

<!-- <div class="web_root"  style="display:none">http://www.lagou.com</div> -->
<script type="text/javascript">
var ctx = "http://www.lagou.com";
console.log(1);
</script>
<link href="http://www.lagou.com/images/favicon.ico" rel="Shortcut Icon">
<link href="style/css/style.css" type="text/css" rel="stylesheet">
<link href="style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="style/css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
<script src="style/js/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
<script src="style/js/additional-methods.js" type="text/javascript"></script>
<!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script src="style/js/conv.js" type="text/javascript"></script>
<script src="style/js/ajaxCross.json" charset="UTF-8"></script></head>
<script type="text/javascript">
	$(function(){
		$(".occupactions").click(function(){
			var state=$(this).html();
			var ostate=$(this).attr("ostate");
			var pk=$(this).attr("pk");
			
			$.ajax({
				type:"post",
				url:"ajaxqueryByOstateController.controller",
				data:{"pk":pk,"ostate":ostate},
				success:function(returnData){
					$(".content").html("");
					var sss="";
					var html="";
					var companySS=$("#companyid").val();	
					var number=returnData.length;
					var ostate=returnData.ostate;
					if(ostate=="0"){
						alert("123");
					}
					html+="<div class='company_center_content'><dt><h1><em></em>"+state+"<span>（共<i style='color:#fff;font-style:normal' id='positionNumber'>"+number+"</i>个）</span></h1></dt>";
					html+="<dd><form id='searchForm'><input type='hidden' value='Publish' name='type'>";
					html+="<ul class='reset my_jobs'>";
					$.each(returnData,function(index,data){
						html+="<li data-id='149594'>";
						html+=" <h3>";
						html+="<a target='_blank' title='随便写' href='http://www.lagou.com/jobs/149594.html'>"+data.oname+"</a>";
						html+=" <span>["+data.ocity+"]</span>";
						html+="  </h3>";
						html+="<a target='_blank' title='随便写' href=''></a> ";
						/*html+=" <span>"+[data.ocity]+"</span>";*/
						html+="<span class='receivedResumeNo'><a href=''>应聘简历</a></span>";
						if(data.onature==1){
							html+="  <div>全职";	
						}
						if(data.onature==2){
							html+="  <div>兼职";	
						}
						if(data.onature==3){
							html+="  <div>实习";	
						}
						var oeducation="";
						if(data.oeducation==1){
							oeducation="不限";
						}
						if(data.oeducation==2){
							oeducation="大专";
						}
						if(data.oeducation==3){
							oeducation="本科";
						}
						if(data.oeducation==4){
							oeducation="硕士";
						}
						if(data.oeducation==5){
							oeducation="博士";
						}
						
						html+="/"+data.ominsalary+"k-"+data.omaxsalary+"k/"+data.olog +"/"+oeducation;
						html+=" </div>";
						html+="<div class='c9'>发布时间："+ data.orelease+"</div>";
						html+="<div class='links'>";
										
						html+="<a class='job_refresh' href=''>刷新<span>每个职位7天内只能刷新一次</span></a><a target='_blank' class='job_edit' href='queryByoid.controller?oid='"+data.oid+"'>编辑</a>";
						
						if(state=="有效职位"){
							sss=0;
							html+="	<a  class='xiaxian' oid='"+data.oid+"' onclick='xiaxian("+data.oid+","+companySS+","+sss+",1)' href='javascript:void(0)'>下线</a>";
							
							/* onclick='return confirm('确认下线职位吗?下线后他人无法查看该职位!')' href='updateOstate.controller?oid='"+data.oid+"'&ostates=1&pk='"+company+"'&ostate=0'*/
						}
						if(state=="已下线职位"){
							sss=1;
							html+="<a class='shanxian' onclick='shangxian("+data.oid+","+companySS+","+sss+",0)'  oid='"+data.oid+"' href='javascript:void(0)'>上线</a>";
							
						}
						
						html+="<a class='deletes' onclick='deleteocc("+data.oid+","+companySS+","+sss+")' href='javascript:void(0)'>删除</a>";
						
					})
					html+="</div>";
					$(".content").html(html).hide().slideDown(1000);	
				}
			})	
		})	
	})
	 	function shangxian(oid,company,sss,ostate){
		$(".shanxian").attr("href","updateOstate.controller?oid="+oid+"&pk="+company+"&ostate="+sss+"&ostates="+ostate).click();
		
	}
	function xiaxian(oid,company,sss,ostate){
		$(".xiaxian").attr("href","updateOstate.controller?oid="+oid+"&pk="+company+"&ostate="+sss+"&ostates="+ostate).click();
		
	}
		function deleteocc(oid,company,sss){
		$(".deletes").attr("href","deleteOccupation.controller?oid="+oid+"&pk="+company+"&ostate="+sss).click();
		}
	/*$("#shanxian").click(function(){
			if(confirm("确认下线职位吗?下线后他人无法查看该职位!2")){
				var oid=$(this).attr("oid");
				var company=$("#companyid").val();		
				$(this).attr("href","updateOstate.controller?oid="+oid+"&ostates=0&pk="+company+"&ostate=0");
				$(this).click();
			}
			
		})
		$("#xiaxian").click(function(){
			if(confirm("确认下线职位吗?上线后他人无法查看该职位!1")){
				var oid=$(this).attr("oid");
				var company=$("#companyid").val();		
				$(this).attr("href","updateOstate.controller?oid="+oid+"&ostates=0&pk="+company+"&ostate=1").click();
			}
			
		})*/
	
</script>
<body>
<div id="body">
	<div id="header">
    	<div class="wrapper">
    		<a class="logo" href="http://www.lagou.com/">
    			<img width="229" height="43" alt="拉勾招聘-专注互联网招聘" src="style/images/logo.png">
    		</a>
    		<ul id="navheader" class="reset">
    			<li><a href="toIndex.controller">首页</a></li>
    			<li><a href="queryListCompany.controller">公司</a></li>
    			<li><a target="_blank" href="#">论坛</a></li>
    				    			<li><a rel="nofollow" href="toResume.controller">我的简历</a></li>
	    						    		</ul>
	    						    		<jsp:include page="/mainjsp/navigation/navigation.jsp"></jsp:include>
        	      <!--   	<dl class="collapsible_menu">
            	<dt>
           			<span>jason&nbsp;</span> 
            		<span class="red" id="noticeDot-0"></span>
            		<i></i>
            	</dt>
                                	<dd><a rel="nofollow" href="jianli.html">我的简历</a></dd>
                	                	<dd><a href="collections.html">我收藏的职位</a></dd>
                	                	                	<dd><a href="delivery.html">我投递的职位 <span id="noticeNo" class="red">(1)</span></a></dd>
                	                	<dd class="btm"><a href="subscribe.html">我的订阅</a></dd>
                	<dd><a href="create.html">我要招人</a></dd>
                                                <dd><a href="accountBind.html">帐号设置</a></dd>
                                <dd class="logout"><a rel="nofollow" href="login.html">退出</a></dd>
            </dl>--> 
                                    <div id="noticeTip">
            	<span class="bot"></span>
				<span class="top"></span>
				<a target="_blank" href="delivery.html"><strong>1</strong>条新投递反馈</a>
				<a class="closeNT" href="javascript:;"></a>
            </div>
                    </div>
    </div><!-- end #header -->
    <div id="container">
                	<div class="sidebar">
                	<input type="hidden" id="companyid" value="${companys.cid}">
            	<a class="btn_create" href="tocreate.controller">发布新职位</a>
                <dl class="company_center_aside">
                <!--  
		<dt>我收到的简历</dt>
		<dd>
		<a href="unHandleResumes.html">待处理简历</a> 
			</dd>
	<dd>
		<a href="canInterviewResumes.html">待定简历</a>
	</dd>
	<dd>
		<a href="haveNoticeResumes.html">已通知面试简历</a>
	</dd>
	<dd>
		<a href="haveRefuseResumes.html">不合适简历</a>
	</dd>
	<dd class="btm">
		<a href="autoFilterResumes.html">自动过滤简历</a> 
			</dd>
</dl>
<dl class="company_center_aside">-->
		<dt>我发布的职位</dt>
			<dd class="current">
		<a href="javascript:void(0)" pk="${companys.cid}" ostate="0" class="occupactions"  >有效职位</a>
	</dd>
	<dd>
		<a href="javascript:void(0)" pk="${companys.cid}" ostate="1" class="occupactions" >已下线职位</a>
	</dd>
	</dl>
            </div><!-- end .sidebar -->
            <div class="content">
            	<dl class="company_center_content">
                    <dt><h1><em></em><c:if test="${ostate eq '1'}">已下线</c:if><c:if test="${ostate eq '0'}">有效</c:if>职位 <span>（共<i style="color:#fff;font-style:normal" id="positionNumber">${size}</i>个）</span></h1></dt>
                    <dd>
                    		                    	<form id="searchForm">
	                    		<input type="hidden" value="Publish" name="type">
			                	<ul class="reset my_jobs">
			                				<c:forEach items="${Occupation}" var="occ">
				                			                            	<li data-id="149594">
		                                    <h3>
		                                        <a target="_blank" title="随便写" href="http://www.lagou.com/jobs/149594.html">${occ.oname}</a> 
		                                        <span>[${occ.ocity}]</span>
		                                        						                        		                                    </h3>
		                                    		                                  		<span class="receivedResumeNo"><a href="unHandleResumes.html?positionId=149594">应聘简历</a></span>
		                                  			                                    <div><c:if test="${occ.onature eq '1'}">全职</c:if>
		                                  			                                    	 <c:if test="${occ.onature eq '2'}">兼职</c:if>
		                                  			                                    	 <c:if test="${occ.onature eq '3'}">实习</c:if>/ 
		                                  			                                    	 ${occ.ominsalary}k-${occ.omaxsalary}k/ 
		                                  			                                    	 ${occ.olog} /
		                                  			                                    	 <c:if test="${occ.oeducation eq '1'}">不限</c:if>
		                                  			                                    	 <c:if test="${occ.oeducation eq '2'}">大专</c:if>
		                                  			                                    	 <c:if test="${occ.oeducation eq '3'}">本科</c:if>
		                                  			                                    	 <c:if test="${occ.oeducation eq '4'}">硕士</c:if>
		                                  			                                    	 <c:if test="${occ.oeducation eq '5'}">博士</c:if>
		                                  			                                    	 
		                                  			                                    	 </div>
		                                    		                                    				                                    <div class="c9">发布时间： ${occ.orelease}</div>
			                                    		                                    		                                    		                                    <div class="links">
		                                    			                                       	<a class="job_refresh" href="javascript:void(0)">刷新<span>每个职位7天内只能刷新一次</span></a>
		                                       			                                       	<a target="_blank" class="job_edit" href="queryByoid.controller?oid=${occ.oid}">编辑</a>
		                                       	<c:if test="${ostate eq '0'}">
		                                       	<a onclick="return confirm('确认下线职位吗?下线后他人无法查看该职位!')" href="updateOstate.controller?oid=${occ.oid}&ostates=1&pk=${companys.cid}&ostate=${ostate}">下线</a>   
		                                       	</c:if>
		                                       	 <c:if test="${ostate eq '1'}">
		                                       	<a onclick="return confirm('确认上线职位吗?上线后他人可以查看该职位!')" href="updateOstate.controller?oid=${occ.oid}&ostates=0&pk=${companys.cid}&ostate=${ostate}">上线</a>   
		                                       	</c:if>                  
		                                        <a onclick="return confirm('确认删除职位吗?')" href="deleteOccupation.controller?oid=${occ.oid}&pk=${companys.cid}&ostate=${ostate}">删除</a>
		                                    </div>
		                                    		                                </li>
		                                    </c:forEach>
	                                	                           	</ul>
	                                	                           	<input name="ostate" value="${ostate}" type="hidden">
		                                  			                <input name="pk" value="${companys.cid}" type="hidden">
			                    			                </form>
		                                    </dd>
                </dl>
            </div><!-- end .content -->
<script src="style/js/job_list.min.js" type="text/javascript"></script> 
			<div class="clear"></div>
			<input type="hidden" value="74fb1ce14ebf4e2495270b0fbad64704" id="resubmitToken">
	    	<a rel="nofollow" title="回到顶部" id="backtop"></a>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<a rel="nofollow" target="_blank" href="about.html">联系我们</a>
		    <a target="_blank" href="http://www.lagou.com/af/zhaopin.html">互联网公司导航</a>
		    <a rel="nofollow" target="_blank" href="http://e.weibo.com/lagou720">拉勾微博</a>
		    <a rel="nofollow" href="javascript:void(0)" class="footer_qr">拉勾微信<i></i></a>
			<div class="copyright">&copy;2013-2014 Lagou <a href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">京ICP备14023790号-2</a></div>
		</div>
	</div>

<script src="style/js/core.min.js" type="text/javascript"></script>
<script src="style/js/popup.min.js" type="text/javascript"></script>
<script src="style/js/tongji.js" type="text/javascript"></script>
<!--  -->
<script src="style/js/analytics01.js" type="text/javascript"></script><script type="text/javascript" src="style/js/h.js"></script>
<script type="text/javascript">
$(function(){
	$('#noticeDot-1').hide();
	$('#noticeTip a.closeNT').click(function(){
		$(this).parent().hide();
	});
});
var index = Math.floor(Math.random() * 2);
var ipArray = new Array('42.62.79.226','42.62.79.227');
var url = "ws://" + ipArray[index] + ":18080/wsServlet?code=314873";
var CallCenter = {
		init:function(url){
			var _websocket = new WebSocket(url);
			_websocket.onopen = function(evt) {
				console.log("Connected to WebSocket server.");
			};
			_websocket.onclose = function(evt) {
				console.log("Disconnected");
			};
			_websocket.onmessage = function(evt) {
				//alert(evt.data);
				var notice = jQuery.parseJSON(evt.data);
				if(notice.status[0] == 0){
					$('#noticeDot-0').hide();
					$('#noticeTip').hide();
					$('#noticeNo').text('').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
					$('#noticeNoPage').text('').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
				}else{
					$('#noticeDot-0').show();
					$('#noticeTip strong').text(notice.status[0]);
					$('#noticeTip').show();
					$('#noticeNo').text('('+notice.status[0]+')').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
					$('#noticeNoPage').text(' ('+notice.status[0]+')').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
				}
				$('#noticeDot-1').hide();
			};
			_websocket.onerror = function(evt) {
				console.log('Error occured: ' + evt);
			};
		}
};
CallCenter.init(url);
</script>

<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button><div id="cboxLoadingOverlay" style="float: left;"></div><div id="cboxLoadingGraphic" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div></body></html>
