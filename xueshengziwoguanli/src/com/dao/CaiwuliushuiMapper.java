package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Caiwuliushui;

public interface CaiwuliushuiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Caiwuliushui record);

    int insertSelective(Caiwuliushui record);

    Caiwuliushui selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Caiwuliushui record);
	
    int updateByPrimaryKey(Caiwuliushui record);
	public Caiwuliushui quchongCaiwuliushui(Map<String, Object> xuehao);
	public List<Caiwuliushui> getAll(Map<String, Object> map);
	public List<Caiwuliushui> getsycaiwuliushui1(Map<String, Object> map);
	public List<Caiwuliushui> getsycaiwuliushui3(Map<String, Object> map);
	public List<Caiwuliushui> getsycaiwuliushui2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Caiwuliushui> getByPage(Map<String, Object> map);
	public List<Caiwuliushui> select(Map<String, Object> map);
//	所有List
}

