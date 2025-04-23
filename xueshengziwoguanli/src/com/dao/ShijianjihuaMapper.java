package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shijianjihua;

public interface ShijianjihuaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shijianjihua record);

    int insertSelective(Shijianjihua record);

    Shijianjihua selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shijianjihua record);
	
    int updateByPrimaryKey(Shijianjihua record);
	public Shijianjihua quchongShijianjihua(Map<String, Object> xuehao);
	public List<Shijianjihua> getAll(Map<String, Object> map);
	public List<Shijianjihua> getsyshijianjihua1(Map<String, Object> map);
	public List<Shijianjihua> getsyshijianjihua3(Map<String, Object> map);
	public List<Shijianjihua> getsyshijianjihua2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shijianjihua> getByPage(Map<String, Object> map);
	public List<Shijianjihua> select(Map<String, Object> map);
//	所有List
}

