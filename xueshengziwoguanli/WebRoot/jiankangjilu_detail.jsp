<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>健康记录详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  健康记录详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${jiankangjilu.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${jiankangjilu.xingming}</td></tr><tr>     <td width='11%'>日期：</td><td width='39%'>${jiankangjilu.riqi}</td>     <td width='11%'>健康状况：</td><td width='39%'>${jiankangjilu.jiankangzhuangkuang}</td></tr><tr>     <td width='11%'>处理方式：</td><td width='39%'>${jiankangjilu.chulifangshi}</td>     <td width='11%'>是否有效：</td><td width='39%'>${jiankangjilu.shifouyouxiao}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${jiankangjilu.beizhu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

