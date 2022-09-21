<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	
	<script type="text/javascript" src="js/jquery-1.8.0.js"></script> 
	<script type="text/javascript">
		$(function(){
			$("#ch_checkall,#top_ch_checkall").click(function(){
				if(this.checked){
					$("input[name=ck_id]").attr("checked","checked");
				}else{
					$("input[name=ck_id]").removeAttr("checked");
				}		
			});
					
			$("table tr").mouseover(function(){
				$(this).css("background","#D3EAEF");
				$(this).siblings().css("background","white");
			});
		});
	</script>

	<link rel="stylesheet" type="text/css" href="css/maintable.css" ></link>  
	<link rel="stylesheet" type="text/css" href="css/edittable.css"  ></link>    

  </head>
  
  <body>
	<div class ="div_title">
						<div class="div_titlename"> <img src="images/san_jiao.gif" ><span>角色： ${role.roleName }</span></div>
    </div>   
	<form action="RoleServlet" method="post">
	    <input type="hidden" name="flag" value="updateRoleMenu">
	    <input type="hidden" name="roleId" value="${role.id }">
	    
	    <table class="main_table">
	    
	       <tr>
	       		<th>一级菜单</th>
	       		<th>二级菜单</th>
	       </tr>
	       
	       <c:forEach var="menu" items="${menuList }">
	       		<tr>
		       		<td>
		       			<input type="checkbox" name="menuIds" value="${menu.id }">${menu.menuName }_${menu.id }
		       		</td>
		       		<td>
		       			<c:forEach var="m_sub" items="${menu.subMenuList }">
		       				<input type="checkbox" name="menuIds" value="${m_sub.id }">${m_sub.menuName }_${m_sub.id }<br />
		       			</c:forEach>
		       		</td>
	            </tr>
	       </c:forEach>
	       
	    </table>
	    <input class="form_btn" type="submit" value="提交" onclick="return confirm('确定提交吗')">
	    
	</form>
	
	${msg }
	
  </body>
</html>
