package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiankangjilu;

public interface JiankangjiluMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiankangjilu record);

    int insertSelective(Jiankangjilu record);

    Jiankangjilu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiankangjilu record);
	
    int updateByPrimaryKey(Jiankangjilu record);
	public Jiankangjilu quchongJiankangjilu(Map<String, Object> xuehao);
	public List<Jiankangjilu> getAll(Map<String, Object> map);
	public List<Jiankangjilu> getsyjiankangjilu1(Map<String, Object> map);
	public List<Jiankangjilu> getsyjiankangjilu3(Map<String, Object> map);
	public List<Jiankangjilu> getsyjiankangjilu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiankangjilu> getByPage(Map<String, Object> map);
	public List<Jiankangjilu> select(Map<String, Object> map);
//	所有List
}

