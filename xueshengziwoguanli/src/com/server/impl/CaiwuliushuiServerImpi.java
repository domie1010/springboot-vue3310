package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CaiwuliushuiMapper;
import com.entity.Caiwuliushui;
import com.server.CaiwuliushuiServer;
@Service
public class CaiwuliushuiServerImpi implements CaiwuliushuiServer {
   @Resource
   private CaiwuliushuiMapper gdao;
	@Override
	public int add(Caiwuliushui po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Caiwuliushui po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Caiwuliushui> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Caiwuliushui> getsycaiwuliushui1(Map<String, Object> map) {
		return gdao.getsycaiwuliushui1(map);
	}
	public List<Caiwuliushui> getsycaiwuliushui2(Map<String, Object> map) {
		return gdao.getsycaiwuliushui2(map);
	}
	public List<Caiwuliushui> getsycaiwuliushui3(Map<String, Object> map) {
		return gdao.getsycaiwuliushui3(map);
	}
	
	@Override
	public Caiwuliushui quchongCaiwuliushui(Map<String, Object> account) {
		return gdao.quchongCaiwuliushui(account);
	}

	@Override
	public List<Caiwuliushui> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Caiwuliushui> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Caiwuliushui getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

