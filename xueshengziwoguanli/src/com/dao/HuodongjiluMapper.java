package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Huodongjilu;

public interface HuodongjiluMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huodongjilu record);

    int insertSelective(Huodongjilu record);

    Huodongjilu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huodongjilu record);
	
    int updateByPrimaryKey(Huodongjilu record);
	public Huodongjilu quchongHuodongjilu(Map<String, Object> xuehao);
	public List<Huodongjilu> getAll(Map<String, Object> map);
	public List<Huodongjilu> getsyhuodongjilu1(Map<String, Object> map);
	public List<Huodongjilu> getsyhuodongjilu3(Map<String, Object> map);
	public List<Huodongjilu> getsyhuodongjilu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Huodongjilu> getByPage(Map<String, Object> map);
	public List<Huodongjilu> select(Map<String, Object> map);
//	所有List
}

