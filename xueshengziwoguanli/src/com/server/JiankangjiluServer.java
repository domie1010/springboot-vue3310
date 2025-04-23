package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiankangjilu;

public interface JiankangjiluServer {

  public int add(Jiankangjilu po);

  public int update(Jiankangjilu po);
  
  
  
  public int delete(int id);

  public List<Jiankangjilu> getAll(Map<String,Object> map);
  public List<Jiankangjilu> getsyjiankangjilu1(Map<String,Object> map);
  public List<Jiankangjilu> getsyjiankangjilu2(Map<String,Object> map);
  public List<Jiankangjilu> getsyjiankangjilu3(Map<String,Object> map);
  public Jiankangjilu quchongJiankangjilu(Map<String, Object> acount);

  public Jiankangjilu getById( int id);

  public List<Jiankangjilu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiankangjilu> select(Map<String, Object> map);
}
//	所有List
