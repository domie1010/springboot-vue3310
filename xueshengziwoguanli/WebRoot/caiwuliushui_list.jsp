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
	<TITLE>财务流水查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">财务流水列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="caiwuliushuiList.do" name="myform" method="post">
									查询   学号：<input name="xuehao" type="text" id="xuehao" style='border:solid 1px #000000; color:#666666' size="12" />  姓名：<input name="xingming" type="text" id="xingming" style='border:solid 1px #000000; color:#666666' size="12" />  日期：<input name="riqi1" type="text" id="riqi1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />-<input name="riqi2" type="text" id="riqi2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' /> 收支类型：<select name='shouzhileixing' id='shouzhileixing' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="收入">收入</option><option value="支出">支出</option></select>  摘要：<input name="zhaiyao" type="text" id="zhaiyao" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>学号</td>    <td align='center'>姓名</td>    <td  width='65' align='center'>日期</td>    <td align='center'>收支类型</td>    <td align='center'>摘要</td>    <td align='center'>金额</td>        
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.riqi}</td>    <td>${u.shouzhileixing}</td>    <td>${u.zhaiyao}</td>    <td>${u.jine}</td>        
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateCaiwuliushui.do?id=${u.id }">编辑</a>  <a href="deleteCaiwuliushui.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="caiwuliushuiDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from caiwuliushui where 1=1 ";
				if(request.getParameter("xuehao")=="" ||request.getParameter("xuehao")==null ){}else{String nxuehao=new String(request.getParameter("xuehao").getBytes("8859_1"));if(nxuehao.contains("?")){nxuehao=request.getParameter("xuehao");}sql=sql+" and xuehao like '%"+nxuehao+"%'";}if(request.getParameter("xingming")=="" ||request.getParameter("xingming")==null ){}else{String nxingming=new String(request.getParameter("xingming").getBytes("8859_1"));if(nxingming.contains("?")){nxingming=request.getParameter("xingming");}sql=sql+" and xingming like '%"+nxingming+"%'";}if (request.getParameter("riqi1")==""  ||request.getParameter("riqi1")==null ) {}else{sql=sql+" and riqi >= '"+request.getParameter("riqi1")+"'";}if (request.getParameter("riqi2")==""  ||request.getParameter("riqi2")==null ) {}else {sql=sql+" and riqi <= '"+request.getParameter("riqi2")+"'";}if(request.getParameter("shouzhileixing")=="" ||request.getParameter("shouzhileixing")==null ){}else{sql=sql+" and shouzhileixing like '%"+request.getParameter("shouzhileixing")+"%'";}if(request.getParameter("zhaiyao")=="" ||request.getParameter("zhaiyao")==null ){}else{String nzhaiyao=new String(request.getParameter("zhaiyao").getBytes("8859_1"));if(nzhaiyao.contains("?")){nzhaiyao=request.getParameter("zhaiyao");}sql=sql+" and zhaiyao like '%"+nzhaiyao+"%'";}
			sql+=" order by id desc";
double jinez=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						jinez=jinez+Float.valueOf(RS_result.getString("jine")).floatValue();
						
						
			 }
			%>
		共计金额:<%=jinez%>； 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="caiwuliushuiList.do?page=1" >首页</a>
             <a href="caiwuliushuiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="caiwuliushuiList.do?page=${page.page+1 }">下一页</a>
			<a href="caiwuliushuiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
