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
<form action="doUpdateUser.controller" method="post" class="definewidth m20" >
<input type="hidden" name="userid" value="${recuitUser.userid }" />

<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">用户名</td>
        <td><input type="text" name="username" value="${recuitUser.username}"/></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">身份证号</td>
        <td><input type="text" name="identity" value="${recuitUser.identity}"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td>
        <input type="radio" name="gender" value="2"   <c:if test="${recuitUser.gender eq '2'}">checked="checked"</c:if> />男
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        <input type="radio" name="gender" value="1"   <c:if test="${recuitUser.gender eq '1'}">checked="checked"</c:if> />女
       </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">邮箱</td>
        <td><input type="text" name="email" value="${recuitUser.email}"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">电话</td>
        <td><input type="text" name="telephone" value="${recuitUser.telephone}"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">学历</td>
        <td>
       <%--  <c:if test="${list.education eq '1'}">大专</c:if>
            <c:if test="${list.education eq '2'}">本科</c:if>
            <c:if test="${list.education eq '3'}">硕士</c:if>
            <c:if test="${list.education eq '4'}">博士</c:if>
            <c:if test="${list.education eq '5'}">其他</c:if> --%>
        <select  name="education" value="${list.education}">
             <option value="1"><c:if test="${list.education eq '1'}">selected</c:if>大专</option>
              <option value="2"><c:if test="${list.education eq '2'}">selected</c:if>本科</option>
               <option value="3"><c:if test="${list.education eq '3'}">selected</c:if>硕士</option>
        []        <option value="4"><c:if test="${list.education eq '4'}">selected</c:if>博士</option>
                 <option value="5"><c:if test="${list.education eq '5'}">selected</c:if>其他</option>
        </select> 
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">工作经验</td>
  <%--       <c:if test="${!empty list.userlog }">
        <c:if test="${list.userlog eq '1'}">应届毕业生</c:if>
        <c:if test="${list.userlog eq '2'}">1年</c:if>
        <c:if test="${list.userlog eq '3'}">2年</c:if>
        <c:if test="${list.userlog eq '4'}">3年</c:if>
        <c:if test="${list.userlog eq '5'}">4年</c:if>
        <c:if test="${list.userlog eq '6'}">5年</c:if>
        <c:if test="${list.userlog eq '7'}">6年</c:if>
        <c:if test="${list.userlog eq '8'}">7年</c:if>
        <c:if test="${list.userlog eq '9'}">8年</c:if>
        <c:if test="${list.userlog eq '10'}">9年</c:if>
        <c:if test="${list.userlog eq '11'}">10年</c:if>
        <c:if test="${list.userlog eq '12'}">10年以上</c:if>
        <br></c:if> --%>
        <td>
        <select name="userlog">
         <option value="1"<c:if test="${list.userlog eq '1'}">selected="selected"</c:if>>应届毕业生</option>
              <option value="2"<c:if test="${list.userlog eq '2'}">selected="selected"</c:if>>1年</option>
               <option value="3"<c:if test="${list.userlog eq '3'}">selected="selected"</c:if>>2年</option>
                <option value="4"<c:if test="${list.userlog eq '4'}">selected="selected"</c:if>>3年</option>
                 <option value="5"<c:if test="${list.userlog eq '5'}">selected="selected"</c:if>>4年</option>
                  <option value="6"<c:if test="${list.userlog eq '6'}">selected="selected"</c:if>>5年</option>
              <option value="7"<c:if test="${list.userlog eq '7'}">selected="selected"</c:if>>6年</option>
               <option value="8"<c:if test="${list.userlog eq '8'}">selected="selected"</c:if>>7年</option>
                <option value="9"<c:if test="${list.userlog eq '9'}">selected="selected"</c:if>>8年</option>
                 <option value="10"<c:if test="${list.userlog eq '10'}">selected="selected"</c:if>>9年</option>
                  <option value="11"<c:if test="${list.userlog eq '11'}">selected="selected"</c:if>>10年</option>
              <option value="12"<c:if test="${list.userlog eq '12'}">selected="selected"</c:if>>10年以上</option>
               
        </select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">求职状态</td>
        <td><input type="text" name="currentstate" value="${recuitUser.currentstate}"/></td>
    </tr>
    
    <!-- <tr>
        <td class="tableleft">身份证号</td>
        <td>
            <input type="radio" name="status" value="1" checked /> 启用
           <input type="radio" name="status" value="0"  /> 禁用
        </td>
    </tr> -->
   <!--  <tr>
        <td class="tableleft">权限</td>
        <td>
        <ul>
        <li>
        <label class='checkbox inline'>
        <input type='checkbox' name='group[]' value='' />公用节点</label>
        <ul>
        <li>
        <label class='checkbox inline'>
        <input type='checkbox' name='node[]' value='21' checked/>省市区级联数据</label>
        <li>
        <label class='checkbox inline'>
        <input type='checkbox' name='node[]' value='22' checked/>省市区数据获取</label>
        </ul></li><li><label class='checkbox inline'><input type='checkbox' name='group[]' value='' />明信片批次管理</label><ul><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='25' checked/>明信片批次管理</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='26' checked/>明信片批次添加</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='27' checked/>明信片批次编辑</label></ul></li><li><label class='checkbox inline'><input type='checkbox' name='group[]' value='' />标签管理</label><ul><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='17' checked/>标签查询</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='18' checked/>标签生成</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='19' checked/>批量贴标签</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='20' checked/>标签编辑</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='23' checked/>标签生成下载（请和标签生成同时选中）</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='24' checked/>文件下载（请和标签生成、查询同时选中）</label></ul></li><li><label class='checkbox inline'><input type='checkbox' name='group[]' value='' />权限</label><ul><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='1' checked/>权限列表</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='2' checked/>权限添加</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='3' checked/>权限编辑</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='4' checked/>权限删除</label></ul></li><li><label class='checkbox inline'><input type='checkbox' name='group[]' value='' />用户</label><ul><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='9' checked/>用户列表</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='10' checked/>用户添加</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='11' checked/>用户编辑</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='12' checked/>用户删除</label></ul></li><li><label class='checkbox inline'><input type='checkbox' name='group[]' value='' />菜单管理</label><ul><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='13' checked/>菜单列表</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='14' checked/>菜单新增</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='15' checked/>菜单编辑</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='16' checked/>菜单删除</label></ul></li><li><label class='checkbox inline'><input type='checkbox' name='group[]' value='' />角色</label><ul><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='5' checked/>角色列表</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='6' checked/>角色添加</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='7' checked/>角色编辑</label><li><label class='checkbox inline'><input type='checkbox' name='node[]' value='8' checked/>角色删除</label></ul></li></ul></td>
    </tr> -->
    <tr>
        <td class="tableleft"></td>
        <td>
            <input type="submit"  class="btn btn-primary" value="保存">&nbsp;&nbsp;
            <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>

<script type="text/javascript" src="${pageContext.request.contextPath }/webjars/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript">

$(function () {       
	$('#backid').click(function(){
			/* window.location.href="{:U('User/index')}"; */
			history.go(-1);
	 });

});
</script>

<!-- <script>
    $(function () {
        $(':checkbox[name="group[]"]').click(function () {
            $(':checkbox', $(this).closest('li')).prop('checked', this.checked);
        });

		$('#backid').click(function(){
				window.location.href="toRoleIndex.controller";
		 });

    });
</script> -->


</form>
</body>
</html>
