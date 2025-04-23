package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Caiwuliushui;

public interface CaiwuliushuiServer {

  public int add(Caiwuliushui po);

  public int update(Caiwuliushui po);
  
  
  
  public int delete(int id);

  public List<Caiwuliushui> getAll(Map<String,Object> map);
  public List<Caiwuliushui> getsycaiwuliushui1(Map<String,Object> map);
  public List<Caiwuliushui> getsycaiwuliushui2(Map<String,Object> map);
  public List<Caiwuliushui> getsycaiwuliushui3(Map<String,Object> map);
  public Caiwuliushui quchongCaiwuliushui(Map<String, Object> acount);

  public Caiwuliushui getById( int id);

  public List<Caiwuliushui> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Caiwuliushui> select(Map<String, Object> map);
}
//	所有List
