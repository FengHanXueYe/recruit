<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    ﻿<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<form class="form-inline definewidth m20" action="toMenuIndex.controller" method="post" id="searchForm">
    职位名称：
    <input type="text" name="oname" id="menuname"class="abc input-default" placeholder="输入查询条件" value="">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary"  >查询</button>&nbsp;&nbsp; 
    
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>职位ID</th>
        <th>公司名称</th>
        <th>职位名称</th>
        <th>月薪</th>
        <th>经验</th>
        <th>最低学历</th>
        <th>职位诱惑</th>
        <th>发布时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${zhiwei}"  var="item">
	    <c:forEach items="${item.occupation}" var="item2">
        <tr  class="del${item2.oid }">
                <td>${item2.oid}</td>
                <td>${item.cname}</td>
                <td>${item2.oname}</td>
                <td><fmt:formatNumber
value="${item2.omaxsalary}" pattern="#.0k"></fmt:formatNumber>--<fmt:formatNumber
value="${item2.ominsalary}" pattern="#.0k"></fmt:formatNumber></span></td>
                <td>${item2.olog}</td>
                
                 
                 <c:forEach items="${item2.education}" var="oooname">
										 <td>${oooname.ename}</td>
									</c:forEach>
                  <td>${item2.owelfare}</td>
                   <td>
<fmt:formatDate
											value="${item2.orelease}" pattern="yyyy-MM-dd" /></span>
</td>
                <td><a href="toDetailOcc.controller?oid=${item2.oid}">查看详情</a>&nbsp;&nbsp;<a href="#">强制下线</a>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteOcc(${item2.oid})">删除</a></td>
            </tr>
            </c:forEach>
      </c:forEach>
            
            
            
            <!-- <tr>
                <td>权限管理</td>
                <td>Admin</td>
                <td>Node</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>角色管理</td>
                <td>Admin</td>
                <td>Role</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>用户管理</td>
                <td>Admin</td>
                <td>User</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>菜单管理</td>
                <td>Admin</td>
                <td>Menu</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
            <td colspan="5">明信片管理</td>
            <td><a href="edit.html">编辑</a></td>
        </tr>
        <tr>
                <td>批次管理</td>
                <td>Admin</td>
                <td>LabelSet</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>明信片查询</td>
                <td>Admin</td>
                <td>Label</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>明信片生成</td>
                <td>Admin</td>
                <td>Label</td>
                <td>apply</td>
                <td>1</td>
                <td><a href="edit.html">编辑</a></td>
            </tr></table> -->
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="toMenuAdd.controller";
		 });
		
		


    });
    function deleteOcc(oid){
		var flg = confirm("确定要删除吗？");
		if(flg){
			$.post("ajaxDeleteOcc.controller","oid="+oid,function(data){
				if(data){
					$(".del"+oid).remove();
				}
			}) 
		}
	}
    
    
	/* function search() {

		var oname = $("input[name='oname']").val();
		$("#searchForm").attr("action","toMenuIndex.controller");
		var zhi = ("#searchForm").attr("action");
		alert(zhi);
		$("#searchForm").submit()

	} */


	
</script>
</body>
</html>

