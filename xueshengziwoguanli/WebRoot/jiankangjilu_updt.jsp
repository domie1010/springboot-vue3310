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
		<TITLE>修改健康记录</TITLE>
	    
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
	document.location.href="jiankangjilu_add.jsp?id=<%=id%>";
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
			<form action="updateJiankangjilu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改健康记录<input type="hidden" name="id" value="${jiankangjilu.id}" /></td>
						</tr>
						<tr ><td width="200">学号：</td><td><input name='xuehao' type='text' id='xuehao' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelxuehao' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxingming' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("xueshengxinxi","xingming","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">日期：</td><td><input name='riqi' type='text' id='riqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelriqi' /></td></tr>		<tr ><td width="200">健康状况：</td><td><input name='jiankangzhuangkuang' type='text' id='jiankangzhuangkuang' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">处理方式：</td><td><input name='chulifangshi' type='text' id='chulifangshi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">是否有效：</td><td><select name='shifouyouxiao' id='shifouyouxiao'><option value="有效">有效</option><option value="无效">无效</option><option value="待观察">待观察</option></select></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xuehao.value='${jiankangjilu.xuehao}';</script>	<script language="javascript">document.form1.xingming.value='${jiankangjilu.xingming}';</script>	<script language="javascript">document.form1.riqi.value='${jiankangjilu.riqi}';</script>	<script language="javascript">document.form1.jiankangzhuangkuang.value='${jiankangjilu.jiankangzhuangkuang}';</script>	<script language="javascript">document.form1.chulifangshi.value='${jiankangjilu.chulifangshi}';</script>	<script language="javascript">document.form1.shifouyouxiao.value='${jiankangjilu.shifouyouxiao}';</script>	<script language="javascript">document.form1.beizhu.value='${jiankangjilu.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var xuehaoobj = document.getElementById("xuehao"); if(xuehaoobj.value==""){document.getElementById("clabelxuehao").innerHTML="&nbsp;&nbsp;<font color=red>请输入学号</font>";return false;}else{document.getElementById("clabelxuehao").innerHTML="  "; } 	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 	var riqiobj = document.getElementById("riqi"); if(riqiobj.value==""){document.getElementById("clabelriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入日期</font>";return false;}else{document.getElementById("clabelriqi").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
