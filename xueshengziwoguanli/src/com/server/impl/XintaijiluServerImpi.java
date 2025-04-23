package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XintaijiluMapper;
import com.entity.Xintaijilu;
import com.server.XintaijiluServer;
@Service
public class XintaijiluServerImpi implements XintaijiluServer {
   @Resource
   private XintaijiluMapper gdao;
	@Override
	public int add(Xintaijilu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xintaijilu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xintaijilu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xintaijilu> getsyxintaijilu1(Map<String, Object> map) {
		return gdao.getsyxintaijilu1(map);
	}
	public List<Xintaijilu> getsyxintaijilu2(Map<String, Object> map) {
		return gdao.getsyxintaijilu2(map);
	}
	public List<Xintaijilu> getsyxintaijilu3(Map<String, Object> map) {
		return gdao.getsyxintaijilu3(map);
	}
	
	@Override
	public Xintaijilu quchongXintaijilu(Map<String, Object> account) {
		return gdao.quchongXintaijilu(account);
	}

	@Override
	public List<Xintaijilu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xintaijilu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xintaijilu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

