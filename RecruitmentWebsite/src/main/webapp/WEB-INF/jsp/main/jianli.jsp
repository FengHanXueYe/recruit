<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
﻿<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:wb="http://open.weibo.com/wb"><head>
</script><script type="text/javascript" async="" src="style/js/conversion.js"></script><script src="style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script><style type="text/css"></style>
<meta content="no-siteapp" http-equiv="Cache-Control">
<link  media="handheld" rel="alternate">
<!-- end 云适配 -->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>我的简历-拉勾网-最专业的互联网招聘平台</title>
<meta content="23635710066417756375" property="qc:admins">
<meta name="description" content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网">
<meta name="keywords" content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招">
<meta content="QIQ6KC1oZ6" name="baidu-site-verification">

<!-- <div class="web_root"  style="display:none">h</div> -->
<script type="text/javascript">
var ctx = "h";
console.log(1);
</script>
<link href="h/images/favicon.ico" rel="Shortcut Icon">
<link href="style/css/style.css" type="text/css" rel="stylesheet">
<link href="style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="style/css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
<script src="style/js/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
<script src="style/js/additional-methods.js" type="text/javascript"></script>

<!-- sk -->
<link href="alertDemo/css/style.css" rel="stylesheet" />
<!-- <script src="alertDemo/js/jquery-1.7.1.min.js"></script> -->
<script src="alertDemo/js/ui.js"></script>



<!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script src="style/js/conv.js" type="text/javascript"></script>
<script src="style/js/ajaxCross.json" charset="UTF-8"></script></head>
<body>
<div id="body">
	<div id="header">
    	<div class="wrapper">
    		<a class="logo" href="h/">
    			<img width="229" height="43" alt="拉勾招聘-专注互联网招聘" src="style/images/logo.png">
    		</a>
    		<ul id="navheader" class="reset">
    			<li><a href="toIndex.controller">首页</a></li>
    			<li><a href="queryListCompany.controller">公司</a></li>
    			<li><a target="_blank" href="h/toForum.html">论坛</a></li>
    				    			<li class="current"><a rel="nofollow" href="jianli.html">我的简历</a></li>
	    						    		</ul>
	    				<jsp:include page="/mainjsp/navigation/navigation.jsp"></jsp:include>		    		
        	        	<!-- <dl class="collapsible_menu">
            	<dt>
           			<span>jason&nbsp;</span> 
            		<span class="red dn" id="noticeDot-0"></span>
            		<i></i>
            	</dt>
                                	<dd><a rel="nofollow" href="jianli.html">我的简历</a></dd>
                	                	<dd><a href="collections.html">我收藏的职位</a></dd>
                	                	                	<dd class="btm"><a href="subscribe.html">我的订阅</a></dd>
                	<dd><a href="create.html">我要招人</a></dd>
                                                <dd><a href="accountBind.html">帐号设置</a></dd>
                                <dd class="logout"><a rel="nofollow" href="login.html">退出</a></dd>
            </dl> -->
                                    <div class="dn" id="noticeTip">
            	<span class="bot"></span>
				<span class="top"></span>
				<a target="_blank" href="delivery.html"><strong>0</strong>条新投递反馈</a>
				<a class="closeNT" href="javascript:;"></a>
            </div>
                    </div>
    </div><!-- end #header -->
    <div id="container">
        
  		<div class="clearfix">
            <div class="content_l">
            	<div class="fl" id="resume_name">
	            	<div class="nameShow fl">
	            		<h1 title="jason的简历">
	            			<c:if test="${empty loginUser.resumeName }">${loginUser.email }</c:if>
	            			<c:if test="${!empty loginUser.resumeName }">${loginUser.resumeName }</c:if>
	            		</h1>
	            		<span class="rename">重命名</span> | <a target="_blank" href="doCheckView.controller?userid=${loginUser.userid }">预览</a>
            		</div>
            		<form class="fl dn"  method="post" action="doUpdateResumename.controller">
            			<input type="text" value="<c:if test="${empty loginUser.resumeName }">${loginUser.email }</c:if><c:if test="${!empty loginUser.resumeName }">${loginUser.resumeName }</c:if>" name="resumeName" class="nameEdit c9">	
            			<input type="submit" value="保存"> | <a target="_blank" href="h/resume/preview.html">预览</a>
            		</form>
            	</div><!--end #resume_name-->
            	<div class="fr c5" id="lastChangedTime">最后一次更新：<span><fmt:formatDate value="${loginUser.registrationTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒" /></span></div><!--end #lastChangedTime-->
            	
            	<!-- ----------------------------------- -->
            	
            	<div id="resumeScore">
            		<div class="score fl">
            			<canvas height="120" width="120" id="doughnutChartCanvas" style="width: 120px; height: 120px;"></canvas>
           				<div style="" class="scoreVal"><span id="jindutiao">${jindutiao}</span>分</div>
               </div>	
            		
            		
            		<script type="text/javascript">
                            $(function(){
                                 $("#jindutiao").text(parseInt($("#jindutiao").text())+10);

                                 var jindu= $("#jindutiao").text();
                                 alert(jindu);
                                 if(jindu==100){

                                	 mizhu.alert('提示','信息已完善,快去投个简历吧!','alert_red');
                                    }
                                 

                                 /* $('#profileForm').submit(function() {
                                    
                                	 $("#jindutiao").text(parseInt($("#jindutiao").text())+10);
                                	});     */


                                 
                                 /* 28 100  3   自我描述作品展示20 25  3  75 */
                                     
                                     /* if(jianli()==false){

                                     return false;
                                     }else{
                                    	 alert("提交成功！"); 
                                        
                                     }
                                     
                                     return true;
                                    } */
                               
                            
                            /* 	$("#jindutiao").text(parseInt($("#jindutiao").text())+15); */
                              /*   var edu=$("select[name='education']").val();
                                if(edu!=null &&edu!=''){
                					$("#jindutiao").text(parseInt($("#jindutiao").text())+5);
                					alert('1')
                    				}
                				var log=$("select[name='userlog']").val();
                				var eedu=$("select[name='eeducation']").val();
                				var py=$("select[name='pyear']").val();
                				var pye=$("select[name='pyearover']").val();
                				
                				else if(log!=null &&log!=''){
                					$("#jindutiao").text(parseInt($("#jindutiao").text())+5);
                    				}
                				else if(eedu!=null &&eedu!=''){
                					$("#jindutiao").text(parseInt($("#jindutiao").text())+5);
                    				}
                				else if(py!=null &&py!=''){
                					$("#jindutiao").text(parseInt($("#jindutiao").text())+5);
                    				}
                				else if(pye!=null &&pye!=''){
                					$("#jindutiao").text(parseInt($("#jindutiao").text())+5);
                    				} */
                            	
                                })

            		</script>
            		
            		
            		
               <!-- ----------------------------------- -->	
            		<div class="which fl">
            			<div>工作经历最能体现自己的工作能力，且完善后才可投递简历哦！</div>
            										<span rel="workExperience"><a>马上去完善</a></span>
						            		</div>
            	</div><!--end #resumeScore-->

            	<div class="profile_box" id="basicInfo">
            		<h2>基本信息</h2>
            		<span class="c_edit"></span>
            		<div class="basicShow">
            			            			<span><c:if test="${!empty loginUser.username }">${loginUser.username } |</c:if>
            			            			<c:if test="${!empty loginUser.gender}"><c:if test="${loginUser.gender eq '2' }">男</c:if><c:if test="${loginUser.gender eq '1' }">女</c:if> |</c:if>
            			            			<c:if test="${!empty loginUser.education }"><c:if test="${loginUser.education eq '1'}">大专</c:if><c:if test="${loginUser.education eq '2'}">本科</c:if><c:if test="${loginUser.education eq '3'}">硕士</c:if><c:if test="${loginUser.education eq '4'}">博士</c:if><c:if test="${loginUser.education eq '5'}">其它</c:if> |</c:if>
            			            			<c:if test="${!empty loginUser.userlog }"><c:if test="${loginUser.userlog eq '1'}">应届毕业生</c:if><c:if test="${loginUser.userlog eq '2'}">1年</c:if><c:if test="${loginUser.userlog eq '3'}">2年</c:if><c:if test="${loginUser.userlog eq '4'}">3年</c:if><c:if test="${loginUser.userlog eq '5'}">4年</c:if><c:if test="${loginUser.userlog eq '6'}">5年</c:if><c:if test="${loginUser.userlog eq '7'}">6年</c:if><c:if test="${loginUser.userlog eq '8'}">7年</c:if><c:if test="${loginUser.userlog eq '9'}">8年</c:if><c:if test="${loginUser.userlog eq '10'}">9年</c:if><c:if test="${loginUser.userlog eq '11'}">10年</c:if><c:if test="${loginUser.userlog eq '12'}">10年以上</c:if> |<br></c:if>
            			            			<c:if test="${!empty loginUser.telephone }">${loginUser.telephone } |</c:if>
            			            			  ${loginUser.email }<br>
            			</span>
            			<div class="m_portrait">
	                    	<div></div>
	                    	<c:if test="${empty loginUser.userpicture }">
	                    		<img width="120" height="120" alt="jason" src="style/images/default_headpic.png">
	                    	</c:if>
	                    	<c:if test="${!empty loginUser.userpicture }">
	                    		<img width="120" height="120" alt="jason" src="${loginUser.userpicture }">
	                    	</c:if>
	                    </div>
            		</div><!--end .basicShow-->

            		<div class="basicEdit dn">
            		<!-- <form id="kkkkkkk" action="doUpdateResumename.controller" method="post"> -->
            			<form  method="post" id="profileForm" onsubmit="false" enctype="multipart/form-data">
						  <table>
						    <tbody><tr>
						      <td valign="top">
						        <span class="redstar">*</span>
						      </td> 
						      <td>
						        <input type="text" placeholder="姓名" value="${loginUser.username }" name="username" id="name">
						      </td>
						      <td valign="top"></td> 
						      <td>
						          <ul class="profile_radio clearfix reset" id="sex">
						            <li  <c:if test="${loginUser.gender eq '2' }">class="current"</c:if> >
						           	  	 男<em></em>
						           	  	 
						              	<input type="radio" name="gender" value="2"> 
						            </li>
						            <li <c:if test="${loginUser.gender eq '1' }">class="current"</c:if>>
						            	  女<em></em>
						              	<input type="radio" name="gender" value="1"> 
						            </li>
						          </ul>  
						      </td>
						      
						      <td rowspan="2"><div style="margin-left:30px;width:120px;height:120px;border-radius: 50%;background-image:url(/images/timg1.jpg);overflow: hidden " >
						      					<c:if test="${!empty loginUser.userpicture }"><img src="${loginUser.userpicture }" alt="正在加载。。。" width="120px" height="120px" /></c:if></div><p id = "miaoshipicture" style="cursor:pointer;width:120px;height:30px;line-height:30px; text-align: center;background-color: rgba(0,0,0,0.5);color:white;margin-left:30px;" >上传头像</p>
						      				  <input type="file" value="" style="display:none" title="支持jpg、jpeg、gif、png格式，文件小于5M" onchange="updatepictureuser()" name="file" id="filekuang">
						      </td>
						    </tr>
						    <tr>
						      <td valign="top">
						        <span class="redstar">*</span>
						      </td> 
						      <td>
						      	<input type="hidden" id="topDegree" value="${loginUser.education }" name="education">
						        <%-- <input type="button" value="${loginUser.education }" id="select_topDegree" class="profile_select_190 profile_select_normal"> --%>
						        <div>
						        	<select name="education" style="width:166px;border:2px solid #EEE9E9;height:40px;font-size:18px">
										<option selected value="">---请选择---</option>
										<option value="1">大专</option>
										<option value="2">本科</option>
										<option value="3">硕士</option>
										<option value="4">博士</option>
										<option value="5">其他</option>
									</select>
						        </div>
								<!-- <div class="boxUpDown boxUpDown_190 dn" id="box_topDegree" style="display: none;">
									
						        <ul>
						        								        			<li>大专</li>
						        								        			<li>本科</li>
						        								        			<li>硕士</li>
						        								        			<li>博士</li>
						        								        			<li>其他</li>
						        								        	
						        </div>   -->
						      </td>
						      <td valign="top">
						        <span class="redstar">*</span>
						      </td> 
						      <td>
						          <input type="hidden" id="workyear" value="${loginUser.userlog }" name="userlog">
						         <%--  <input type="button" value="${loginUser.userlog }" id="select_workyear" class="profile_select_190 profile_select_normal"> --%>
						         <div>
						         	  <select name="userlog" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:18px">
						         	  		<option selected value="">---请选择---</option>
								  			<option value="1">应届毕业生</option>
								  			<option value="2">1年</option>
								  			<option value="3">2年</option>
								  			<option value="4">3年</option>
								  			<option value="5">4年</option>
								  			<option value="6">5年</option>
								  			<option value="7">6年</option>
								  			<option value="8">7年</option>
								  			<option value="9">8年</option>
								  			<option value="1">9年</option>
								  			<option value="11">10年</option>
								  			<option value="12">10年以上</option>
								  		</select> 
						         </div>
								  <!-- <div class="boxUpDown boxUpDown_190 dn" id="box_workyear" style="display: none;">
								  		
						          	<ul>
						        								        			<li>应届毕业生</li>
						        								        			<li>1年</li>
						        								        			<li>2年</li>
						        								        			<li>3年</li>
						        								        			<li>4年</li>
						        								        			<li>5年</li>
						        								        			<li>6年</li>
						        								        			<li>7年</li>
						        								        			<li>8年</li>
						        								        			<li>9年</li>
						        								        			<li>10年</li>
						        								        			<li>10年以上</li>
						        								        	 </ul> 
						          </div>   -->
						      </td>
						       
						    </tr>
						    <tr>
						      <td valign="top">
						        <span class="redstar">*</span>
						      </td> 
						      <td colspan="3">
						          <input type="text" placeholder="手机号码" value="${loginUser.telephone }" name="telephone" id="tel">
						      </td>
						       
						   	</tr>
						   	<tr>
						      <td valign="top">
						        <span class="redstar">*</span>
						      </td> 
						      <td colspan="3">
						          <input type="text" placeholder="接收面试通知的邮箱" value="${loginUser.email }" name="email" id="email">
						      </td>
						      
						    </tr>
						    <tr>
						      <td valign="top"> </td> 
						      <td colspan="3">
						          <input type="hidden" id="currentState" value="${loginUser.currentstate }" name="currentstate">
						          <input type="button" value="${loginUser.currentstate }" id="select_currentState" class="profile_select_410 profile_select_normal">
								  <div class="boxUpDown boxUpDown_410 dn" id="box_currentState" style="display: none;">
						          	  <ul>
						        								        			<li>我目前已离职，可快速到岗</li>
						        								        			<li>我目前正在职，正考虑换个新环境</li>
						        								        			<li>我暂时不想找工作</li>
						        								        			<li>我是应届毕业生</li>
						        								        	  </ul>
						          </div>  
						      </td>
						       <td></td>
						    </tr>
						    <tr>
						      <td></td> 
						      <td colspan="3">
						          <input type="submit" onclick="jianli()" value="保 存" class="btn_profile_save"> 
						          <a class="btn_profile_cancel" href="javascript:;">取 消</a>
						          <!-- <input type="button" value="保 存" onclick="jianli()"> --> 
						      </td>
						       <td></td>
						    </tr>
						  </tbody></table>
						 <input type="hidden" name="xueli" />
						 <input type="hidden" name="jingyan" />
						</form><!--end #profileForm-->
						<!-- </form> -->
						<!-- <div class="new_portrait">
						  <div class="portrait_upload" id="portraitNo">
						      <span>上传自己的头像</span>
						  </div>
						  <div class="portraitShow dn" id="portraitShow">
						    <img width="120" height="120" src="">
						    <span id="miaoshipicture">更换头像</span>
						  </div>
						  <input type="file" value="" title="支持jpg、jpeg、gif、png格式，文件小于5M" onchange="updatepictureuser()" name="file" id="headPic" class="myfiles">
							<input type="hidden" id="headPicHidden" />
						  	<em>
						                  尺寸：120*120px <br>   
						                  大小：小于5M
						  	</em>
						  	<span style="display:none;" id="headPic_error" class="error"></span>
						</div>end .new_portrait -->
						<script type="text/javascript">
							function updatepictureuser(){
								$("#miaoshipicture").html("加载中...");
							}
							$(function(){
								$("#miaoshipicture").click(function(){
									$("#filekuang").click();
								})
								
							})
						</script>
            		</div><!--end .basicEdit-->
            		<input type="hidden" id="nameVal" value="${loginUser.username }">
            		<input type="hidden" id="genderVal" value="<c:if test="${loginUser.gender eq '2' }">男</c:if><c:if test="${loginUser.gender eq '1' }">女</c:if>">
            		<input type="hidden" id="topDegreeVal" name= "topDegreeVal" value="">
            		<input type="hidden" id="workyearVal" name= "workyearVal" value="">
            		<input type="hidden" id="currentStateVal" value="${loginUser.currentstate }">
            		<input type="hidden" id="emailVal" value="${loginUser.email }">
            		<input type="hidden" id="telVal" value="${loginUser.telephone }">
            		
            		
            		
            		
            		
            		<script type="text/javascript">
        /* --------------------------自制js-------------------------- */    		
            			$(function(){
            				var jiaoyubeijin = '${jiaoyubeijin}';
            				if(jiaoyubeijin.length>0){
            					alert(jiaoyubeijin);
            				}
            				$("select[name='education']").val("${loginUser.education}");
            				$("select[name='userlog']").val("${loginUser.userlog}");
            				$("select[name='eeducation']").val("${educationalbackground.eeducation}");
            				$("select[name='pyear']").val("${educationalbackground.pyear}");
            				$("select[name='pyearover']").val("${educationalbackground.pyearover}");
            				
            				$("select[name='education']").change(function(){
            					var xl = $(this).val();
            					$("input[name='xueli']").val(xl);
            				})
            				$("select[name='userlog']").change(function(){
            					var jy = $(this).val();
            					$("input[name='jingyan']").val(jy)
            				})
            			})
            			/* 简历 */
            			function jianli(){

								$('#profileForm').attr("action","doUpdateResumename.controller");
								$('#profileForm').submit();
						}
        				/* 教育背景 */
        				
        				/* 作品展示 */
        				function zhanshi(){
	            			  mizhu.alert('提示', '信息完善成功','alert_blue');
//	            			alert('1');
    
	           			 $.ajax({  
	    			            type: "POST", 
	    			            url:"doAddUpdateWorksdisplay.controller",
	    			            data:$('#zhanshiform').serialize(),
	    			            error: function(request) {  
	    			            },  
	    			            success: function(data) {
	    			              
	    			               mizhu.alert('提示', '信息完善成功','alert_blue');
	    			               $("#jindutiao").text(parseInt($("#jindutiao").text())+15);
	    			            }  
	    			         });
							
        				}
            		</script>
            		<input type="hidden" id="pageType" value="1"> 
            	</div><!--end #basicInfo-->

            	<div class="profile_box" id="expectJob">
            		<h2>期望工作</h2>
            		            		<span class="c_edit dn"></span>
            		<div class="expectShow dn">
            		            			<span></span>
            		</div><!--end .expectShow-->
            		<div class="expectEdit dn">
            			<form id="expectForm1" onsubmit="false">
	            			<table>
	            				<tbody><tr>
	            					<td>
	            						<input type="hidden" id="expectCity" value="" name="expectCity">
	            																<c:if test="${!empty detailHopeJob.hcity }">
		            													        	<input type="button" value="${detailHopeJob.hcity }" name="hcityx" id="select_expectCity" class="profile_select_287 profile_select_normal">
	            																</c:if>
	            																<c:if test="${empty detailHopeJob.hcity }">
		            													        	<input type="button" value="期望城市，如：北京" name="hcityx" id="select_expectCity" class="profile_select_287 profile_select_normal">
	            																</c:if>
																				<div class="boxUpDown boxUpDown_596 dn" id="box_expectCity" style="display: none;">
								          									        		<dl>
								        			<dt>热门城市</dt>
								        			<dd>
									        												        				<span>北京</span>
									        												        				<span>上海</span>
									        												        				<span>广州</span>
									        												        				<span>深圳</span>
									        												        				<span>成都</span>
									        												        				<span>杭州</span>
									        											        			</dd>
								        	  	</dl>
								        									        		<dl>
								        			<dt>ABCDEF</dt>
								        			<dd>
									        												        				<span>北京</span>
									        												        				<span>长春</span>
									        												        				<span>成都</span>
									        												        				<span>重庆</span>
									        												        				<span>长沙</span>
									        												        				<span>常州</span>
									        												        				<span>东莞</span>
									        												        				<span>大连</span>
									        												        				<span>佛山</span>
									        												        				<span>福州</span>
									        											        			</dd>
								        	  	</dl>
								        									        		<dl>
								        			<dt>GHIJ</dt>
								        			<dd>
									        												        				<span>贵阳</span>
									        												        				<span>广州</span>
									        												        				<span>哈尔滨</span>
									        												        				<span>合肥</span>
									        												        				<span>海口</span>
									        												        				<span>杭州</span>
									        												        				<span>惠州</span>
									        												        				<span>金华</span>
									        												        				<span>济南</span>
									        												        				<span>嘉兴</span>
									        											        			</dd>
								        	  	</dl>
								        									        		<dl>
								        			<dt>KLMN</dt>
								        			<dd>
									        												        				<span>昆明</span>
									        												        				<span>廊坊</span>
									        												        				<span>宁波</span>
									        												        				<span>南昌</span>
									        												        				<span>南京</span>
									        												        				<span>南宁</span>
									        												        				<span>南通</span>
									        											        			</dd>
								        	  	</dl>
								        									        		<dl>
								        			<dt>OPQR</dt>
								        			<dd>
									        												        				<span>青岛</span>
									        												        				<span>泉州</span>
									        											        			</dd>
								        	  	</dl>
								        									        		<dl>
								        			<dt>STUV</dt>
								        			<dd>
									        												        				<span>上海</span>
									        												        				<span>石家庄</span>
									        												        				<span>绍兴</span>
									        												        				<span>沈阳</span>
									        												        				<span>深圳</span>
									        												        				<span>苏州</span>
									        												        				<span>天津</span>
									        												        				<span>太原</span>
									        												        				<span>台州</span>
									        											        			</dd>
								        	  	</dl>
								        									        		<dl>
								        			<dt>WXYZ</dt>
								        			<dd>
									        												        				<span>武汉</span>
									        												        				<span>无锡</span>
									        												        				<span>温州</span>
									        												        				<span>西安</span>
									        												        				<span>厦门</span>
									        												        				<span>烟台</span>
									        												        				<span>珠海</span>
									        												        				<span>中山</span>
									        												        				<span>郑州</span>
									        											        			</dd>
								        	  	</dl>
								        									        </div>  
	            					</td>
	            					<td>
	            						<ul class="profile_radio clearfix reset">
	            							
	            								<li <c:if test="${detailHopeJob.htype eq '1' }">class="current"</c:if> >
									             	 全职<em></em>
									              	<input type="radio" name="type" value="全职"> 
									            </li>
									            <li <c:if test="${detailHopeJob.htype eq '2' }">class="current"</c:if>>
									              	兼职<em></em>
									              	<input type="radio" name="type" value="兼职"> 
									            </li>
						 			            <li <c:if test="${detailHopeJob.htype eq '3' }">class="current"</c:if>>
									            	  实习<em></em>
									              	<input type="radio" name="type" value="实习"> 
									              	<input type="hidden" name="htype"  />
									            </li>
								        </ul> 
	            					</td>
	            				</tr>
	            				<tr>
	            					<td>
	            						<c:if test="${!empty detailHopeJob.hname }">
								        	<input type="text" placeholder="" value="${detailHopeJob.hname }" name="hname" id="expectPosition">
	            						</c:if>
	            						<c:if test="${empty detailHopeJob.hname }">
								        	<input type="text" placeholder="期望工作 如：产品经理" value="" name="hname" id="expectPosition">
	            						</c:if>
									</td>
	            					<td>
	            						<input type="hidden" id="expectSalary" value="" name="expectSalary">
	            						
	            							            						<input type="button" value="期望月薪" name="hmoneyx" id="select_expectSalary" class="profile_select_287 profile_select_normal">
	            													        	<div class="boxUpDown boxUpDown_287 dn" id="box_expectSalary" style="display: none;">
								          	  <ul>
								        										        			<li>2k以下</li>
								        										        			<li>2k-5k</li>
								        										        			<li>5k-10k</li>
								        										        			<li>10k-15k</li>
								        										        			<li>15k-25k</li>
								        										        			<li>25k-50k</li>
								        										        			<li>50k以上</li>
								        										        			
								        										        	  </ul>
								         </div>  
	            					</td>
	            				</tr>
	            				<tr>
	            					<td colspan="2">
										<input type="button" value="保 存" onclick="updateHobiect()" class="btn_profile_save">
						          		<a class="btn_profile_cancel" href="javascript:;">取 消</a>
	            					</td>
	            				</tr>
	            			</tbody></table>
	            			<input type="hidden" name="hmoney" />
	            			<input type="hidden" name="hcity" />
            			</form>
            			<!--end #expectForm-->
            		</div><!--end .expectEdit-->
            		            		<div class="expectAdd pAdd">
            		            			填写准确的期望工作能大大提高求职成功率哦…<br>
						快来添加期望工作吧！
						<span>添加期望工作</span>
            		</div><!--end .expectAdd-->
            		<!-- asd -->
            		<input type="hidden" id="expectJobVal" value="">
            		<input type="hidden" id="expectCityVal" value="">
            		<input type="hidden" id="typeVal" value="">
            		<input type="hidden" id="expectPositionVal" value="">
            		<input type="hidden" id="expectSalaryVal" value="">
            	</div><!--end #expectJob-->
            	<!-- 期望工作 -->
            	<script type="text/javascript">
            		$(function(){
            			var qian = '${detailHopeJob.hmoney}';
            			var qianxp = "";
            			if(qian==2){
            				qianxp = "2k以下";
            			}else if(qian==5){
            				qianxp = "2k-5k";
            			}else if(qian==10){
            				qianxp = "5k-10k";
            			}else if(qian==15){
            				qianxp = "10k-15k";
            			}else if(qian==25){
            				qianxp = "15k-25k";
            			}else if(qian==50){
            				qianxp = "25k-50k";
            			}else{
            				qianxp = "50k以上";
            			}
            			$("form#expectForm1 input[name='hmoneyx']").val(qianxp);
            		})
            		function updateHobiect(){
            			var zhi = $("form#expectForm1 .current input[type='radio']").val();
            			var htype = 0;
            			if(zhi=="全职"){
            				htype = 1;
            			}else if(zhi=="兼职"){
            				htype = 2;
            			}else{
            				htype = 3;
            			}
            			var money = $("form#expectForm1 input[name='hmoneyx']").val();
            			var m = 0;
            			if(money=="2k以下"){
            				m=2;
            			}else if(money=="2k-5k"){
            				m=5;
            			}else if(money=="5k-10k"){
            				m=10;
            			}else if(money=="10k-15k"){
            				m=15;
            			}else if(money=="15k-25k"){
            				m=25;
            			}else if(money=="25k-50k"){
            				m=50;
            			}else{
            				m=100;
            			} 
            			
            			$("form#expectForm1 input[name='hcity']").val($("form#expectForm1 input[name='hcityx']").val());
            			
            			$("form#expectForm1 input[name='hmoney']").val(m);
            			alert(m);
            			$("input[name='htype']").val(htype);

            			  mizhu.alert('提示', '信息完善成功','alert_blue');
//            			alert('1');
           			 $.ajax({  
    			            type: "POST", 
    			            url:"doAddUpdateHopeJon.controller",
    			            data:$('#expectForm1').serialize(),
    			            error: function(request) {  
    			                 alert("失败");  
    			            },  
    			            success: function(data) {
    			              
    			               mizhu.alert('提示', '信息完善成功','alert_blue');
    			               $("#jindutiao").text(parseInt($("#jindutiao").text())+15);
    			            }  
    			         });
            			
            			
            		}
            	</script>	
            	
<!-- -------------------------------------------------------------------工作经历----------------------------------------------------------------------------------------------  -->
<!-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------  -->
            	
            	
            	
            	
            	<div class="profile_box" id="workExperience">
            		<h2>工作经历  <span> （投递简历时必填）</span></h2>
            		            		<span class="c_add dn"></span>
            		<div class="experienceShow dn">
            		     
	            			<table>
	            				<tbody>
	            				<tr>
	            				    
							      	<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
							      	<td>
							      	<input type="hidden" name="cname" >
							        	<input type="text" placeholder="公司名称" name="companyName" class="companyName"  value="${queryAllCorporate.cname}">
							      	</td>
							      	<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
							      	<td>
							      	<input type="hidden" name="cposition" >
							          	<input type="text" placeholder="职位名称，如：产品经理" name="positionName" class="positionName" value="${queryAllCorporate.cposition}">
							      	</td>
							    </tr>
	            				<tr>
	            					<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
	            					<td>
		            					<div class="fl">
		            						<input type="hidden" class="companyYearStart" value="" name="companyYearStart">
								        	<input type="button" value="开始年份" class="profile_select_139 profile_select_normal select_companyYearStart">
											<div class="box_companyYearStart boxUpDown boxUpDown_139 dn" style="display: none;">
									            <ul>
									        											        			<li>2014</li>
									        											        			<li>2013</li>
									        											        			<li>2012</li>
									        											        			<li>2011</li>
									        											        			<li>2010</li>
									        											        			<li>2009</li>
									        											        			<li>2008</li>
									        											        			<li>2007</li>
									        											        			<li>2006</li>
									        											        			<li>2005</li>
									        											        			<li>2004</li>
									        											        			<li>2003</li>
									        											        			<li>2002</li>
									        											        			<li>2001</li>
									        											        			<li>2000</li>
									        											        			<li>1999</li>
									        											        			<li>1998</li>
									        											        			<li>1997</li>
									        											        			<li>1996</li>
									        											        			<li>1995</li>
									        											        			<li>1994</li>
									        											        			<li>1993</li>
									        											        			<li>1992</li>
									        											        			<li>1991</li>
									        											        			<li>1990</li>
									        											        			<li>1989</li>
									        											        			<li>1988</li>
									        											        			<li>1987</li>
									        											        			<li>1986</li>
									        											        			<li>1985</li>
									        											        			<li>1984</li>
									        											        			<li>1983</li>
									        											        			<li>1982</li>
									        											        			<li>1981</li>
									        											        			<li>1980</li>
									        											        			<li>1979</li>
									        											        			<li>1978</li>
									        											        			<li>1977</li>
									        											        			<li>1976</li>
									        											        			<li>1975</li>
									        											        			<li>1974</li>
									        											        			<li>1973</li>
									        											        			<li>1972</li>
									        											        			<li>1971</li>
									        											        			<li>1970</li>
									        											        	</ul>
									        </div>
										</div>
										<div class="fl">
									        <input type="hidden" class="companyMonthStart" value="" name="companyMonthStart">
								        	<input type="button" value="开始月份" class="profile_select_139 profile_select_normal select_companyMonthStart">
											<div style="display: none;" class="box_companyMonthStart boxUpDown boxUpDown_139 dn">
									            <ul>
									        		<li>01</li><li>02</li><li>03</li><li>04</li><li>05</li><li>06</li><li>07</li><li>08</li><li>09</li><li>10</li><li>11</li><li>12</li>
									        	</ul>
									        </div>
									    </div>
									    <div class="clear"></div>
	            					</td>
	            					<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
	            					<td>
		            					<div class="fl">
		            						<input type="hidden" class="companyYearEnd" value="" name="companyYearEnd">
								        	<input type="button" value="结束年份" class="profile_select_139 profile_select_normal select_companyYearEnd">
											<div class="box_companyYearEnd  boxUpDown boxUpDown_139 dn" style="display: none;">
									            <ul>
									            	<li>至今</li>
									        											        			<li>2014</li>
									        											        			<li>2013</li>
									        											        			<li>2012</li>
									        											        			<li>2011</li>
									        											        			<li>2010</li>
									        											        			<li>2009</li>
									        											        			<li>2008</li>
									        											        			<li>2007</li>
									        											        			<li>2006</li>
									        											        			<li>2005</li>
									        											        			<li>2004</li>
									        											        			<li>2003</li>
									        											        			<li>2002</li>
									        											        			<li>2001</li>
									        											        			<li>2000</li>
									        											        			<li>1999</li>
									        											        			<li>1998</li>
									        											        			<li>1997</li>
									        											        			<li>1996</li>
									        											        			<li>1995</li>
									        											        			<li>1994</li>
									        											        			<li>1993</li>
									        											        			<li>1992</li>
									        											        			<li>1991</li>
									        											        			<li>1990</li>
									        											        			<li>1989</li>
									        											        			<li>1988</li>
									        											        			<li>1987</li>
									        											        			<li>1986</li>
									        											        			<li>1985</li>
									        											        			<li>1984</li>
									        											        			<li>1983</li>
									        											        			<li>1982</li>
									        											        			<li>1981</li>
									        											        			<li>1980</li>
									        											        			<li>1979</li>
									        											        			<li>1978</li>
									        											        			<li>1977</li>
									        											        			<li>1976</li>
									        											        			<li>1975</li>
									        											        			<li>1974</li>
									        											        			<li>1973</li>
									        											        			<li>1972</li>
									        											        			<li>1971</li>
									        											        			<li>1970</li>
									        											        	</ul>
									        </div>
										</div>
										<div class="fl">
									        <input type="hidden" class="companyMonthEnd" value="" name="companyMonthEnd">
								        	<input type="button" value="结束月份" class="profile_select_139 profile_select_normal select_companyMonthEnd">
											<div style="display: none;" class="box_companyMonthEnd boxUpDown boxUpDown_139 dn">
									            <ul>
									        		<li>01</li><li>02</li><li>03</li><li>04</li><li>05</li><li>06</li><li>07</li><li>08</li><li>09</li><li>10</li><li>11</li><li>12</li>
									        	</ul>
									        </div>
								        </div>
								        <div class="clear"></div>
	            					</td>
	            				</tr>
	            				<tr>
	            					<td></td>
	            					<td colspan="3">
										<input type="submit" value="保 存" class="btn_profile_save">
						          		<a class="btn_profile_cancel" href="javascript:;">取 消</a>
	            					</td>
	            				</tr>
	            			</tbody></table>
	            			<input type="hidden" class="expId" value="">
            			</form><!--end .experienceForm-->
            			
            			<ul class="wlist clearfix">
            				            				            			</ul>
            		</div><!--end .experienceShow-->
            		<div class="experienceEdit dn">
            			<form id="expectForm2" onsubmit="false" method="post" action="">
	            			<table>
	            				
	            				<tr>
							      
							      	<td>
							      	<span>公司名称</span>
							        	<input type="text" placeholder="公司名称" name="companyName" value="${queryAllCorporate.cname}"  style="width:150px">
							          	
							      	</td>
							      
							      	<td>
							      	<span>职位名称，如：产品经理</span>
							          	<input type="text" placeholder="职位名称，如：产品经理" name="positionName" value="${queryAllCorporate.cposition}" style="width:150px">
							          
							      	</td>
							      	
							    </tr>
							    
	            				<%-- <tr>
	            					<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
	            					<td>
		            					<div class="fl">
		            						<input type="hidden" class="companyYearStart" value="" name="companyYearStart">
								        	<input type="button" value="开始年份" class="profile_select_139 profile_select_normal select_companyYearStart">
											<div class="box_companyYearStart boxUpDown boxUpDown_139 dn" style="display: none;">
									            <ul>
									        											        			<li>2014</li>
									        											        			<li>2013</li>
									        											        			<li>2012</li>
									        											        			<li>2011</li>
									        											        			<li>2010</li>
									        											        			<li>2009</li>
									        											        			<li>2008</li>
									        											        			<li>2007</li>
									        											        			<li>2006</li>
									        											        			<li>2005</li>
									        											        			<li>2004</li>
									        											        			<li>2003</li>
									        											        			<li>2002</li>
									        											        			<li>2001</li>
									        											        			<li>2000</li>
									        											        			<li>1999</li>
									        											        			<li>1998</li>
									        											        			<li>1997</li>
									        											        			<li>1996</li>
									        											        			<li>1995</li>
									        											        			<li>1994</li>
									        											        			<li>1993</li>
									        											        			<li>1992</li>
									        											        			<li>1991</li>
									        											        			<li>1990</li>
									        											        			<li>1989</li>
									        											        			<li>1988</li>
									        											        			<li>1987</li>
									        											        			<li>1986</li>
									        											        			<li>1985</li>
									        											        			<li>1984</li>
									        											        			<li>1983</li>
									        											        			<li>1982</li>
									        											        			<li>1981</li>
									        											        			<li>1980</li>
									        											        			<li>1979</li>
									        											        			<li>1978</li>
									        											        			<li>1977</li>
									        											        			<li>1976</li>
									        											        			<li>1975</li>
									        											        			<li>1974</li>
									        											        			<li>1973</li>
									        											        			<li>1972</li>
									        											        			<li>1971</li>
									        											        			<li>1970</li>
									        											        	</ul>
									        </div>
										</div>
										<div class="fl">
									        <input type="hidden" class="companyMonthStart" value="" name="companyMonthStart">
								        	<input type="button" value="开始月份" class="profile_select_139 profile_select_normal select_companyMonthStart">
											<div style="display: none;" class="box_companyMonthStart boxUpDown boxUpDown_139 dn">
									            <ul>
									        		<li>01</li><li>02</li><li>03</li><li>04</li><li>05</li><li>06</li><li>07</li><li>08</li><li>09</li><li>10</li><li>11</li><li>12</li>
									        	</ul>
									        </div>
									    </div>
									    <div class="clear"></div>
	            					</td>
	            					<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
	            					<td>
		            					<div class="fl">
		            						<input type="hidden" class="companyYearEnd" value="" name="companyYearEnd">
								        	<input type="button" value="结束年份" class="profile_select_139 profile_select_normal select_companyYearEnd">
											<div class="box_companyYearEnd  boxUpDown boxUpDown_139 dn" style="display: none;">
											
											<input type="date" name="pyearover" value="${queryAllCorporate.}" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:15px;margin-top:-40px;margin-left:152px">
									            <!-- <ul>
									            	<li>至今</li>
									        											        			<li>2014</li>
									        											        			<li>2013</li>
									        											        			<li>2012</li>
									        											        			<li>2011</li>
									        											        			<li>2010</li>
									        											        			<li>2009</li>
									        											        			<li>2008</li>
									        											        			<li>2007</li>
									        											        			<li>2006</li>
									        											        			<li>2005</li>
									        											        			<li>2004</li>
									        											        			<li>2003</li>
									        											        			<li>2002</li>
									        											        			<li>2001</li>
									        											        			<li>2000</li>
									        											        			<li>1999</li>
									        											        			<li>1998</li>
									        											        			<li>1997</li>
									        											        			<li>1996</li>
									        											        			<li>1995</li>
									        											        			<li>1994</li>
									        											        			<li>1993</li>
									        											        			<li>1992</li>
									        											        			<li>1991</li>
									        											        			<li>1990</li>
									        											        			<li>1989</li>
									        											        			<li>1988</li>
									        											        			<li>1987</li>
									        											        			<li>1986</li>
									        											        			<li>1985</li>
									        											        			<li>1984</li>
									        											        			<li>1983</li>
									        											        			<li>1982</li>
									        											        			<li>1981</li>
									        											        			<li>1980</li>
									        											        			<li>1979</li>
									        											        			<li>1978</li>
									        											        			<li>1977</li>
									        											        			<li>1976</li>
									        											        			<li>1975</li>
									        											        			<li>1974</li>
									        											        			<li>1973</li>
									        											        			<li>1972</li>
									        											        			<li>1971</li>
									        											        			<li>1970</li>
									        											        	</ul> -->
									        </div>
										</div>
										<div class="fl">
									        <input type="hidden" class="companyMonthEnd" value="" name="companyMonthEnd">
								        	<input type="button" value="结束月份" class="profile_select_139 profile_select_normal select_companyMonthEnd">
											<div style="display: none;" class="box_companyMonthEnd boxUpDown boxUpDown_139 dn">
									            <ul>
									        		<li>01</li><li>02</li><li>03</li><li>04</li><li>05</li><li>06</li><li>07</li><li>08</li><li>09</li><li>10</li><li>11</li><li>12</li>
									        	</ul>
									        </div>
								        </div>
								        <div class="clear"></div>
	            					</td>
	            				</tr> --%>
	            				<tr>
	            				 <td>
	            				 <span>开始时间</span>
	            				 	<input type="date" name="cyear" value="${queryAllCorporate.cyear }" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:15px;">
	            				 </td>
	            				 <td> 
	            				 <span>结束时间</span>
	            				    <input type="date" name="cyearover" value="${queryAllCorporate.cyearover }" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:15px;">
	            				 </td>
	            				</tr>
	            				
	            				<tr>
	            					<td colspan="3">
										<input type="button" value="保 存" onclick="workspaces()" class="btn_profile_save">
						          		<a class="btn_profile_cancel" href="javascript:;">取 消</a>
	            					</td>
	            				</tr>
	            				
	            			</table>
	            				<input type="hidden" name="cname" />
	            			   <input type="hidden" name="cposition" />
	            			<input type="hidden" class="expId" value="">
            			</form><!--end .experienceForm-->
            		</div><!--end .experienceEdit-->
            		
            		            		<div class="experienceAdd pAdd">
            		            			工作经历最能体现自己的工作能力，<br>
						且完善后才可投递简历哦！
						<span>添加工作经历</span>
            		</div><!--end .experienceAdd-->
            	</div><!--end #workExperience-->
            	
            	<script type="text/javascript">

                       $(function(){
                    	   
                                 
                           })
                           
                        function  workspaces(){
                    		   alert('1');
                    			
                        			var zhi = $("form#expectForm2 input[name='companyName']").val();
                        			
                        			var cposi = $("form#expectForm2 input[name='positionName']").val();
                        			$("form#expectForm2 input[name='cname']").val(zhi);
                        			$("form#expectForm2 input[name='cposition']").val(cposi);

                                 mizhu.alert('提示', '信息完善成功','alert_blue');
//                    			alert('1');
                   			 $.ajax({  
            			            type: "POST", 
            			            url:"doAddUpdateCorporate.controller",
            			            data:$('#expectForm2').serialize(),
            			            error: function(request) {  
            			                 alert("失败");  
            			            },  
            			            success: function(data) {
            			              
            			               mizhu.alert('提示', '信息完善成功!','alert_blue');
            			               $("#jindutiao").text(parseInt($("#jindutiao").text())+15);
            			            }  
            			         });
                                  




                                 
                        	   }



                	   
                           
            	</script>
            	
            	
            	
<!-- -------------------------------------------------------------------项目经验----------------------------------------------------------------------------------------------  -->
<!-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------  -->
          	
            	
            	
            	
            	
            	

            	<div class="profile_box" id="projectExperience">
            		<h2>项目经验</h2>
            		            		<span class="c_add dn"></span>
            		<div class="projectShow dn">
            		            			<ul class="plist clearfix">
	            			            			</ul>
            		</div><!--end .projectShow-->
            		<div class="projectEdit dn">
            		
            		
            		
            			<form id="expectForm3" onsubmit="false" >
	            			<table>
	            				<tr>
							      	<td>
							      	<input type="hidden" value="${queryAllProject.pid}">
							      	<input type="hidden" name="pname" >
							     <span>项目名称</span>
							        	<input type="text" placeholder="${queryAllProject.pname}" name="projectName" class="projectName" value="${queryAllProject.pname}"  style="width:150px">
							      	</td>
	            					
							      	<td>
							      	<input type="hidden" name="ppostition" >
							      	 <span>担任职务:</span>
							          	<input type="text" placeholder="${queryAllProject.ppostition}" name="thePost" class="thePost" value="${queryAllProject.ppostition}"  style="width:150px">
							      	</td>
							    </tr>
	            				<!-- <tr>
	            					<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
	            					<td>
		            					<div class="fl">
		            						<input type="hidden" class="projectYearStart" value="" name="projectYearStart">
								        	<input type="button" value="开始年份" class="profile_select_139 profile_select_normal select_projectYearStart">
											<div class="box_projectYearStart  boxUpDown boxUpDown_139 dn" style="display: none;">
									            <ul>
									        											        			<li>2014</li>
									        											        			<li>2013</li>
									        											        			<li>2012</li>
									        											        			<li>2011</li>
									        											        			<li>2010</li>
									        											        			<li>2009</li>
									        											        			<li>2008</li>
									        											        			<li>2007</li>
									        											        			<li>2006</li>
									        											        			<li>2005</li>
									        											        			<li>2004</li>
									        											        			<li>2003</li>
									        											        			<li>2002</li>
									        											        			<li>2001</li>
									        											        			<li>2000</li>
									        											        			<li>1999</li>
									        											        			<li>1998</li>
									        											        			<li>1997</li>
									        											        			<li>1996</li>
									        											        			<li>1995</li>
									        											        			<li>1994</li>
									        											        			<li>1993</li>
									        											        			<li>1992</li>
									        											        			<li>1991</li>
									        											        			<li>1990</li>
									        											        			<li>1989</li>
									        											        			<li>1988</li>
									        											        			<li>1987</li>
									        											        			<li>1986</li>
									        											        			<li>1985</li>
									        											        			<li>1984</li>
									        											        			<li>1983</li>
									        											        			<li>1982</li>
									        											        			<li>1981</li>
									        											        			<li>1980</li>
									        											        			<li>1979</li>
									        											        			<li>1978</li>
									        											        			<li>1977</li>
									        											        			<li>1976</li>
									        											        			<li>1975</li>
									        											        			<li>1974</li>
									        											        			<li>1973</li>
									        											        			<li>1972</li>
									        											        			<li>1971</li>
									        											        			<li>1970</li>
									        											        	</ul>
									        </div>
										</div>
										<div class="fl">
									        <input type="hidden" class="projectMonthStart" value="" name="projectMonthStart">
								        	<input type="button" value="开始月份" class="profile_select_139 profile_select_normal select_projectMonthStart">
											<div style="display: none;" class="box_projectMonthStart boxUpDown boxUpDown_139 dn">
									            <ul>
									        		<li>01</li><li>02</li><li>03</li><li>04</li><li>05</li><li>06</li><li>07</li><li>08</li><li>09</li><li>10</li><li>11</li><li>12</li>
									        	</ul>
									        </div>
								        </div>
								        <div class="clear"></div>
	            					</td>
	            					<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
	            					<td>
	            						<div class="fl">
		            						<input type="hidden" class="projectYearEnd" value="" name="projectYearEnd">
								        	<input type="button" value="结束年份" class="profile_select_139 profile_select_normal select_projectYearEnd">
											<div class="box_projectYearEnd  boxUpDown boxUpDown_139 dn" style="display: none;">
									            <ul>
									            	<li>至今</li>
									        											        			<li>2014</li>
									        											        			<li>2013</li>
									        											        			<li>2012</li>
									        											        			<li>2011</li>
									        											        			<li>2010</li>
									        											        			<li>2009</li>
									        											        			<li>2008</li>
									        											        			<li>2007</li>
									        											        			<li>2006</li>
									        											        			<li>2005</li>
									        											        			<li>2004</li>
									        											        			<li>2003</li>
									        											        			<li>2002</li>
									        											        			<li>2001</li>
									        											        			<li>2000</li>
									        											        			<li>1999</li>
									        											        			<li>1998</li>
									        											        			<li>1997</li>
									        											        			<li>1996</li>
									        											        			<li>1995</li>
									        											        			<li>1994</li>
									        											        			<li>1993</li>
									        											        			<li>1992</li>
									        											        			<li>1991</li>
									        											        			<li>1990</li>
									        											        			<li>1989</li>
									        											        			<li>1988</li>
									        											        			<li>1987</li>
									        											        			<li>1986</li>
									        											        			<li>1985</li>
									        											        			<li>1984</li>
									        											        			<li>1983</li>
									        											        			<li>1982</li>
									        											        			<li>1981</li>
									        											        			<li>1980</li>
									        											        			<li>1979</li>
									        											        			<li>1978</li>
									        											        			<li>1977</li>
									        											        			<li>1976</li>
									        											        			<li>1975</li>
									        											        			<li>1974</li>
									        											        			<li>1973</li>
									        											        			<li>1972</li>
									        											        			<li>1971</li>
									        											        			<li>1970</li>
									        											        	</ul>
									        </div>
										</div>
										<div class="fl">
									        <input type="hidden" class="projectMonthEnd" value="" name="projectMonthEnd">
								        	<input type="button" value="结束月份" class="profile_select_139 profile_select_normal select_projectMonthEnd">
											<div style="display: none;" class="box_projectMonthEnd boxUpDown boxUpDown_139 dn">
									            <ul>
									        		<li>01</li><li>02</li><li>03</li><li>04</li><li>05</li><li>06</li><li>07</li><li>08</li><li>09</li><li>10</li><li>11</li><li>12</li>
									        	</ul>
									        </div>
								        </div>
								        <div class="clear"></div>
	            					</td>
	            				</tr> -->
	            				
	            				<tr>
	            				 <td>
	            				 <span>开始时间</span>
	            				 	<input type="date" name="pyear" value="${queryAllProject.pyear }" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:15px;">
	            				 </td>
	            				 <td> 
	            				 <span>结束时间</span>
	            				    <input type="date" name="pyearover" value="${queryAllProject.pyearover}" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:15px;">
	            				 </td>
	            				</tr>
	            				
	            				
	            				<tr>
									<td colspan="3">
									<input type="hidden" name="pdescription"> 
										<textarea class="projectDescription s_textarea" name="projectDescription" placeholder="${queryAllProject.pdescribe}" value="${queryAllProject.pdescribe}"></textarea>
										<div class="word_count">你还可以输入 <span>500</span> 字</div>
									</td>
	            				</tr>
	            				<!-- <tr>
									<td colspan="2">
										<textarea placeholder="职责描述" name="ResponsDescription" class="ResponsDescription s_textarea"></textarea>
										<div class="word_count">你还可以输入 <span>500</span> 字</div>
									</td>
	            				</tr> -->
	            				<tr>
	            					<td valign="top"></td> 
	            					<td colspan="3">
										<input type="button" value="保 存"  onclick="workJY()" class="btn_profile_save">
						          		<a class="btn_profile_cancel" href="javascript:;">取 消</a>
	            					</td>
	            				</tr>
	            			</table>
	            			<input type="hidden" name="pname" />
	            			<input type="hidden" name="pposition" />
	            			
	            			
	            			
	            			
			            	<input type="hidden" value="" class="projectId">
            			</form><!--end .projectForm-->
            		</div><!--end .projectEdit-->
            		            		<div class="projectAdd pAdd">
            		            			项目经验是用人单位衡量人才能力的重要指标哦！<br>
						来说说让你难忘的项目吧！
						<span>添加项目经验</span>
            		</div><!--end .projectAdd-->
            	</div><!--end #projectExperience-->


               
               
               <script type="text/javascript">

                       $(function(){
                    	   
                                 
                           })
                           
                        function  workJY(){
                    		   alert('1');
                    			 
                        			var zhi = $("form#expectForm3 input[name='projectName']").val();
                        			
                        			var cposi = $("form#expectForm3 input[name='thePost']").val();

                        			var desc = $("form#expectForm3 textarea[name='projectDescription']").val();

                        			
                        			$("form#expectForm3 input[name='pname']").val(zhi);
                        			$("form#expectForm3 input[name='ppostition']").val(cposi);
                        			$("form#expectForm3 input[name='pdescription']").val(desc);
                    		   

                                 mizhu.alert('提示', '信息完善成功','alert_blue');
//                   			alert('1');
                  			 $.ajax({  
           			            type: "POST", 
           			            url:"doAddProject.controller",
           			            data:$('#expectForm3').serialize(),
           			            error: function(request) {  
           			                 alert("失败");  
           			            },  
           			            success: function(data) {
           			              
           			               mizhu.alert('提示', '信息完善成功!','alert_blue');
           			               $("#jindutiao").text(parseInt($("#jindutiao").text())+15);
           			            }  
           			         });
                                 
                        	   }
                           
            	</script>



<!-- -------------------------------------------------教育背景------------------------------------------------------------------- -->
<!-- -------------------------------------------------------------------------------------------------------------------- -->


          <!--  <script type="text/javascript">
		   $(function(){
			//alert("asdadsdasdasda");
			//mizhu.confirm("提示","确定要删除吗？");
			//mizhu.toast('已取消关注');
			//mizhu.toast('已取消关注', 6000);
			//mizhu.alert('提示', '不行');
			mizhu.alert('提示', '有图了','alert_green');
			
		   })
	     </script> -->
           


                 <script type="text/javascript">


                 function jiaoyu(){
 					
						/* 简历 */
         			  mizhu.alert('提示', '信息完善成功','alert_blue');
//              			alert('1');
             			 $.ajax({  
      			            type: "POST", 
      			            url:"doAddEb.controller",
      			            data:$('#jiaoyuform').serialize(),
      			            error: function(request) {  
      			                 alert("失败");  
      			            },  
      			            success: function(data) {
      			              
      			               mizhu.alert('提示', '信息完善成功','alert_blue');
      			               $("#jindutiao").text(parseInt($("#jindutiao").text())+15);
      			            }  
      			         });
         			   
						
 				}
                 </script>



















            	<div class="profile_box" id="educationalBackground">
            		<h2>教育背景<span>（投递简历时必填）</span></h2>
            							<span class="c_add dn"></span>
            		 <div class="educationalShow dn">
            		            			<!-- <form class="educationalForm borderBtm dn">
	            			<table>
	            				<tbody><tr>
							      	<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
							      	<td>
							        	<input type="text" placeholder="学校名称" name="schoolName" class="schoolName">
							      	</td>
							      	<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
							      	<td>
							      		<input type="hidden" class="degree" value="" name="degree">
							        	<input type="button" value="学历" class="profile_select_287 profile_select_normal select_degree">
										<div class="box_degree boxUpDown boxUpDown_287 dn" style="display: none;">
								            <ul>
								        										        			<li>大专</li>
								        										        			<li>本科</li>
								        										        			<li>硕士</li>
								        										        			<li>博士</li>
								        										        			<li>其他</li>
								        										        	</ul>
								        </div>
							        </td>
							    </tr>
	            				<tr>
	            					<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
	            					<td>
	            						<input type="text" placeholder="专业名称" name="professionalName" class="professionalName">
	            					</td>
	            					<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
	            					<td>
		            					<div class="fl">
		            						<input type="hidden" class="schoolYearStart" value="" name="schoolYearStart">
								        	<input type="button" value="开始年份" class="profile_select_139 profile_select_normal select_schoolYearStart">
											<div class="box_schoolYearStart boxUpDown boxUpDown_139 dn" style="display: none;">
									            <ul>
									        											        			<li>2014</li>
									        											        			<li>2013</li>
									        											        			<li>2012</li>
									        											        			<li>2011</li>
									        											        			<li>2010</li>
									        											        			<li>2009</li>
									        											        			<li>2008</li>
									        											        			<li>2007</li>
									        											        			<li>2006</li>
									        											        			<li>2005</li>
									        											        			<li>2004</li>
									        											        			<li>2003</li>
									        											        			<li>2002</li>
									        											        			<li>2001</li>
									        											        			<li>2000</li>
									        											        			<li>1999</li>
									        											        			<li>1998</li>
									        											        			<li>1997</li>
									        											        			<li>1996</li>
									        											        			<li>1995</li>
									        											        			<li>1994</li>
									        											        			<li>1993</li>
									        											        			<li>1992</li>
									        											        			<li>1991</li>
									        											        			<li>1990</li>
									        											        			<li>1989</li>
									        											        			<li>1988</li>
									        											        			<li>1987</li>
									        											        			<li>1986</li>
									        											        			<li>1985</li>
									        											        			<li>1984</li>
									        											        			<li>1983</li>
									        											        			<li>1982</li>
									        											        			<li>1981</li>
									        											        			<li>1980</li>
									        											        			<li>1979</li>
									        											        			<li>1978</li>
									        											        			<li>1977</li>
									        											        			<li>1976</li>
									        											        			<li>1975</li>
									        											        			<li>1974</li>
									        											        			<li>1973</li>
									        											        			<li>1972</li>
									        											        			<li>1971</li>
									        											        			<li>1970</li>
									        											        	</ul>
									        </div>
										</div>
										<div class="fl">
		            						<input type="hidden" class="schoolYearEnd" value="" name="schoolYearEnd">
								        	<input type="button" value="结束年份" class="profile_select_139 profile_select_normal select_schoolYearEnd">
											<div style="display: none;" class="box_schoolYearEnd  boxUpDown boxUpDown_139 dn">
									            <ul>
									        											        			<li>2021</li>
									        											        			<li>2020</li>
									        											        			<li>2019</li>
									        											        			<li>2018</li>
									        											        			<li>2017</li>
									        											        			<li>2016</li>
									        											        			<li>2015</li>
									        											        			<li>2014</li>
									        											        			<li>2013</li>
									        											        			<li>2012</li>
									        											        			<li>2011</li>
									        											        			<li>2010</li>
									        											        			<li>2009</li>
									        											        			<li>2008</li>
									        											        			<li>2007</li>
									        											        			<li>2006</li>
									        											        			<li>2005</li>
									        											        			<li>2004</li>
									        											        			<li>2003</li>
									        											        			<li>2002</li>
									        											        			<li>2001</li>
									        											        			<li>2000</li>
									        											        			<li>1999</li>
									        											        			<li>1998</li>
									        											        			<li>1997</li>
									        											        			<li>1996</li>
									        											        			<li>1995</li>
									        											        			<li>1994</li>
									        											        			<li>1993</li>
									        											        			<li>1992</li>
									        											        			<li>1991</li>
									        											        			<li>1990</li>
									        											        			<li>1989</li>
									        											        			<li>1988</li>
									        											        			<li>1987</li>
									        											        			<li>1986</li>
									        											        			<li>1985</li>
									        											        			<li>1984</li>
									        											        			<li>1983</li>
									        											        			<li>1982</li>
									        											        			<li>1981</li>
									        											        			<li>1980</li>
									        											        			<li>1979</li>
									        											        			<li>1978</li>
									        											        			<li>1977</li>
									        											        			<li>1976</li>
									        											        			<li>1975</li>
									        											        			<li>1974</li>
									        											        			<li>1973</li>
									        											        			<li>1972</li>
									        											        			<li>1971</li>
									        											        			<li>1970</li>
									        											        	</ul>
									        </div>
	            						</div>
	            						<div class="clear"></div>
	            					</td>
	            				</tr>
	            				<tr>
	            					<td></td>
	            					<td colspan="3">
										<input type="submit"  value="保 存" class="btn_profile_save">
						          		<a class="btn_profile_cancel" href="javascript:;">取 消</a>
	            					</td>
	            				</tr>
	            			</tbody></table>
	            			<input type="hidden" class="eduId" value="">
            			</form> --><!-- end .educationalForm -->
						
            			<ul class="elist clearfix">
            					            			            			</ul>
            		</div> <!--end .educationalShow-->
            		<div class="educationalEdit dn"><!-- class="educationalForm" -->
            			<form id="jiaoyuform"  onsubmit="false" >
	            			<table >
	            				<tbody><tr>
							      	<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
							      	<td>
							        	<input type="text" placeholder="${educationalbackground.ename }" value="${educationalbackground.ename }" style="width:150px;height:45px;margin-top:2px" name="ename" class="schoolName">
							      	</td>
							      	<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
							      	<td>
							      		<!-- <input type="hidden" class="degree" value="" name="degree"> -->
							        	<!-- <input type="button" value="学历" class="profile_select_287 profile_select_normal select_degree">
										<div class="box_degree boxUpDown boxUpDown_287 dn" style="display: none;">
								            <ul>
								        										        			<li>大专</li>
								        										        			<li>本科</li>
								        										        			<li>硕士</li>
								        										        			<li>博士</li>
								        										        			<li>其他</li>
								        										        	</ul>
								        </div> -->
								        <div>
						         	  
								  		<select name="emajor" style="width:302px;border:2px solid #EEE9E9;height:40px;font-size:15px">
								  			<option value="1">计算机应用</option>
								  			<option value="2">计算机网络</option>
								  			<option value="3">网站建设与网页设计</option>
								  			<option value="4">经济信息管理与计算机应用</option>
								  		</select> 
						         </div>
							        </td>
							    </tr>
	            				<tr>
	            					<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
	            					<td>
	            						<!-- <input type="text" placeholder="专业名称" style="width:150px;height:45px;margin-top:2px" name="emajor" class="professionalName"> -->
								  		<select name="eeducation" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:15px">
								  			<option value="1">大专</option>
								  			<option value="2">本科</option>
								  			<option value="3">硕士</option>
								  			<option value="4">博士</option>
								  			<option value="5">其他</option>
								  		</select> 
	            					</td>
	            					<td valign="top">
							        	<span class="redstar">*</span>
							      	</td> 
	            					<td>
		            					<!-- <div class="fl">
		            						<input type="hidden" class="schoolYearStart" value="" name="schoolYearStart">
		            						<div> -->
		            						<div>
		            						<input type="date" name="pyear" value="${educationalbackground.pyear }" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:15px">
						         	 <!--  <select name="pyear" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:18px">
								  			<option value="2014">2014</option>
								  			<option value="2013">2013</option>
								  			<option value="2012">2012</option>
								  			<option value="2011">2011</option>
								  			<option value="2010">2010</option>
								  			<option value="2009">2009</option>
								  			<option value="2008">2008</option>
								  			<option value="2007">2007</option>
								  			<option value="2006">2006</option>
								  			<option value="2005">2005</option>
								  			<option value="2004">2004</option>
								  			<option value="2003">2003</option>
								  			<option value="2002">2002</option>
								  			<option value="2001">2001</option>
								  			<option value="2000">2000</option>
								  			<option value="1999">1999</option>
								  			<option value="1998">1998</option>
								  			<option value="1997">1997</option>
								  			<option value="1996">1996</option>
								  			<option value="1995">1995</option>
								  			<option value="1994">1994</option>
								  			<option value="1993">1993</option>
								  			<option value="1992">1992</option>
								  			<option value="1991">1991</option>
								  			<option value="1990">1990</option>
								  			<option value="1989">1989</option>
								  			<option value="1988">1988</option>
								  			<option value="1987">1987</option>
								  			<option value="1986">1986</option>
								  			<option value="1985">1985</option>
								  			<option value="1984">1984</option>
								  			<option value="1983">1983</option>
								  			<option value="1982">1982</option>
								  			<option value="1981">1981</option>
								  			<option value="1980">1980</option>
								  			<option value="1979">1979</option>
								  			<option value="1978">1978</option>
								  			<option value="1977">1977</option>
								  			<option value="1976">1976</option>
								  			<option value="1975">1975</option>
								  			<option value="1974">1974</option>
								  			<option value="1973">1973</option>
								  			<option value="1972">1972</option>
								  			<option value="1971">1971</option>
								  		</select>            -->  
						         </div>
<!-- 								        	<input type="button" value="开始年份" class="profile_select_139 profile_select_normal select_schoolYearStart"> -->
<!-- 											<div class="box_schoolYearStart boxUpDown boxUpDown_139 dn" style="display: none;"> -->
<!-- 									            <ul> -->
<!-- 									        											        			<li>2014</li> -->
<!-- 									        											        			<li>2013</li> -->
<!-- 									        											        			<li>2012</li> -->
<!-- 									        											        			<li>2011</li> -->
<!-- 									        											        			<li>2010</li> -->
<!-- 									        											        			<li>2009</li> -->
<!-- 									        											        			<li>2008</li> -->
<!-- 									        											        			<li>2007</li> -->
<!-- 									        											        			<li>2006</li> -->
<!-- 									        											        			<li>2005</li> -->
<!-- 									        											        			<li>2004</li> -->
<!-- 									        											        			<li>2003</li> -->
<!-- 									        											        			<li>2002</li> -->
<!-- 									        											        			<li>2001</li> -->
<!-- 									        											        			<li>2000</li> -->
<!-- 									        											        			<li>1999</li> -->
<!-- 									        											        			<li>1998</li> -->
<!-- 									        											        			<li>1997</li> -->
<!-- 									        											        			<li>1996</li> -->
<!-- 									        											        			<li>1995</li> -->
<!-- 									        											        			<li>1994</li> -->
<!-- 									        											        			<li>1993</li> -->
<!-- 									        											        			<li>1992</li> -->
<!-- 									        											        			<li>1991</li> -->
<!-- 									        											        			<li>1990</li> -->
<!-- 									        											        			<li>1989</li> -->
<!-- 									        											        			<li>1988</li> -->
<!-- 									        											        			<li>1987</li> -->
<!-- 									        											        			<li>1986</li> -->
<!-- 									        											        			<li>1985</li> -->
<!-- 									        											        			<li>1984</li> -->
<!-- 									        											        			<li>1983</li> -->
<!-- 									        											        			<li>1982</li> -->
<!-- 									        											        			<li>1981</li> -->
<!-- 									        											        			<li>1980</li> -->
<!-- 									        											        			<li>1979</li> -->
<!-- 									        											        			<li>1978</li> -->
<!-- 									        											        			<li>1977</li> -->
<!-- 									        											        			<li>1976</li> -->
<!-- 									        											        			<li>1975</li> -->
<!-- 									        											        			<li>1974</li> -->
<!-- 									        											        			<li>1973</li> -->
<!-- 									        											        			<li>1972</li> -->
<!-- 									        											        			<li>1971</li> -->
<!-- 									        											        			<li>1970</li> -->
<!-- 									        											        	</ul> -->
<!-- 									        </div>
										</div> -->
										<div class="fl">
										<div>
										<input type="date" name=" " value="${educationalbackground.pyearover }" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:15px;margin-top:-40px;margin-left:152px">
						         	  <!-- <select name="pyearover" style="width:150px;border:2px solid #EEE9E9;height:40px;font-size:18px">
								  			<option value="2014">2014</option>
								  			<option value="2013">2013</option>
								  			<option value="2012">2012</option>
								  			<option value="2011">2011</option>
								  			<option value="2010">2010</option>
								  			<option value="2009">2009</option>
								  			<option value="2008">2008</option>
								  			<option value="2007">2007</option>
								  			<option value="2006">2006</option>
								  			<option value="2005">2005</option>
								  			<option value="2004">2004</option>
								  			<option value="2003">2003</option>
								  			<option value="2002">2002</option>
								  			<option value="2001">2001</option>
								  			<option value="2000">2000</option>
								  			<option value="1999">1999</option>
								  			<option value="1998">1998</option>
								  			<option value="1997">1997</option>
								  			<option value="1996">1996</option>
								  			<option value="1995">1995</option>
								  			<option value="1994">1994</option>
								  			<option value="1993">1993</option>
								  			<option value="1992">1992</option>
								  			<option value="1991">1991</option>
								  			<option value="1990">1990</option>
								  			<option value="1989">1989</option>
								  			<option value="1988">1988</option>
								  			<option value="1987">1987</option>
								  			<option value="1986">1986</option>
								  			<option value="1985">1985</option>
								  			<option value="1984">1984</option>
								  			<option value="1983">1983</option>
								  			<option value="1982">1982</option>
								  			<option value="1981">1981</option>
								  			<option value="1980">1980</option>
								  			<option value="1979">1979</option>
								  			<option value="1978">1978</option>
								  			<option value="1977">1977</option>
								  			<option value="1976">1976</option>
								  			<option value="1975">1975</option>
								  			<option value="1974">1974</option>
								  			<option value="1973">1973</option>
								  			<option value="1972">1972</option>
								  			<option value="1971">1971</option>
								  		</select>      -->        
						         </div>
		            						<!-- <input type="hidden" class="schoolYearEnd" value="" name="schoolYearEnd">
								        	<input type="button" value="结束年份" class="profile_select_139 profile_select_normal select_schoolYearEnd">
											<div class="box_schoolYearEnd  boxUpDown boxUpDown_139 dn" style="display: none;">
									            <ul>
									        											        			<li>2014</li>
									        											        			<li>2013</li>
									        											        			<li>2012</li>
									        											        			<li>2011</li>
									        											        			<li>2010</li>
									        											        			<li>2009</li>
									        											        			<li>2008</li>
									        											        			<li>2007</li>
									        											        			<li>2006</li>
									        											        			<li>2005</li>
									        											        			<li>2004</li>
									        											        			<li>2003</li>
									        											        			<li>2002</li>
									        											        			<li>2001</li>
									        											        			<li>2000</li>
									        											        			<li>1999</li>
									        											        			<li>1998</li>
									        											        			<li>1997</li>
									        											        			<li>1996</li>
									        											        			<li>1995</li>
									        											        			<li>1994</li>
									        											        			<li>1993</li>
									        											        			<li>1992</li>
									        											        			<li>1991</li>
									        											        			<li>1990</li>
									        											        			<li>1989</li>
									        											        			<li>1988</li>
									        											        			<li>1987</li>
									        											        			<li>1986</li>
									        											        			<li>1985</li>
									        											        			<li>1984</li>
									        											        			<li>1983</li>
									        											        			<li>1982</li>
									        											        			<li>1981</li>
									        											        			<li>1980</li>
									        											        			<li>1979</li>
									        											        			<li>1978</li>
									        											        			<li>1977</li>
									        											        			<li>1976</li>
									        											        			<li>1975</li>
									        											        			<li>1974</li>
									        											        			<li>1973</li>
									        											        			<li>1972</li>
									        											        			<li>1971</li>
									        											        			<li>1970</li>
									        											        	</ul>
									        </div>-->
	            						</div> 
	            						<div class="clear"></div>
	            					</td>
	            				</tr>
	            				<tr>
	            					<td></td>
	            					<td colspan="3">
										<input type="button" value="保 存" onclick="jiaoyu()" class="btn_profile_save" id="myform">
						          		<a class="btn_profile_cancel" href="javascript:;">取 消</a>
	            					</td>
	            				</tr>
	            			</tbody></table>
	            			<input type="hidden" class="eduId" value="">
            			</form><!-- end .educationalForm -->
            		</div><!--end .educationalEdit-->
            		            		<div class="educationalAdd pAdd">
            		            			教育背景可以充分体现你的学习和专业能力，<br>
						且完善后才可投递简历哦！
						<span>添加教育经历</span>
            		</div><!--end .educationalAdd-->
            	</div><!--end #educationalBackground-->
				<script type="text/javascript">
					/* 自我描述 */
					function zishu(){
					       mizhu.alert('提示', '信息完善成功','alert_blue');
//               			alert('1');
              			 $.ajax({  
       			            type: "POST", 
       			            url:"doAddSelfdescription.controller",
       			            data:$('#zishuform').serialize(),
       			            error: function(request) {  
       			                 alert("失败");  
       			            },  
       			            success: function(data) {
       			              
       			               mizhu.alert('提示', '信息完善成功!','alert_blue');
       			               $("#jindutiao").text(parseInt($("#jindutiao").text())+15);
       			            }  
       			         });
                   




						
						/* class="descriptionForm" */
					}
				</script>
            	<div class="profile_box" id="selfDescription">
            		<h2>自我描述</h2>
            		            		<span class="c_edit dn"></span>
            		<div class="descriptionShow dn">
            		            			
            		</div><!--end .descriptionShow-->
            		<div class="descriptionEdit dn">
            			<form  id="zishuform" onsubmit="false">
	            			<table>
	            				<tbody><tr>
									<td colspan="2">
										<textarea class="selfDescription s_textarea" style="width:600px;height:120px" name="sdescription" placeholder="${selfdescriptionModel }"></textarea>
										<div class="word_count">你还可以输入 <span>500</span> 字</div>
									</td>
	            				</tr>
	            				<tr>
	            					<td colspan="2">
										<input type="button" value="保 存" onclick="zishu()"  class="btn_profile_save">
						          		<a class="btn_profile_cancel" href="javascript:;">取 消</a>
	            					</td>
	            				</tr>
	            			</tbody></table>
            			</form><!--end .descriptionForm-->
            		</div><!--end .descriptionEdit-->
            		            		<div class="descriptionAdd pAdd">
            		            			描述你的性格、爱好以及吸引人的经历等，<br>
						让企业了解多元化的你！
						<span>添加自我描述</span>
            		</div><!--end .descriptionAdd-->
            	</div><!--end #selfDescription-->

            	<div class="profile_box" id="worksShow">
            		<h2>作品展示</h2>
            		            		<span class="c_add dn"></span>
            		<div class="workShow dn">
            		            			<ul class="slist clearfix">
            				            			</ul>
            		</div><!--end .workShow-->
            		<div class="workEdit dn">
            			<form id="zhanshiform" onsubmit="false">
	            			<table>
	            				<tbody><tr>
							      	<td>
							        	<input type="text" placeholder="${worksdisplayMapperModel.wlink }" name="wlink" value="${worksdisplayMapperModel.wlink }" style="width:540px;height:30px" class="workLink" name="zuoping">
							      	</td>
							    </tr>
	            				<tr>
									<td>
										<textarea maxlength="100" id="wexplai" class="workDescription s_textarea" name="wexplain" style="width:540px;height:120px"  placeholder="${worksdisplayMapperModel.wexplain }">${worksdisplayMapperModel.wexplain }</textarea>
										<div class="word_count">你还可以输入 <span>100</span> 字</div>
									</td>
	            				</tr>
	            				<tr>
	            					<td>
										<input type="button" value="保 存" onclick="zhanshi()" class="btn_profile_save">
						          		<a class="btn_profile_cancel" href="javascript:;">取 消</a>
	            					</td>
	            				</tr>
	            			</tbody></table>
	            			<input type="hidden" class="showId" value="">
            			</form><!--end .workForm-->
            		</div><!--end .workEdit-->
            		            		<div class="workAdd pAdd">
            		            			好作品会说话！<br>
						快来秀出你的作品打动企业吧！
						<span>添加作品展示</span>
            		</div><!--end .workAdd-->
            	</div><!--end #worksShow-->
				<input type="hidden" id="resumeId" value="268472">
            </div><!--end .content_l-->
            <div class="content_r">
            	<div class="mycenterR" id="myInfo">
            		<h2>我的信息</h2>
            		<a  href="doListCollectionp.controller">我收藏的职位</a>
            		<!-- target="_blank" -->
            		<br>
            		            		            		<a target="_blank" href="subscribe.html">我订阅的职位</a>
            	</div><!--end #myInfo-->

				<div class="mycenterR" id="myResume">
            		<h2>我的附件简历 
            			            			<a title="上传附件简历" href="#uploadFile" class="inline cboxElement">上传简历</a>
            			            		</h2>
            		<div class="resumeUploadDiv">
	            			            		暂无附件简历
	            		            		</div>
            	</div><!--end #myResume-->

            	<div class="mycenterR" id="resumeSet">
            		<h2>投递简历设置  <span>修改设置</span></h2>
            		<!-- -1 (0=附件， 1=在线， 其他=未设置) -->
            		            		            			<div class="noSet set0 dn">默认使用<span>附件简历</span>进行投递</div>
            			<div class="noSet set1 dn">默认使用<span>在线简历</span>进行投递</div>
						<div class="noSet">暂未设置默认投递简历</div>
            		            		<input type="hidden" class="defaultResume" value="-1">
            		<form class="dn" id="resumeSetForm">
	            		<label><input type="radio" value="1" class="resume1" name="resume">默认使用<span>在线简历</span>进行投递</label>
	            		<label><input type="radio" value="0" class="resume0" name="resume">默认使用<span>附件简历</span>进行投递</label>
	            		<span class="setTip error"></span>
	            		<div class="resumeTip">设置后投递简历时将不再提醒</div>
	            		<input type="submit" value="保 存" class="btn_profile_save">
						<a class="btn_profile_cancel" href="javascript:;">取 消</a>
	            	</form>
            	</div><!--end #resumeSet-->
				
				<div class="mycenterR" id="myShare">
            		<h2>当前每日投递量：10个</h2>
            		<a target="_blank" href="h/share/invite.html">邀请好友，提升投递量</a>
            	</div><!--end #myShare-->
            	
								
				<div class="greybg qrcode mt20">
                	<img width="242" height="242" alt="拉勾微信公众号二维码" src="style/images/qr_resume.png">
                    <span class="c7">微信扫一扫，轻松找工作</span>
                </div>
            </div><!--end .content_r-->
        </div>
        
      <input type="hidden" id="userid" name="userid" value="314873">

<!-------------------------------------弹窗lightbox ----------------------------------------->
<div style="display:none;">
	<!-- 上传简历 -->
	<div class="popup" id="uploadFile">
	    <table width="100%">
	    	<tbody><tr>
	        	<td align="center">
	                <form>
	                    <a class="btn_addPic" href="javascript:void(0);">
	                    	<span>选择上传文件</span>
	                        <input type="file" onchange="file_check(this,'h/nearBy/updateMyResume.json','resumeUpload')" class="filePrew" id="resumeUpload" name="newResume" size="3" title="支持word、pdf、ppt、txt、wps格式文件，大小不超过10M" tabindex="3">
	                    </a>
	                </form>
	            </td>
	        </tr>
	    	<tr>
	        	<td align="left">支持word、pdf、ppt、txt、wps格式文件<br>文件大小需小于10M</td>
	        </tr>
	        <tr>
	        	<td align="left" style="color:#dd4a38; padding-top:10px;">注：若从其它网站下载的word简历，请将文件另存为.docx格式后上传</td>
	        </tr>
	    	<tr>
	        	<td align="center"><img width="55" height="16" alt="loading" style="visibility: hidden;" id="loadingImg" src="style/images/loading.gif"></td>
	        </tr>
	    </tbody></table>
	</div><!--/#uploadFile-->
	
	<!-- 简历上传成功 -->
	<div class="popup" id="uploadFileSuccess">
     	<h4>简历上传成功！</h4>
         <table width="100%">
             <tbody><tr>
                 <td align="center"><p>你可以将简历投给你中意的公司了。</p></td>
             </tr>
         	<tr>
             	<td align="center"><a class="btn_s" href="javascript:;">确&nbsp;定</a></td>
             </tr>
         </tbody></table>
     </div><!--/#uploadFileSuccess-->
     
	<!-- 没有简历请上传 -->
    <div class="popup" id="deliverResumesNo">
        <table width="100%">
            <tbody><tr>
                <td align="center"><p class="font_16">你在拉勾还没有简历，请先上传一份</p></td>
            </tr>
        	<tr>
            	<td align="center">
                    <form>
                        <a class="btn_addPic" href="javascript:void(0);">
                        	<span>选择上传文件</span>
                        	<input type="file" onchange="file_check(this,'h/nearBy/updateMyResume.json','resumeUpload1')" class="filePrew" id="resumeUpload1" name="newResume" size="3" title="支持word、pdf、ppt、txt、wps格式文件，大小不超过10M">
                        </a>
                    </form>
                </td>
            </tr>
        	<tr>
            	<td align="center">支持word、pdf、ppt、txt、wps格式文件，大小不超过10M</td>
            </tr>
        </tbody></table>
    </div><!--/#deliverResumesNo-->
    
    <!-- 上传附件简历操作说明-重新上传 -->
    <div class="popup" id="fileResumeUpload">
        <table width="100%">
            <tbody><tr>
                <td>
                	<div class="f18 mb10">请上传标准格式的word简历</div>
                </td>
            </tr>
            <tr>
                <td>
                	<div class="f16">
                		操作说明：<br>
                		打开需要上传的文件 - 点击文件另存为 - 选择.docx - 保存
                	</div>
                </td>
            </tr>
        	<tr>
            	<td align="center">
            		<a title="上传附件简历" href="#uploadFile" class="inline btn cboxElement">重新上传</a>
            	</td>
            </tr>
        </tbody></table>
    </div><!--/#fileResumeUpload-->
    
    <!-- 上传附件简历操作说明-重新上传 -->
    <div class="popup" id="fileResumeUploadSize">
        <table width="100%">
            <tbody><tr>
                <td>
                	<div class="f18 mb10">上传文件大小超出限制</div>
                </td>
            </tr>
            <tr>
                <td>
                	<div class="f16">
                		提示：<br>
                		单个附件不能超过10M，请重新选择附件简历！
                	</div>
                </td>
            </tr>
        	<tr>
            	<td align="center">
            		<a title="上传附件简历" href="#uploadFile" class="inline btn cboxElement">重新上传</a>
            	</td>
            </tr>
        </tbody></table>
    </div><!--/#deliverResumeConfirm-->
    
</div>
<!------------------------------------- end ----------------------------------------->  

<script src="style/js/Chart.min.js" type="text/javascript"></script>
<script src="style/js/profile.min.js" type="text/javascript"></script>
<!-- <div id="profileOverlay"></div> -->
<div class="" id="qr_cloud_resume" style="display: none;">
	<div class="cloud">
		<img width="134" height="134" src="">
		<a class="close" href="javascript:;"></a>
	</div>
</div>
<script>
$(function(){
	$.ajax({
        url:ctx+"/mycenter/showQRCode",
        type:"GET",
        async:false
   	}).done(function(data){
        if(data.success){
             $('#qr_cloud_resume img').attr("src",data.content);
        }
   	}); 
	var sessionId = "resumeQR"+314873;
	if(!$.cookie(sessionId)){
		$.cookie(sessionId, 0, {expires: 1});
	}
	if($.cookie(sessionId) && $.cookie(sessionId) != 5){
		$('#qr_cloud_resume').removeClass('dn');
	}
	$('#qr_cloud_resume .close').click(function(){
		$('#qr_cloud_resume').fadeOut(200);
		resumeQR = parseInt($.cookie(sessionId)) + 1;
		$.cookie(sessionId, resumeQR, {expires: 1});
	});
});

</script>
			<div class="clear"></div>
			<input type="hidden" value="97fd449bcb294153a671f8fe6f4ba655" id="resubmitToken">
	    	<a rel="nofollow" title="回到顶部" id="backtop" style="display: none;"></a>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<a rel="nofollow" target="_blank" href="h/about.html">联系我们</a>
		    <a target="_blank" href="h/af/zhaopin.html">互联网公司导航</a>
		    <a rel="nofollow" target="_blank" href="http://e.weibo.com/lagou720">拉勾微博</a>
		    <a rel="nofollow" href="javascript:void(0)" class="footer_qr">拉勾微信<i></i></a>
			<div class="copyright">&copy;2013-2014 Lagou <a href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">京ICP备14023790号-2</a></div>
		</div>
	</div>

<script src="style/js/core.min.js" type="text/javascript"></script>
<script src="style/js/popup.min.js" type="text/javascript"></script>

<!--  -->

<script type="text/javascript">
/* function jianli(){
	alert("asdasd");
	//action="doUpdateResumename.controller" method="post"
	$("form#kkkkkkk").submit();
} */

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
