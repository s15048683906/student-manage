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
		 <div class="div_titlename"> <img src="images/san_jiao.gif" ><span>学生信息修改</span></div>
	 </div>
				 
	 <form action="StudentServlet" method="post" >
	 	 <input name="flag" value="update" type="hidden" >
	 	 <input name="id" value="${student.id }" type="hidden" >
		 <table class="edit_table" >
		 		<tr>
		 			 	<td class="td_info">学号：</td>	
		 			 	<td class="td_input_short"> 
		 			 		<input type="text" class="txtbox" id="id" name="id" value="${param.id }"/> 
		 			 	</td>   
		 			 	<td>
		 			 		<label class="validate_info" id="studentName_msg">数字</label>
		 			 	</td> 
		 		</tr>
		 		<tr>
			 			<td class="td_info">密码：</td>	
			 			<td>
			 				<input type="text" class="txtbox" id="password" name="password" value="${student.password }"/> 
			 			</td>	
			 			<td>
			 				<label class="validate_info" id="studentName_msg">不能为空</label>
			 			</td>	
		 		</tr>
		 		<tr>
		 			 	<td class="td_info">姓名：</td>	
		 			 	<td class="td_input_short"> 
		 			 		<input type="text" class="txtbox" id="studentName" name="studentName" value="${student.studentName }"/> 
		 			 	</td>   
		 			 	<td>
		 			 		<label  class="validate_info" id="studentName_msg"></label>
		 			 	</td> 
		 		</tr>	
		 		<tr>
		 			 	<td class="td_info">性别：</td>	
		 			 	<td class="td_input_short">
		 			 	   
		 			 		&nbsp;&nbsp;&nbsp;<input type="radio" id="man" name="sex" value="男" checked>男
		 			 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 			 		<input type="radio" id="woman" name="sex" value="女">女
		 			 	</td>   
		 			 	<td>
		 			 		<label></label>
		 			 	</td> 
		 		</tr>
		 		<tr>
		 			 	<td class="td_info">专业：</td>	
		 			 	<td class="td_input_short"> 
		 			 		<input type="text" class="txtbox" id="major" name="major" value="${student.major}"/> 
		 			 	</td>   
		 			 	<td>
		 			 		<label class="validate_info" id="studentName_msg"></label>
		 			 	</td> 
		 		</tr>
		 		
		 		<tr>
		 			 	<td class="td_info">班级：</td>	
		 			 	<td class="td_input_short"> 
		 			 		<input type="text" class="txtbox" id="class_" name="class_" value="${student.class_ }"/> 
		 			 	</td>   
		 			 	<td>
		 			 		<label class="validate_info" id="studentName_msg">为学生选择一个班级</label>
		 			 	</td> 
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
