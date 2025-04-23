<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="mubiaoxinxihsgb" scope="page" class="com.bean.MubiaoxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=mubiaoxinxi.xls");
%>
<html>
  <head>
    <title>目标信息</title>
  </head>

  <body >
 <%
			String sql="select * from mubiaoxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>学号</td>    <td align='center'>姓名</td>    <td align='center'>目标</td>        <td  width='65' align='center'>期望日期</td>    <td align='center'>当前进度</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=mubiaoxinxihsgb.getAllMubiaoxinxi(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.mubiao}</td>        <td>${u.qiwangriqi}</td>    <td>${u.dangqianjindu}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

