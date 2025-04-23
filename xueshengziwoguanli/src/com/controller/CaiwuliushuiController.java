package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Caiwuliushui;
import com.server.CaiwuliushuiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CaiwuliushuiController {
	@Resource
	private CaiwuliushuiServer caiwuliushuiService;


   
	@RequestMapping("addCaiwuliushui.do")
	public String addCaiwuliushui(HttpServletRequest request,Caiwuliushui caiwuliushui,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		caiwuliushui.setAddtime(time.toString().substring(0, 19));
		caiwuliushuiService.add(caiwuliushui);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "caiwuliushuiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:caiwuliushuiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateCaiwuliushui.do")
	public String doUpdateCaiwuliushui(int id,ModelMap map,Caiwuliushui caiwuliushui){
		caiwuliushui=caiwuliushuiService.getById(id);
		map.put("caiwuliushui", caiwuliushui);
		return "caiwuliushui_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("caiwuliushuiDetail.do")
	public String caiwuliushuiDetail(int id,ModelMap map,Caiwuliushui caiwuliushui){
		caiwuliushui=caiwuliushuiService.getById(id);
		map.put("caiwuliushui", caiwuliushui);
		return "caiwuliushui_detail";
	}
//	前台详细
	@RequestMapping("cwlsDetail.do")
	public String cwlsDetail(int id,ModelMap map,Caiwuliushui caiwuliushui){
		caiwuliushui=caiwuliushuiService.getById(id);
		map.put("caiwuliushui", caiwuliushui);
		return "caiwuliushuidetail";
	}
//	
	@RequestMapping("updateCaiwuliushui.do")
	public String updateCaiwuliushui(int id,ModelMap map,Caiwuliushui caiwuliushui,HttpServletRequest request,HttpSession session){
		caiwuliushuiService.update(caiwuliushui);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:caiwuliushuiList.do";
	}

//	分页查询
	@RequestMapping("caiwuliushuiList.do")
	public String caiwuliushuiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caiwuliushui caiwuliushui, String xuehao, String xingming, String riqi1,String riqi2, String shouzhileixing, String zhaiyao, String jine1,String jine2, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(shouzhileixing==null||shouzhileixing.equals("")){pmap.put("shouzhileixing", null);}else{pmap.put("shouzhileixing", shouzhileixing);}		if(zhaiyao==null||zhaiyao.equals("")){pmap.put("zhaiyao", null);}else{pmap.put("zhaiyao", zhaiyao);}		if(jine1==null||jine1.equals("")){pmap.put("jine1", null);}else{pmap.put("jine1", jine1);}		if(jine2==null||jine2.equals("")){pmap.put("jine2", null);}else{pmap.put("jine2", jine2);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=caiwuliushuiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caiwuliushui> list=caiwuliushuiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caiwuliushui_list";
	}
	
	@RequestMapping("caiwuliushuiList2.do")
	public String caiwuliushuiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caiwuliushui caiwuliushui, String xuehao, String xingming, String riqi1,String riqi2, String shouzhileixing, String zhaiyao, String jine1,String jine2, String beizhu,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("xuehao", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(shouzhileixing==null||shouzhileixing.equals("")){pmap.put("shouzhileixing", null);}else{pmap.put("shouzhileixing", shouzhileixing);}		if(zhaiyao==null||zhaiyao.equals("")){pmap.put("zhaiyao", null);}else{pmap.put("zhaiyao", zhaiyao);}		if(jine1==null||jine1.equals("")){pmap.put("jine1", null);}else{pmap.put("jine1", jine1);}		if(jine2==null||jine2.equals("")){pmap.put("jine2", null);}else{pmap.put("jine2", jine2);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		
		int total=caiwuliushuiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caiwuliushui> list=caiwuliushuiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caiwuliushui_list2";
	}	
	
	@RequestMapping("cwlsList.do")
	public String cwlsList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caiwuliushui caiwuliushui, String xuehao, String xingming, String riqi1,String riqi2, String shouzhileixing, String zhaiyao, String jine1,String jine2, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(shouzhileixing==null||shouzhileixing.equals("")){pmap.put("shouzhileixing", null);}else{pmap.put("shouzhileixing", shouzhileixing);}		if(zhaiyao==null||zhaiyao.equals("")){pmap.put("zhaiyao", null);}else{pmap.put("zhaiyao", zhaiyao);}		if(jine1==null||jine1.equals("")){pmap.put("jine1", null);}else{pmap.put("jine1", jine1);}		if(jine2==null||jine2.equals("")){pmap.put("jine2", null);}else{pmap.put("jine2", jine2);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=caiwuliushuiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caiwuliushui> list=caiwuliushuiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caiwuliushuilist";
	}
	
	@RequestMapping("deleteCaiwuliushui.do")
	public String deleteCaiwuliushui(int id,HttpServletRequest request){
		caiwuliushuiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:caiwuliushuiList.do";
	}
	
	
}
