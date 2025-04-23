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

import com.entity.Huodongjilu;
import com.server.HuodongjiluServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HuodongjiluController {
	@Resource
	private HuodongjiluServer huodongjiluService;


   
	@RequestMapping("addHuodongjilu.do")
	public String addHuodongjilu(HttpServletRequest request,Huodongjilu huodongjilu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		huodongjilu.setAddtime(time.toString().substring(0, 19));
		huodongjiluService.add(huodongjilu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "huodongjiluList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:huodongjiluList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHuodongjilu.do")
	public String doUpdateHuodongjilu(int id,ModelMap map,Huodongjilu huodongjilu){
		huodongjilu=huodongjiluService.getById(id);
		map.put("huodongjilu", huodongjilu);
		return "huodongjilu_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("huodongjiluDetail.do")
	public String huodongjiluDetail(int id,ModelMap map,Huodongjilu huodongjilu){
		huodongjilu=huodongjiluService.getById(id);
		map.put("huodongjilu", huodongjilu);
		return "huodongjilu_detail";
	}
//	前台详细
	@RequestMapping("hdjlDetail.do")
	public String hdjlDetail(int id,ModelMap map,Huodongjilu huodongjilu){
		huodongjilu=huodongjiluService.getById(id);
		map.put("huodongjilu", huodongjilu);
		return "huodongjiludetail";
	}
//	
	@RequestMapping("updateHuodongjilu.do")
	public String updateHuodongjilu(int id,ModelMap map,Huodongjilu huodongjilu,HttpServletRequest request,HttpSession session){
		huodongjiluService.update(huodongjilu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:huodongjiluList.do";
	}

//	分页查询
	@RequestMapping("huodongjiluList.do")
	public String huodongjiluList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongjilu huodongjilu, String xuehao, String xingming, String riqi1,String riqi2, String jiaowangduixiang, String huodonghuafei1,String huodonghuafei2, String huodongneirong){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(jiaowangduixiang==null||jiaowangduixiang.equals("")){pmap.put("jiaowangduixiang", null);}else{pmap.put("jiaowangduixiang", jiaowangduixiang);}		if(huodonghuafei1==null||huodonghuafei1.equals("")){pmap.put("huodonghuafei1", null);}else{pmap.put("huodonghuafei1", huodonghuafei1);}		if(huodonghuafei2==null||huodonghuafei2.equals("")){pmap.put("huodonghuafei2", null);}else{pmap.put("huodonghuafei2", huodonghuafei2);}		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}		
		int total=huodongjiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongjilu> list=huodongjiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongjilu_list";
	}
	
	@RequestMapping("huodongjiluList2.do")
	public String huodongjiluList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongjilu huodongjilu, String xuehao, String xingming, String riqi1,String riqi2, String jiaowangduixiang, String huodonghuafei1,String huodonghuafei2, String huodongneirong,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(jiaowangduixiang==null||jiaowangduixiang.equals("")){pmap.put("jiaowangduixiang", null);}else{pmap.put("jiaowangduixiang", jiaowangduixiang);}		if(huodonghuafei1==null||huodonghuafei1.equals("")){pmap.put("huodonghuafei1", null);}else{pmap.put("huodonghuafei1", huodonghuafei1);}		if(huodonghuafei2==null||huodonghuafei2.equals("")){pmap.put("huodonghuafei2", null);}else{pmap.put("huodonghuafei2", huodonghuafei2);}		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}		
		
		int total=huodongjiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongjilu> list=huodongjiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongjilu_list2";
	}	
	
	@RequestMapping("hdjlList.do")
	public String hdjlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongjilu huodongjilu, String xuehao, String xingming, String riqi1,String riqi2, String jiaowangduixiang, String huodonghuafei1,String huodonghuafei2, String huodongneirong){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(jiaowangduixiang==null||jiaowangduixiang.equals("")){pmap.put("jiaowangduixiang", null);}else{pmap.put("jiaowangduixiang", jiaowangduixiang);}		if(huodonghuafei1==null||huodonghuafei1.equals("")){pmap.put("huodonghuafei1", null);}else{pmap.put("huodonghuafei1", huodonghuafei1);}		if(huodonghuafei2==null||huodonghuafei2.equals("")){pmap.put("huodonghuafei2", null);}else{pmap.put("huodonghuafei2", huodonghuafei2);}		if(huodongneirong==null||huodongneirong.equals("")){pmap.put("huodongneirong", null);}else{pmap.put("huodongneirong", huodongneirong);}		
		int total=huodongjiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongjilu> list=huodongjiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongjilulist";
	}
	
	@RequestMapping("deleteHuodongjilu.do")
	public String deleteHuodongjilu(int id,HttpServletRequest request){
		huodongjiluService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:huodongjiluList.do";
	}
	
	
}
