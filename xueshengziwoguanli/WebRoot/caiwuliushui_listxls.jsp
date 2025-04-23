<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="caiwuliushuihsgb" scope="page" class="com.bean.CaiwuliushuiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=caiwuliushui.xls");
%>
<html>
  <head>
    <title>财务流水</title>
  </head>

  <body >
 <%
			String sql="select * from caiwuliushui  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>学号</td>    <td align='center'>姓名</td>    <td  width='65' align='center'>日期</td>    <td align='center'>收支类型</td>    <td align='center'>摘要</td>    <td align='center'>金额</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=caiwuliushuihsgb.getAllCaiwuliushui(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.riqi}</td>    <td>${u.shouzhileixing}</td>    <td>${u.zhaiyao}</td>    <td>${u.jine}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

