package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShijianjihuaMapper;
import com.entity.Shijianjihua;
import com.server.ShijianjihuaServer;
@Service
public class ShijianjihuaServerImpi implements ShijianjihuaServer {
   @Resource
   private ShijianjihuaMapper gdao;
	@Override
	public int add(Shijianjihua po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shijianjihua po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shijianjihua> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shijianjihua> getsyshijianjihua1(Map<String, Object> map) {
		return gdao.getsyshijianjihua1(map);
	}
	public List<Shijianjihua> getsyshijianjihua2(Map<String, Object> map) {
		return gdao.getsyshijianjihua2(map);
	}
	public List<Shijianjihua> getsyshijianjihua3(Map<String, Object> map) {
		return gdao.getsyshijianjihua3(map);
	}
	
	@Override
	public Shijianjihua quchongShijianjihua(Map<String, Object> account) {
		return gdao.quchongShijianjihua(account);
	}

	@Override
	public List<Shijianjihua> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shijianjihua> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shijianjihua getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

