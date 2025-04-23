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

import com.entity.Jiankangjilu;
import com.server.JiankangjiluServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiankangjiluController {
	@Resource
	private JiankangjiluServer jiankangjiluService;


   
	@RequestMapping("addJiankangjilu.do")
	public String addJiankangjilu(HttpServletRequest request,Jiankangjilu jiankangjilu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiankangjilu.setAddtime(time.toString().substring(0, 19));
		jiankangjiluService.add(jiankangjilu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiankangjiluList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiankangjiluList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiankangjilu.do")
	public String doUpdateJiankangjilu(int id,ModelMap map,Jiankangjilu jiankangjilu){
		jiankangjilu=jiankangjiluService.getById(id);
		map.put("jiankangjilu", jiankangjilu);
		return "jiankangjilu_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jiankangjiluDetail.do")
	public String jiankangjiluDetail(int id,ModelMap map,Jiankangjilu jiankangjilu){
		jiankangjilu=jiankangjiluService.getById(id);
		map.put("jiankangjilu", jiankangjilu);
		return "jiankangjilu_detail";
	}
//	前台详细
	@RequestMapping("jkjlDetail.do")
	public String jkjlDetail(int id,ModelMap map,Jiankangjilu jiankangjilu){
		jiankangjilu=jiankangjiluService.getById(id);
		map.put("jiankangjilu", jiankangjilu);
		return "jiankangjiludetail";
	}
//	
	@RequestMapping("updateJiankangjilu.do")
	public String updateJiankangjilu(int id,ModelMap map,Jiankangjilu jiankangjilu,HttpServletRequest request,HttpSession session){
		jiankangjiluService.update(jiankangjilu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiankangjiluList.do";
	}

//	分页查询
	@RequestMapping("jiankangjiluList.do")
	public String jiankangjiluList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangjilu jiankangjilu, String xuehao, String xingming, String riqi1,String riqi2, String jiankangzhuangkuang, String chulifangshi, String shifouyouxiao, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(jiankangzhuangkuang==null||jiankangzhuangkuang.equals("")){pmap.put("jiankangzhuangkuang", null);}else{pmap.put("jiankangzhuangkuang", jiankangzhuangkuang);}		if(chulifangshi==null||chulifangshi.equals("")){pmap.put("chulifangshi", null);}else{pmap.put("chulifangshi", chulifangshi);}		if(shifouyouxiao==null||shifouyouxiao.equals("")){pmap.put("shifouyouxiao", null);}else{pmap.put("shifouyouxiao", shifouyouxiao);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiankangjiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangjilu> list=jiankangjiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangjilu_list";
	}
	
	@RequestMapping("jiankangjiluList2.do")
	public String jiankangjiluList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangjilu jiankangjilu, String xuehao, String xingming, String riqi1,String riqi2, String jiankangzhuangkuang, String chulifangshi, String shifouyouxiao, String beizhu,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(jiankangzhuangkuang==null||jiankangzhuangkuang.equals("")){pmap.put("jiankangzhuangkuang", null);}else{pmap.put("jiankangzhuangkuang", jiankangzhuangkuang);}		if(chulifangshi==null||chulifangshi.equals("")){pmap.put("chulifangshi", null);}else{pmap.put("chulifangshi", chulifangshi);}		if(shifouyouxiao==null||shifouyouxiao.equals("")){pmap.put("shifouyouxiao", null);}else{pmap.put("shifouyouxiao", shifouyouxiao);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		
		int total=jiankangjiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangjilu> list=jiankangjiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangjilu_list2";
	}	
	
	@RequestMapping("jkjlList.do")
	public String jkjlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiankangjilu jiankangjilu, String xuehao, String xingming, String riqi1,String riqi2, String jiankangzhuangkuang, String chulifangshi, String shifouyouxiao, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(jiankangzhuangkuang==null||jiankangzhuangkuang.equals("")){pmap.put("jiankangzhuangkuang", null);}else{pmap.put("jiankangzhuangkuang", jiankangzhuangkuang);}		if(chulifangshi==null||chulifangshi.equals("")){pmap.put("chulifangshi", null);}else{pmap.put("chulifangshi", chulifangshi);}		if(shifouyouxiao==null||shifouyouxiao.equals("")){pmap.put("shifouyouxiao", null);}else{pmap.put("shifouyouxiao", shifouyouxiao);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiankangjiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiankangjilu> list=jiankangjiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiankangjilulist";
	}
	
	@RequestMapping("deleteJiankangjilu.do")
	public String deleteJiankangjilu(int id,HttpServletRequest request){
		jiankangjiluService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiankangjiluList.do";
	}
	
	
}
