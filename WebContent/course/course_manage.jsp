<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

  </head>
  
  <body>
  
  <div class ="div_title">
						<div class="div_titlename"> <img src="images/san_jiao.gif" ><span>课程列表</span></div>
 </div>
	<table class="main_table">
		<tr>
		   <th>课程编号</th>
		   <th>课程名称</th>
		   <th>授课教师</th>
		   <th>教室</th>
		   <th>学时</th>
		   <th>学分</th>
		</tr>
		
		<c:forEach var="course" items="${courseList}"  >
		<tr>
		   <td>${course.id }</td>
		   <td>${course.courseName }</td>
		   <td>${course.teacher }</td>
		   <td>${course.classroom }</td>
		   <td>${course.period }</td>
		   <td>${course.credit }</td>
		</tr>
		</c:forEach>
	</table>
				<div class="div_page" >
					  <div class="div_page_left">    共有 <label>4</label> 条记录，当前第 <label>1</label> 页，共 <label>1</label> 页	</div>		
					  <div class="div_page_right" > 	 
					  			 首页
				  	 			 上一页
					  			 下一页 
				  	 		   尾页

					  <button onclick="javascript:void(0)">转到</button>
					  <input type="text" name="pageIndex" id="pageIndex" value="1" /> 页
					  	
					  </div>
						
				</div>
		<script>
 	   	 var str="${msg }";
 	   	 if(str!=""){
 	   		 alert(str);
 	   	 }
 	   </script>
	
  </body>
</html>
