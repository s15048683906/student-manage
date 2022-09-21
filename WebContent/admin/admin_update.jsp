<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link rel="stylesheet" type="text/css" href="css/edittable.css"  ></link>  
		<link rel="stylesheet" type="text/css" href="css/validate.css"  ></link>  
		<script type="text/javascript"  src="js/jquery-1.8.0.js"></script>

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
		 <div class="div_titlename"> <img src="images/san_jiao.gif" ><span>管理员修改</span></div>
	 </div>
				 
	 <form action="Adminservlet" method="post" >
	 	 <input name="flag" value="update" type="hidden" >
	 	 <input name="id" value="${admin.id }" type="hidden" >
		 <table class="edit_table" >
		 		<tr>
		 			 	<td class="td_info">用户账号:</td>	
		 			 	<td class="td_input_short"> 
		 			 		<input type="text" class="txtbox" id="adminName" name="adminName" value="${admin.adminName }"/> 
		 			 	</td>   
		 			 	<td>
		 			 		<label class="validate_info" id="adminName_msg">4-15位；只限数字(0-9)和英文(a-z),不区分大小写</label>
		 			 	</td> 
		 		</tr>
		 			<tr>
		 				<td class="td_info">用户密码:</td>	
		 				<td>
		 					<input type="text"  class="txtbox"  name="password"  id="password" value="${admin.password }"/>
		 				</td> 
		 				<td><label  class="validate_info" id="password_msg" >数字或英文,6-20位</label></td>	
		 		</tr>
		 			<tr>
		 				<td class="td_info">重复密码:</td>	
		 				<td><input type="text" class="txtbox" id="pwdconfirm" value="${admin.password }" /> 
		 				</td>
		 				<td><label  class="validate_info"  id="pwdconfirm_msg">请重复输入密码</label></td>	
		 		</tr>
		 		<tr>
		 			<td class="td_info">备注信息:</td>	
		 			<td><textarea rows="4" cols="27" name="note" class="txtarea">${admin.note }</textarea> </td>	
		 			<td><label></label></td>	
		 		</tr>
		 		<tr>
		 			<td class="td_info"> </td>	
		 			<td> 
		 			<input class="form_btn" type="submit" onclick="return confirm('确定提交吗')" value="提交" /> 
		 			<input type="reset"  class="form_btn" value="重置" /> </td>	
		 			<td>
		 				<label id="result_msg" class="result_msg"></label>
		 			</td>	
		 		</tr>
		</table>
		
		
     </form>
     
       <script>
 	   	 var str="${msg }";
 	   	 if(str!=""){
 	   		 alert(str);
 	   	 }
 	   </script>
  </body>
</html>
