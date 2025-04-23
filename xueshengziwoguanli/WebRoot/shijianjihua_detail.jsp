<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>时间计划详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  时间计划详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${shijianjihua.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${shijianjihua.xingming}</td></tr><tr>     <td width='11%'>计划时间：</td><td width='39%'>${shijianjihua.jihuashijian}</td>     <td width='11%'>计划名称：</td><td width='39%'>${shijianjihua.jihuamingcheng}</td></tr><tr>     <td width='11%'>计划内容：</td><td width='39%'>${shijianjihua.jihuaneirong}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

