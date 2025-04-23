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
		<TITLE>修改财务流水</TITLE>
	    
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
	document.location.href="caiwuliushui_add.jsp?id=<%=id%>";
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
			<form action="updateCaiwuliushui.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改财务流水<input type="hidden" name="id" value="${caiwuliushui.id}" /></td>
						</tr>
						<tr ><td width="200">学号：</td><td><input name='xuehao' type='text' id='xuehao' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelxuehao' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("xueshengxinxi","xingming","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">日期：</td><td><input name='riqi' type='text' id='riqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelriqi' /></td></tr>		<tr ><td width="200">收支类型：</td><td><select name='shouzhileixing' id='shouzhileixing'><option value="收入">收入</option><option value="支出">支出</option></select></td></tr>		<tr ><td width="200">摘要：</td><td><input name='zhaiyao' type='text' id='zhaiyao' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">金额：</td><td><input name='jine' type='text' id='jine' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeljine' /></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xuehao.value='${caiwuliushui.xuehao}';</script>	<script language="javascript">document.form1.xingming.value='${caiwuliushui.xingming}';</script>	<script language="javascript">document.form1.riqi.value='${caiwuliushui.riqi}';</script>	<script language="javascript">document.form1.shouzhileixing.value='${caiwuliushui.shouzhileixing}';</script>	<script language="javascript">document.form1.zhaiyao.value='${caiwuliushui.zhaiyao}';</script>	<script language="javascript">document.form1.jine.value='${caiwuliushui.jine}';</script>	<script language="javascript">document.form1.beizhu.value='${caiwuliushui.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var xuehaoobj = document.getElementById("xuehao"); if(xuehaoobj.value==""){document.getElementById("clabelxuehao").innerHTML="&nbsp;&nbsp;<font color=red>请输入学号</font>";return false;}else{document.getElementById("clabelxuehao").innerHTML="  "; } 	var riqiobj = document.getElementById("riqi"); if(riqiobj.value==""){document.getElementById("clabelriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入日期</font>";return false;}else{document.getElementById("clabelriqi").innerHTML="  "; } 	var jineobj = document.getElementById("jine"); if(jineobj.value==""){document.getElementById("clabeljine").innerHTML="&nbsp;&nbsp;<font color=red>请输入金额</font>";return false;}else{document.getElementById("clabeljine").innerHTML="  "; } 	    


return true;   
}   
popheight=450;
</script>  
