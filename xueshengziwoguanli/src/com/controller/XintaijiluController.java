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

import com.entity.Xintaijilu;
import com.server.XintaijiluServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XintaijiluController {
	@Resource
	private XintaijiluServer xintaijiluService;


   
	@RequestMapping("addXintaijilu.do")
	public String addXintaijilu(HttpServletRequest request,Xintaijilu xintaijilu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xintaijilu.setAddtime(time.toString().substring(0, 19));
		xintaijiluService.add(xintaijilu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xintaijiluList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xintaijiluList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXintaijilu.do")
	public String doUpdateXintaijilu(int id,ModelMap map,Xintaijilu xintaijilu){
		xintaijilu=xintaijiluService.getById(id);
		map.put("xintaijilu", xintaijilu);
		return "xintaijilu_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xintaijiluDetail.do")
	public String xintaijiluDetail(int id,ModelMap map,Xintaijilu xintaijilu){
		xintaijilu=xintaijiluService.getById(id);
		map.put("xintaijilu", xintaijilu);
		return "xintaijilu_detail";
	}
//	前台详细
	@RequestMapping("xtjlDetail.do")
	public String xtjlDetail(int id,ModelMap map,Xintaijilu xintaijilu){
		xintaijilu=xintaijiluService.getById(id);
		map.put("xintaijilu", xintaijilu);
		return "xintaijiludetail";
	}
//	
	@RequestMapping("updateXintaijilu.do")
	public String updateXintaijilu(int id,ModelMap map,Xintaijilu xintaijilu,HttpServletRequest request,HttpSession session){
		xintaijiluService.update(xintaijilu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xintaijiluList.do";
	}

//	分页查询
	@RequestMapping("xintaijiluList.do")
	public String xintaijiluList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xintaijilu xintaijilu, String xuehao, String xingming, String riqi1,String riqi2, String zhuangtai, String fuqingxuyuan, String chulifangshi, String shifouyouxiao, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}		if(fuqingxuyuan==null||fuqingxuyuan.equals("")){pmap.put("fuqingxuyuan", null);}else{pmap.put("fuqingxuyuan", fuqingxuyuan);}		if(chulifangshi==null||chulifangshi.equals("")){pmap.put("chulifangshi", null);}else{pmap.put("chulifangshi", chulifangshi);}		if(shifouyouxiao==null||shifouyouxiao.equals("")){pmap.put("shifouyouxiao", null);}else{pmap.put("shifouyouxiao", shifouyouxiao);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=xintaijiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xintaijilu> list=xintaijiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xintaijilu_list";
	}
	
	@RequestMapping("xintaijiluList2.do")
	public String xintaijiluList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xintaijilu xintaijilu, String xuehao, String xingming, String riqi1,String riqi2, String zhuangtai, String fuqingxuyuan, String chulifangshi, String shifouyouxiao, String beizhu,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}		if(fuqingxuyuan==null||fuqingxuyuan.equals("")){pmap.put("fuqingxuyuan", null);}else{pmap.put("fuqingxuyuan", fuqingxuyuan);}		if(chulifangshi==null||chulifangshi.equals("")){pmap.put("chulifangshi", null);}else{pmap.put("chulifangshi", chulifangshi);}		if(shifouyouxiao==null||shifouyouxiao.equals("")){pmap.put("shifouyouxiao", null);}else{pmap.put("shifouyouxiao", shifouyouxiao);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		
		int total=xintaijiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xintaijilu> list=xintaijiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xintaijilu_list2";
	}	
	
	@RequestMapping("xtjlList.do")
	public String xtjlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xintaijilu xintaijilu, String xuehao, String xingming, String riqi1,String riqi2, String zhuangtai, String fuqingxuyuan, String chulifangshi, String shifouyouxiao, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}		if(fuqingxuyuan==null||fuqingxuyuan.equals("")){pmap.put("fuqingxuyuan", null);}else{pmap.put("fuqingxuyuan", fuqingxuyuan);}		if(chulifangshi==null||chulifangshi.equals("")){pmap.put("chulifangshi", null);}else{pmap.put("chulifangshi", chulifangshi);}		if(shifouyouxiao==null||shifouyouxiao.equals("")){pmap.put("shifouyouxiao", null);}else{pmap.put("shifouyouxiao", shifouyouxiao);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=xintaijiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xintaijilu> list=xintaijiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xintaijilulist";
	}
	
	@RequestMapping("deleteXintaijilu.do")
	public String deleteXintaijilu(int id,HttpServletRequest request){
		xintaijiluService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xintaijiluList.do";
	}
	
	
}
