package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiankangjiluMapper;
import com.entity.Jiankangjilu;
import com.server.JiankangjiluServer;
@Service
public class JiankangjiluServerImpi implements JiankangjiluServer {
   @Resource
   private JiankangjiluMapper gdao;
	@Override
	public int add(Jiankangjilu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiankangjilu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiankangjilu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiankangjilu> getsyjiankangjilu1(Map<String, Object> map) {
		return gdao.getsyjiankangjilu1(map);
	}
	public List<Jiankangjilu> getsyjiankangjilu2(Map<String, Object> map) {
		return gdao.getsyjiankangjilu2(map);
	}
	public List<Jiankangjilu> getsyjiankangjilu3(Map<String, Object> map) {
		return gdao.getsyjiankangjilu3(map);
	}
	
	@Override
	public Jiankangjilu quchongJiankangjilu(Map<String, Object> account) {
		return gdao.quchongJiankangjilu(account);
	}

	@Override
	public List<Jiankangjilu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiankangjilu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiankangjilu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

