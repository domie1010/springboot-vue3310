<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>心态记录详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  心态记录详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${xintaijilu.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${xintaijilu.xingming}</td></tr><tr>     <td width='11%'>日期：</td><td width='39%'>${xintaijilu.riqi}</td>     <td width='11%'>状态：</td><td width='39%'>${xintaijilu.zhuangtai}</td></tr><tr>     <td width='11%'>负情绪源：</td><td width='39%'>${xintaijilu.fuqingxuyuan}</td>     <td width='11%'>处理方式：</td><td width='39%'>${xintaijilu.chulifangshi}</td></tr><tr>     <td width='11%'>是否有效：</td><td width='39%'>${xintaijilu.shifouyouxiao}</td>     <td width='11%'>备注：</td><td width='39%'>${xintaijilu.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

