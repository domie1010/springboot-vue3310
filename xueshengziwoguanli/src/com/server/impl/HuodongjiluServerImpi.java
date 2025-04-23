package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HuodongjiluMapper;
import com.entity.Huodongjilu;
import com.server.HuodongjiluServer;
@Service
public class HuodongjiluServerImpi implements HuodongjiluServer {
   @Resource
   private HuodongjiluMapper gdao;
	@Override
	public int add(Huodongjilu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Huodongjilu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Huodongjilu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Huodongjilu> getsyhuodongjilu1(Map<String, Object> map) {
		return gdao.getsyhuodongjilu1(map);
	}
	public List<Huodongjilu> getsyhuodongjilu2(Map<String, Object> map) {
		return gdao.getsyhuodongjilu2(map);
	}
	public List<Huodongjilu> getsyhuodongjilu3(Map<String, Object> map) {
		return gdao.getsyhuodongjilu3(map);
	}
	
	@Override
	public Huodongjilu quchongHuodongjilu(Map<String, Object> account) {
		return gdao.quchongHuodongjilu(account);
	}

	@Override
	public List<Huodongjilu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Huodongjilu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Huodongjilu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

