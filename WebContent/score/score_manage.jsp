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
		<div class="div_titlename"> <img src="images/san_jiao.gif" ><span>分数维护</span></div>
    </div>   
	<form action="ScoreServlet" method="post">
	    <input type="hidden" name="flag" value="manage">
	    <input type="hidden" name="id" value="${score.id }">
	    
	    <table class="main_table">
	    
	       <tr>
	       		<th>课程编号</th>
	       		<th>课程名称</th>
	       		<th>学生学号</th>
	       		<th>学生姓名</th>
	       		<th>分数</th>
	       		<th></th>
	       </tr>
	       
	       <c:forEach var="score" items="${scoreList }">
	       		<tr>
		       		<td>
		       			${score.id }
		       		</td>
		       		<td>
		       			${score.name }
		       		</td>
		       		<td>
		       			<c:forEach var="s_sub" items="${score.subScoreList }">
		       				${s_sub.id }<br />
		       			</c:forEach>
		       		</td>
		       		<td>
		       			<c:forEach var="s_sub" items="${score.subScoreList }">
		       				${s_sub.name }<br />
		       			</c:forEach>
		       		</td>
		       		<td>
		       			<c:forEach var="s_sub" items="${score.subScoreList }">
		       				${s_sub.score }<br />
		       			</c:forEach>
		       		</td>
		       		<td>
		       			<c:forEach var="s_sub" items="${score.subScoreList }">
		      			<a href="ScoreServlet?flag=update&id=${score.id }" onclick="return confirm('确定要修改吗')" >修改</a><br/>
          				</c:forEach>
          			</td>
	            </tr>
	       </c:forEach>
	       
	    </table>
	    
	</form>
	
	${msg }
	
  </body>
</html>





