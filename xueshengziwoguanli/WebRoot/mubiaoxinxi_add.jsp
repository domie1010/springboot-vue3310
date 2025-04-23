<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>添加目标信息</TITLE>
	    

 	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>      
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="mubiaoxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addMubiaoxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加目标信息</td>
						</tr>
						<tr ><td width="200">学号：</td><td><input name='xuehao' type='text' id='xuehao' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelxuehao' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxingming' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("xueshengxinxi","xingming","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">目标：</td><td><input name='mubiao' type='text' id='mubiao' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmubiao' /></td></tr>		<tr ><td width="200">详情描述：</td><td><textarea name='xiangqingmiaoshu' cols='50' rows='5' id='xiangqingmiaoshu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		<tr ><td width="200">期望日期：</td><td><input name='qiwangriqi' type='text' id='qiwangriqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelqiwangriqi' /></td></tr>		<tr ><td width="200">当前进度：</td><td><input name='dangqianjindu' type='text' id='dangqianjindu' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">进度明细：</td><td><textarea name='jindumingxi' cols='50' rows='5' id='jindumingxi' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var xuehaoobj = document.getElementById("xuehao"); if(xuehaoobj.value==""){document.getElementById("clabelxuehao").innerHTML="&nbsp;&nbsp;<font color=red>请输入学号</font>";return false;}else{document.getElementById("clabelxuehao").innerHTML="  "; } 	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 	var mubiaoobj = document.getElementById("mubiao"); if(mubiaoobj.value==""){document.getElementById("clabelmubiao").innerHTML="&nbsp;&nbsp;<font color=red>请输入目标</font>";return false;}else{document.getElementById("clabelmubiao").innerHTML="  "; } 	var qiwangriqiobj = document.getElementById("qiwangriqi"); if(qiwangriqiobj.value==""){document.getElementById("clabelqiwangriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入期望日期</font>";return false;}else{document.getElementById("clabelqiwangriqi").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
