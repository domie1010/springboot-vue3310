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

import com.entity.Shijianjihua;
import com.server.ShijianjihuaServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShijianjihuaController {
	@Resource
	private ShijianjihuaServer shijianjihuaService;


   
	@RequestMapping("addShijianjihua.do")
	public String addShijianjihua(HttpServletRequest request,Shijianjihua shijianjihua,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shijianjihua.setAddtime(time.toString().substring(0, 19));
		shijianjihuaService.add(shijianjihua);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shijianjihuaList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shijianjihuaList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShijianjihua.do")
	public String doUpdateShijianjihua(int id,ModelMap map,Shijianjihua shijianjihua){
		shijianjihua=shijianjihuaService.getById(id);
		map.put("shijianjihua", shijianjihua);
		return "shijianjihua_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shijianjihuaDetail.do")
	public String shijianjihuaDetail(int id,ModelMap map,Shijianjihua shijianjihua){
		shijianjihua=shijianjihuaService.getById(id);
		map.put("shijianjihua", shijianjihua);
		return "shijianjihua_detail";
	}
//	前台详细
	@RequestMapping("sjjhDetail.do")
	public String sjjhDetail(int id,ModelMap map,Shijianjihua shijianjihua){
		shijianjihua=shijianjihuaService.getById(id);
		map.put("shijianjihua", shijianjihua);
		return "shijianjihuadetail";
	}
//	
	@RequestMapping("updateShijianjihua.do")
	public String updateShijianjihua(int id,ModelMap map,Shijianjihua shijianjihua,HttpServletRequest request,HttpSession session){
		shijianjihuaService.update(shijianjihua);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shijianjihuaList.do";
	}

//	分页查询
	@RequestMapping("shijianjihuaList.do")
	public String shijianjihuaList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shijianjihua shijianjihua, String xuehao, String xingming, String jihuashijian1,String jihuashijian2, String jihuamingcheng, String jihuaneirong){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jihuashijian1==null||jihuashijian1.equals("")){pmap.put("jihuashijian1", null);}else{pmap.put("jihuashijian1", jihuashijian1);}		if(jihuashijian2==null||jihuashijian2.equals("")){pmap.put("jihuashijian2", null);}else{pmap.put("jihuashijian2", jihuashijian2);}		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuaneirong==null||jihuaneirong.equals("")){pmap.put("jihuaneirong", null);}else{pmap.put("jihuaneirong", jihuaneirong);}		
		int total=shijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shijianjihua> list=shijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shijianjihua_list";
	}
	
	@RequestMapping("shijianjihuaList2.do")
	public String shijianjihuaList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shijianjihua shijianjihua, String xuehao, String xingming, String jihuashijian1,String jihuashijian2, String jihuamingcheng, String jihuaneirong,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jihuashijian1==null||jihuashijian1.equals("")){pmap.put("jihuashijian1", null);}else{pmap.put("jihuashijian1", jihuashijian1);}		if(jihuashijian2==null||jihuashijian2.equals("")){pmap.put("jihuashijian2", null);}else{pmap.put("jihuashijian2", jihuashijian2);}		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuaneirong==null||jihuaneirong.equals("")){pmap.put("jihuaneirong", null);}else{pmap.put("jihuaneirong", jihuaneirong);}		
		
		int total=shijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shijianjihua> list=shijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shijianjihua_list2";
	}	
	
	@RequestMapping("sjjhList.do")
	public String sjjhList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shijianjihua shijianjihua, String xuehao, String xingming, String jihuashijian1,String jihuashijian2, String jihuamingcheng, String jihuaneirong){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(jihuashijian1==null||jihuashijian1.equals("")){pmap.put("jihuashijian1", null);}else{pmap.put("jihuashijian1", jihuashijian1);}		if(jihuashijian2==null||jihuashijian2.equals("")){pmap.put("jihuashijian2", null);}else{pmap.put("jihuashijian2", jihuashijian2);}		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuaneirong==null||jihuaneirong.equals("")){pmap.put("jihuaneirong", null);}else{pmap.put("jihuaneirong", jihuaneirong);}		
		int total=shijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shijianjihua> list=shijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shijianjihualist";
	}
	
	@RequestMapping("deleteShijianjihua.do")
	public String deleteShijianjihua(int id,HttpServletRequest request){
		shijianjihuaService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shijianjihuaList.do";
	}
	
	
}
