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
<form action="index.html" method="post" class="definewidth m20">
<table class="table table-bordered table-hover m10">
    <tr>
        <!-- <td width="10%" class="tableleft">上级</td>
        <td>
            <select name="parentid">
            <option value="0">一级菜单</option><option value='1'   />&nbsp;系统管理</option><option value='7'   />&nbsp;明信片管理</option>            </select>
        </td> -->
    </tr>
    <tr>
        <td class="tableleft">职位名称</td>
        <td><input type="text" name="name"/></td>
    </tr>
    <tr>
        <td class="tableleft">公司名称</td>
        <td><input type="text" name="group"/></td>
    </tr>
    <tr>
        <td class="tableleft">工作地点</td>
        <td><input type="text" name="module"/></td>
    </tr>
    <tr>
        <td class="tableleft">月薪</td>
        <td><input type="text" name="action"/></td>
    </tr>
    <tr>
        <td class="tableleft">经验</td>
        <td><input type="text" name="remark"/></td>
    </tr>
    <tr>
        <td class="tableleft">最低学历</td>
        <td><input type="text" name="remark"/></td>
    </tr>
    <tr>
        <td class="tableleft">职位诱惑</td>
        <td><input type="text" name="remark"/></td>
    </tr>
    <tr>
        <td class="tableleft">发布时间</td>
        <td><input type="text" name="remark"/></td>
    </tr>
    <tr>
        <td class="tableleft">公司名称</td>
        <td><input type="text" name="remark"/></td>
    </tr>
    <tr>
        <td class="tableleft">领域</td>
        <td><input type="text" name="remark"/></td>
    </tr>
    <tr>
        <td class="tableleft">创始人</td>
        <td><input type="text" name="remark"/></td>
    </tr>
    <tr>
        <td class="tableleft">阶段</td>
        <td><input type="text" name="remark"/></td>
    </tr>
    <tr>
        <td class="tableleft">规模</td>
        <td><input type="text" name="remark"/></td>
    </tr>
     <tr>
        <td class="tableleft">待遇</td>
        <td><input type="text" name="remark"/></td>
    </tr>
    <!-- <tr>
        <td class="tableleft">创始人</td>
        <td>
            <input type="radio" name="status" value="0" checked/> 启用
            <input type="radio" name="status" value="1"/> 禁用
        </td>
    </tr> -->
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
				window.location.href="toMenuIndex.controller";
		 });

    });
</script>
