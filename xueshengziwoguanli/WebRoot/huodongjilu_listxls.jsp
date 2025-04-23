<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="huodongjiluhsgb" scope="page" class="com.bean.HuodongjiluBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=huodongjilu.xls");
%>
<html>
  <head>
    <title>活动记录</title>
  </head>

  <body >
 <%
			String sql="select * from huodongjilu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>学号</td>    <td align='center'>姓名</td>    <td  width='95' align='center'>日期</td>    <td align='center'>交往对象</td>    <td align='center'>活动花费</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=huodongjiluhsgb.getAllHuodongjilu(8);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.riqi}</td>    <td>${u.jiaowangduixiang}</td>    <td>${u.huodonghuafei}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

