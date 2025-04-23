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

import com.entity.Mubiaoxinxi;
import com.server.MubiaoxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class MubiaoxinxiController {
	@Resource
	private MubiaoxinxiServer mubiaoxinxiService;


   
	@RequestMapping("addMubiaoxinxi.do")
	public String addMubiaoxinxi(HttpServletRequest request,Mubiaoxinxi mubiaoxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		mubiaoxinxi.setAddtime(time.toString().substring(0, 19));
		mubiaoxinxiService.add(mubiaoxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "mubiaoxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:mubiaoxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateMubiaoxinxi.do")
	public String doUpdateMubiaoxinxi(int id,ModelMap map,Mubiaoxinxi mubiaoxinxi){
		mubiaoxinxi=mubiaoxinxiService.getById(id);
		map.put("mubiaoxinxi", mubiaoxinxi);
		return "mubiaoxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("mubiaoxinxiDetail.do")
	public String mubiaoxinxiDetail(int id,ModelMap map,Mubiaoxinxi mubiaoxinxi){
		mubiaoxinxi=mubiaoxinxiService.getById(id);
		map.put("mubiaoxinxi", mubiaoxinxi);
		return "mubiaoxinxi_detail";
	}
//	前台详细
	@RequestMapping("mbxxDetail.do")
	public String mbxxDetail(int id,ModelMap map,Mubiaoxinxi mubiaoxinxi){
		mubiaoxinxi=mubiaoxinxiService.getById(id);
		map.put("mubiaoxinxi", mubiaoxinxi);
		return "mubiaoxinxidetail";
	}
//	
	@RequestMapping("updateMubiaoxinxi.do")
	public String updateMubiaoxinxi(int id,ModelMap map,Mubiaoxinxi mubiaoxinxi,HttpServletRequest request,HttpSession session){
		mubiaoxinxiService.update(mubiaoxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:mubiaoxinxiList.do";
	}

//	分页查询
	@RequestMapping("mubiaoxinxiList.do")
	public String mubiaoxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Mubiaoxinxi mubiaoxinxi, String xuehao, String xingming, String mubiao, String xiangqingmiaoshu, String qiwangriqi1,String qiwangriqi2, String dangqianjindu, String jindumingxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(mubiao==null||mubiao.equals("")){pmap.put("mubiao", null);}else{pmap.put("mubiao", mubiao);}		if(xiangqingmiaoshu==null||xiangqingmiaoshu.equals("")){pmap.put("xiangqingmiaoshu", null);}else{pmap.put("xiangqingmiaoshu", xiangqingmiaoshu);}		if(qiwangriqi1==null||qiwangriqi1.equals("")){pmap.put("qiwangriqi1", null);}else{pmap.put("qiwangriqi1", qiwangriqi1);}		if(qiwangriqi2==null||qiwangriqi2.equals("")){pmap.put("qiwangriqi2", null);}else{pmap.put("qiwangriqi2", qiwangriqi2);}		if(dangqianjindu==null||dangqianjindu.equals("")){pmap.put("dangqianjindu", null);}else{pmap.put("dangqianjindu", dangqianjindu);}		if(jindumingxi==null||jindumingxi.equals("")){pmap.put("jindumingxi", null);}else{pmap.put("jindumingxi", jindumingxi);}		
		int total=mubiaoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Mubiaoxinxi> list=mubiaoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "mubiaoxinxi_list";
	}
	
	@RequestMapping("mubiaoxinxiList2.do")
	public String mubiaoxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Mubiaoxinxi mubiaoxinxi, String xuehao, String xingming, String mubiao, String xiangqingmiaoshu, String qiwangriqi1,String qiwangriqi2, String dangqianjindu, String jindumingxi,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(mubiao==null||mubiao.equals("")){pmap.put("mubiao", null);}else{pmap.put("mubiao", mubiao);}		if(xiangqingmiaoshu==null||xiangqingmiaoshu.equals("")){pmap.put("xiangqingmiaoshu", null);}else{pmap.put("xiangqingmiaoshu", xiangqingmiaoshu);}		if(qiwangriqi1==null||qiwangriqi1.equals("")){pmap.put("qiwangriqi1", null);}else{pmap.put("qiwangriqi1", qiwangriqi1);}		if(qiwangriqi2==null||qiwangriqi2.equals("")){pmap.put("qiwangriqi2", null);}else{pmap.put("qiwangriqi2", qiwangriqi2);}		if(dangqianjindu==null||dangqianjindu.equals("")){pmap.put("dangqianjindu", null);}else{pmap.put("dangqianjindu", dangqianjindu);}		if(jindumingxi==null||jindumingxi.equals("")){pmap.put("jindumingxi", null);}else{pmap.put("jindumingxi", jindumingxi);}		
		
		int total=mubiaoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Mubiaoxinxi> list=mubiaoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "mubiaoxinxi_list2";
	}	
	
	@RequestMapping("mbxxList.do")
	public String mbxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Mubiaoxinxi mubiaoxinxi, String xuehao, String xingming, String mubiao, String xiangqingmiaoshu, String qiwangriqi1,String qiwangriqi2, String dangqianjindu, String jindumingxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(mubiao==null||mubiao.equals("")){pmap.put("mubiao", null);}else{pmap.put("mubiao", mubiao);}		if(xiangqingmiaoshu==null||xiangqingmiaoshu.equals("")){pmap.put("xiangqingmiaoshu", null);}else{pmap.put("xiangqingmiaoshu", xiangqingmiaoshu);}		if(qiwangriqi1==null||qiwangriqi1.equals("")){pmap.put("qiwangriqi1", null);}else{pmap.put("qiwangriqi1", qiwangriqi1);}		if(qiwangriqi2==null||qiwangriqi2.equals("")){pmap.put("qiwangriqi2", null);}else{pmap.put("qiwangriqi2", qiwangriqi2);}		if(dangqianjindu==null||dangqianjindu.equals("")){pmap.put("dangqianjindu", null);}else{pmap.put("dangqianjindu", dangqianjindu);}		if(jindumingxi==null||jindumingxi.equals("")){pmap.put("jindumingxi", null);}else{pmap.put("jindumingxi", jindumingxi);}		
		int total=mubiaoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Mubiaoxinxi> list=mubiaoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "mubiaoxinxilist";
	}
	
	@RequestMapping("deleteMubiaoxinxi.do")
	public String deleteMubiaoxinxi(int id,HttpServletRequest request){
		mubiaoxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:mubiaoxinxiList.do";
	}
	
	
}
