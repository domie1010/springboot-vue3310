<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>活动记录详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  活动记录详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${huodongjilu.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${huodongjilu.xingming}</td></tr><tr>     <td width='11%'>日期：</td><td width='39%'>${huodongjilu.riqi}</td>     <td width='11%'>交往对象：</td><td width='39%'>${huodongjilu.jiaowangduixiang}</td></tr><tr>     <td width='11%'>活动花费：</td><td width='39%'>${huodongjilu.huodonghuafei}</td>     <td width='11%'>活动内容：</td><td width='39%'>${huodongjilu.huodongneirong}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

