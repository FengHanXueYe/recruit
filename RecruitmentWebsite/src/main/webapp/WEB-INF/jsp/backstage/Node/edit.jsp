<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="doUpdateCompany.controller" method="post" class="definewidth m20">
<input type="hidden" name="id" value="" />
<table class="table table-bordered table-hover ">
    <tr>
        <td width="10%" class="tableleft">公司编号</td>
        <td>${company.cid}<input type="hidden" name="cid" value="${company.cid}"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">公司名称</td>
        <td><input type="text" name="cname" value="${company.cname}"/></td>
    </tr>
     <tr>
        <td class="tableleft">公司简称</td>
        <td ><input type="text" name="cabbreviation" value="${company.cabbreviation}"/></td>
    </tr>    
    <tr>
        <td class="tableleft">公司地址</td>
        <td ><input type="text" name="caddress" value="${company.caddress}"/></td>
    </tr>
    <tr>
        <td class="tableleft">公司电话</td>
        <td ><input type="text" name="cphone" value="${company.cphone}"/></td>
    </tr>
    <tr>
        <td class="tableleft">公司网址</td>
        <td ><input type="text" name="curl" value="${company.curl}"/></td>
    </tr>
     <tr>
        <td class="tableleft">公司简述</td>
        <td ><input type="text" name="cdetail" value="${company.cdetail}"/></td>
    </tr> 
    <tr>
        <td class="tableleft">接收简历的邮箱</td>
        <td ><input type="text" name="cemail" value="${company.cemail}"/></td>
    </tr>
     <tr>
        <td class="tableleft">公司介紹</td>
        <td ><input type="text" name="companyProfile" value="${company.companyProfile}"/></td>
    </tr>
    <tr>
        <td class="tableleft">状态</td>
        <td >
            <input type="radio" name="status" value="1" checked/> 启用
           <input type="radio" name="status" value="0" /> 禁用
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="toNodeIndex.controller";
		 });

    });
</script>
