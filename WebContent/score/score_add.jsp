<%@ page language="java" import="java.util.*,com.beans.*,com.dao.*" pageEncoding="UTF-8"%>
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
		 <div class="div_titlename"> <img src="images/san_jiao.gif" ><span>成绩维护   录入成绩</span></div>
	 </div>
	 <%
	 	Class_Dao class_Dao=new Class_Dao();
	 	 	 List<Class_Info> class_List=class_Dao.getClass_List(0);
	 	 	 request.setAttribute("class_List",class_List);
	 %>
	<form action="ScoreServlet" method="post">
		<input type="hidden" name="flag" value="add">
		<table class="edit_table" >
				<tr>
		 			 	<td class="td_info">课程：</td>
		 			 	<td class="td_bg"> 
	 			 		    <select name="courseId">
								<option>请选择课程</option>
								<c:forEach var="score" items="${scoreList }">
									<option value="${score.id}"> ${score.name }</option>
								</c:forEach>
							</select>
		 			 	</td>   
		 			 	<td>
		 			 		<label class="validate_info" id="name_msg"></label>
		 			 	</td> 
		 		</tr>
		 		<tr>
		 			 	<td class="td_info">学生学号：</td>	
		 			 	<td class="td_input_short"> 
		 			 		<input type="text" class="txtbox" id="id" name="id" value="${param.id }"/> 
		 			 	</td>   
		 			 	<td>
		 			 		<label class="validate_info" id="name_msg"></label>
		 			 	</td> 
		 		</tr>
		 		<tr>
		 			 	<td class="td_info">学生姓名：</td>	
		 			 	<td class="td_input_short"> 
		 			 		<input type="text" class="txtbox" id="name" name="name" value="${param.name }"/> 
		 			 	</td>   
		 			 	<td>
		 			 		<label class="validate_info" id="name_msg"></label>
		 			 	</td> 
		 		</tr>
		 		<tr>
		 			 	<td class="td_info">成绩：</td>	
		 			 	<td class="td_input_short"> 
		 			 		<input type="text" class="txtbox" id="id" name="id" value="${param.score }"/> 
		 			 	</td>   
		 			 	<td>
		 			 		<label class="validate_info" id="name_msg"></label>
		 			 	</td> 
		 		</tr>
		 		<tr>
		 			<td class="td_info"> </td>	
		 			<td> 
		 			<input class="form_btn" type="submit" value="提交" onclick="return confirm('确定提交吗')" />
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
