package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xintaijilu;

public interface XintaijiluServer {

  public int add(Xintaijilu po);

  public int update(Xintaijilu po);
  
  
  
  public int delete(int id);

  public List<Xintaijilu> getAll(Map<String,Object> map);
  public List<Xintaijilu> getsyxintaijilu1(Map<String,Object> map);
  public List<Xintaijilu> getsyxintaijilu2(Map<String,Object> map);
  public List<Xintaijilu> getsyxintaijilu3(Map<String,Object> map);
  public Xintaijilu quchongXintaijilu(Map<String, Object> acount);

  public Xintaijilu getById( int id);

  public List<Xintaijilu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xintaijilu> select(Map<String, Object> map);
}
//	所有List
