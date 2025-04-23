package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Huodongjilu;

public interface HuodongjiluServer {

  public int add(Huodongjilu po);

  public int update(Huodongjilu po);
  
  
  
  public int delete(int id);

  public List<Huodongjilu> getAll(Map<String,Object> map);
  public List<Huodongjilu> getsyhuodongjilu1(Map<String,Object> map);
  public List<Huodongjilu> getsyhuodongjilu2(Map<String,Object> map);
  public List<Huodongjilu> getsyhuodongjilu3(Map<String,Object> map);
  public Huodongjilu quchongHuodongjilu(Map<String, Object> acount);

  public Huodongjilu getById( int id);

  public List<Huodongjilu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Huodongjilu> select(Map<String, Object> map);
}
//	所有List
