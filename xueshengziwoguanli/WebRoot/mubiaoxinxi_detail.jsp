<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>目标信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  目标信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${mubiaoxinxi.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${mubiaoxinxi.xingming}</td></tr><tr>     <td width='11%'>目标：</td><td width='39%'>${mubiaoxinxi.mubiao}</td>     <td width='11%'>详情描述：</td><td width='39%'>${mubiaoxinxi.xiangqingmiaoshu}</td></tr><tr>     <td width='11%'>期望日期：</td><td width='39%'>${mubiaoxinxi.qiwangriqi}</td>     <td width='11%'>当前进度：</td><td width='39%'>${mubiaoxinxi.dangqianjindu}</td></tr><tr>     <td width='11%'>进度明细：</td><td width='39%'>${mubiaoxinxi.jindumingxi}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

