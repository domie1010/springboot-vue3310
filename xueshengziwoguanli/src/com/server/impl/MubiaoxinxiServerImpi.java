package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.MubiaoxinxiMapper;
import com.entity.Mubiaoxinxi;
import com.server.MubiaoxinxiServer;
@Service
public class MubiaoxinxiServerImpi implements MubiaoxinxiServer {
   @Resource
   private MubiaoxinxiMapper gdao;
	@Override
	public int add(Mubiaoxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Mubiaoxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Mubiaoxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Mubiaoxinxi> getsymubiaoxinxi1(Map<String, Object> map) {
		return gdao.getsymubiaoxinxi1(map);
	}
	public List<Mubiaoxinxi> getsymubiaoxinxi2(Map<String, Object> map) {
		return gdao.getsymubiaoxinxi2(map);
	}
	public List<Mubiaoxinxi> getsymubiaoxinxi3(Map<String, Object> map) {
		return gdao.getsymubiaoxinxi3(map);
	}
	
	@Override
	public Mubiaoxinxi quchongMubiaoxinxi(Map<String, Object> account) {
		return gdao.quchongMubiaoxinxi(account);
	}

	@Override
	public List<Mubiaoxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Mubiaoxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Mubiaoxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

