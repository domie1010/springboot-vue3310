package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Mubiaoxinxi;

public interface MubiaoxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mubiaoxinxi record);

    int insertSelective(Mubiaoxinxi record);

    Mubiaoxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mubiaoxinxi record);
	
    int updateByPrimaryKey(Mubiaoxinxi record);
	public Mubiaoxinxi quchongMubiaoxinxi(Map<String, Object> xuehao);
	public List<Mubiaoxinxi> getAll(Map<String, Object> map);
	public List<Mubiaoxinxi> getsymubiaoxinxi1(Map<String, Object> map);
	public List<Mubiaoxinxi> getsymubiaoxinxi3(Map<String, Object> map);
	public List<Mubiaoxinxi> getsymubiaoxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Mubiaoxinxi> getByPage(Map<String, Object> map);
	public List<Mubiaoxinxi> select(Map<String, Object> map);
//	所有List
}

