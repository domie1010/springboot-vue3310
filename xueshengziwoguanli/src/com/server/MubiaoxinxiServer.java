package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Mubiaoxinxi;

public interface MubiaoxinxiServer {

  public int add(Mubiaoxinxi po);

  public int update(Mubiaoxinxi po);
  
  
  
  public int delete(int id);

  public List<Mubiaoxinxi> getAll(Map<String,Object> map);
  public List<Mubiaoxinxi> getsymubiaoxinxi1(Map<String,Object> map);
  public List<Mubiaoxinxi> getsymubiaoxinxi2(Map<String,Object> map);
  public List<Mubiaoxinxi> getsymubiaoxinxi3(Map<String,Object> map);
  public Mubiaoxinxi quchongMubiaoxinxi(Map<String, Object> acount);

  public Mubiaoxinxi getById( int id);

  public List<Mubiaoxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Mubiaoxinxi> select(Map<String, Object> map);
}
//	所有List
