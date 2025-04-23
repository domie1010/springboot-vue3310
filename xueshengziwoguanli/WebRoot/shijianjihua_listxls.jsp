<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shijianjihuahsgb" scope="page" class="com.bean.ShijianjihuaBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shijianjihua.xls");
%>
<html>
  <head>
    <title>时间计划</title>
  </head>

  <body >
 <%
			String sql="select * from shijianjihua  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>学号</td>    <td align='center'>姓名</td>    <td  width='95' align='center'>计划时间</td>    <td align='center'>计划名称</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shijianjihuahsgb.getAllShijianjihua(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.jihuashijian}</td>    <td>${u.jihuamingcheng}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

