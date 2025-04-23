package com.entity;

public class Huodongjilu {
    private Integer id;
	private String xuehao;	private String xingming;	private String riqi;	private String jiaowangduixiang;	private String huodonghuafei;	private String huodongneirong;	
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
    }	public String getRiqi() {
        return riqi;
    }
    public void setRiqi(String riqi) {
        this.riqi = riqi == null ? null : riqi.trim();
    }	public String getJiaowangduixiang() {
        return jiaowangduixiang;
    }
    public void setJiaowangduixiang(String jiaowangduixiang) {
        this.jiaowangduixiang = jiaowangduixiang == null ? null : jiaowangduixiang.trim();
    }	public String getHuodonghuafei() {
        return huodonghuafei;
    }
    public void setHuodonghuafei(String huodonghuafei) {
        this.huodonghuafei = huodonghuafei == null ? null : huodonghuafei.trim();
    }	public String getHuodongneirong() {
        return huodongneirong;
    }
    public void setHuodongneirong(String huodongneirong) {
        this.huodongneirong = huodongneirong == null ? null : huodongneirong.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
