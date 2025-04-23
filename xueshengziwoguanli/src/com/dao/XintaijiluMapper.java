package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xintaijilu;

public interface XintaijiluMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xintaijilu record);

    int insertSelective(Xintaijilu record);

    Xintaijilu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xintaijilu record);
	
    int updateByPrimaryKey(Xintaijilu record);
	public Xintaijilu quchongXintaijilu(Map<String, Object> xuehao);
	public List<Xintaijilu> getAll(Map<String, Object> map);
	public List<Xintaijilu> getsyxintaijilu1(Map<String, Object> map);
	public List<Xintaijilu> getsyxintaijilu3(Map<String, Object> map);
	public List<Xintaijilu> getsyxintaijilu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xintaijilu> getByPage(Map<String, Object> map);
	public List<Xintaijilu> select(Map<String, Object> map);
//	所有List
}

