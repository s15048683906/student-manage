<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<title>用户角色管理</title>   
	<link rel="stylesheet" type="text/css" href="css/edittable.css"  ></link>  
	<link rel="stylesheet" type="text/css" href="css/validate.css"  ></link>  

	<script type="text/javascript"  src="js/jquery-1.8.0.js"></script>
	<script type="text/javascript"  src="js/validate.js"></script>
			<script>		
				$(function(){
					 $("input[type=text],textarea").focus(function(){
						  $(this).addClass("input_focus");
						}).blur(function(){
								$(this).removeClass("input_focus");
						});
	
					$(".form_btn").hover(function(){
							$(this).css("color","red").css("background","#6FB2DB");
						},
						
						function(){
							$(this).css("color","#295568").css("background","#BAD9E3");
						});
					
				});			
			
	  	</script>

  </head>
  
  <body>
     <div class ="div_title">
		 <div class="div_titlename"> <img src="images/san_jiao.gif" ><span>角色添加</span></div>
	 </div>
				 
	 <form action="RoleServlet" method="post">
	    
	    <input type="hidden" name="flag" value="updateAdminRole">
	    <input type="hidden" name="adminId" value="${admin.id }">

		 <table class="edit_table" >
		 
		 		<tr>
		 			 	<td class="td_info">用户账号:  </td>	
		 			 	<td class="td_input_short"> 
		 			 		<input type="text" class="txtbox" id="adminName" name="adminName"  readonly="readonly" value="${admin.adminName }"/> 
		 			 	</td>   
		 			 	<td>
		 			 		<label class="validate_info"></label>
		 			 	</td> 
		 		<tr>
		 		
		 			<td class="td_info">用户角色:</td>	
		 			<td>
		 				<c:forEach var="role" items="${roleList }">
			 				<input type="radio" name="roleId" value="${role.id }"
			 				<c:if test="${admin.roleId==role.id }">
			 					checked="checked"
			 				</c:if>
			 				>${role.roleName }_${role.id }<br />
			 			</c:forEach>
		 			</td>	
		 			<td></td>	
		 		</tr>
		 		<tr>
		 		   <td class="td_info"> </td>	

		 			<td> 
		 			<input class="form_btn" type="submit" value="提交" onclick="confirm('确定提交吗')"/> 
		 			<button id="btnReset" class="form_btn"  >返回 </button></td>	
		 			<td>
		 				<label id="result_msg" class="result_msg"></label>
		 			</td>	
		 		</tr>
		</table>
	    
	</form>
	
	${msg }
  </body>
</html>
