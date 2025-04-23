package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shijianjihua;

public interface ShijianjihuaServer {

  public int add(Shijianjihua po);

  public int update(Shijianjihua po);
  
  
  
  public int delete(int id);

  public List<Shijianjihua> getAll(Map<String,Object> map);
  public List<Shijianjihua> getsyshijianjihua1(Map<String,Object> map);
  public List<Shijianjihua> getsyshijianjihua2(Map<String,Object> map);
  public List<Shijianjihua> getsyshijianjihua3(Map<String,Object> map);
  public Shijianjihua quchongShijianjihua(Map<String, Object> acount);

  public Shijianjihua getById( int id);

  public List<Shijianjihua> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shijianjihua> select(Map<String, Object> map);
}
//	所有List
