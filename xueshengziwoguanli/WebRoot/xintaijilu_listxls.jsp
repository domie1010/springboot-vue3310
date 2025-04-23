<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xintaijiluhsgb" scope="page" class="com.bean.XintaijiluBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xintaijilu.xls");
%>
<html>
  <head>
    <title>心态记录</title>
  </head>

  <body >
 <%
			String sql="select * from xintaijilu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>学号</td>    <td align='center'>姓名</td>    <td  width='65' align='center'>日期</td>    <td align='center'>状态</td>    <td align='center'>负情绪源</td>    <td align='center'>处理方式</td>    <td align='center'>是否有效</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xintaijiluhsgb.getAllXintaijilu(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.riqi}</td>    <td>${u.zhuangtai}</td>    <td>${u.fuqingxuyuan}</td>    <td>${u.chulifangshi}</td>    <td>${u.shifouyouxiao}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

