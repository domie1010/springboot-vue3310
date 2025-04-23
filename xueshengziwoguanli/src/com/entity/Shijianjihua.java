package com.entity;

public class Shijianjihua {
    private Integer id;
	private String xuehao;	private String xingming;	private String jihuashijian;	private String jihuamingcheng;	private String jihuaneirong;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getXuehao() {
        return xuehao;
    }
    public void setXuehao(String xuehao) {
        this.xuehao = xuehao == null ? null : xuehao.trim();
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }	public String getJihuashijian() {
        return jihuashijian;
    }
    public void setJihuashijian(String jihuashijian) {
        this.jihuashijian = jihuashijian == null ? null : jihuashijian.trim();
    }	public String getJihuamingcheng() {
        return jihuamingcheng;
    }
    public void setJihuamingcheng(String jihuamingcheng) {
        this.jihuamingcheng = jihuamingcheng == null ? null : jihuamingcheng.trim();
    }	public String getJihuaneirong() {
        return jihuaneirong;
    }
    public void setJihuaneirong(String jihuaneirong) {
        this.jihuaneirong = jihuaneirong == null ? null : jihuaneirong.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
