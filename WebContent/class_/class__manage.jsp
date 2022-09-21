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

  </head>
  
  <body>
	<div class ="div_title">
		<div class="div_titlename"> <img src="images/san_jiao.gif" ><span>班级维护  班级管理</span></div>
    </div>   
	<form action="Class_Servlet" method="post">
	    <input type="hidden" name="flag" value="manage">
	    <input type="hidden" name="class_Id" value="${class_.id }">
	    
	    <table class="main_table">
	    
	       <tr>
	       		<th colspan="2" >专业</th>
	       		<th colspan="2" >班级</th>
	       </tr>
	       
	       <c:forEach var="class_" items="${class_List }">
	       		<tr>
		       		<td>
		       			${class_.class_Name }_${class_.id }
		       		</td>
		       		<td>
		      			<a href="Class_Servlet?flag=delete&id=${class_.id }" onclick="return confirm('确定要删除吗')" >删除</a>
          			</td>
		       		<td>
		       			<c:forEach var="cl_sub" items="${class_.subClass_List }">
		       				${cl_sub.class_Name }_${cl_sub.id }<br />
		       			</c:forEach>
		       		</td>
		       		<td>
		       			<c:forEach var="cl_sub" items="${class_.subClass_List }">
		      			<a href="Class_Servlet?flag=delete&id=${class_.id }" onclick="return confirm('确定要删除吗')" >删除</a><br/>
          				</c:forEach>
          			</td>
	            </tr>
	       </c:forEach>
	       
	    </table>
	    
	</form>
	
	${msg }
	
  </body>
</html>





