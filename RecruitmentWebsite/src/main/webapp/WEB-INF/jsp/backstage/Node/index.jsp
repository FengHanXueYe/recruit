<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    机构名称：
    <input type="text" name="rolename" id="rolename"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增机构</button>
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>公司编号</th>
        <th>公司名称</th>
        <th>公司介绍</th>
        <th>管理操作</th>
    </tr>
    </thead>
    <c:forEach items="${listCompany}" var="company" >
	     <tr>
            <td>${company.cid}</td>
            <td>${company.cname}</td>
            <td>${company.companyProfile}</td>
            <td>
                  
                  <a href="">编辑</a>                
                  <a href="">禁用</a>
                  <a href="">删除</a>
            </td>
        </tr>
        </c:forEach>
        </table>
<div class="inline pull-right page">
         10122 条记录 1/507 页  <a href='#'>下一页</a>     <span class='current'>1</span><a href='#'>2</a><a href='/chinapost/index.php?m=Label&a=index&p=3'>3</a><a href='#'>4</a><a href='#'>5</a>  <a href='#' >下5页</a> <a href='#' >最后一页</a>    </div>
</body>
</html>
<script>
    $(function () {
        
		$('#addnew').click(function(){

				window.location.href="toNodeAdd.controller";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "toNodeIndex.controller";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
