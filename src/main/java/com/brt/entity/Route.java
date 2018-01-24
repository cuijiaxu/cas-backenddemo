package com.brt.entity;

import java.io.Serializable;
import java.util.Date;

public class Route implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String routecode;
	private Integer companyid;
	private String routeflag;
	private String deleted;
	private String useful;
	private String busnummin;
	private String busnumeffect;
	private Integer tripnum;
	private Date createtime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoutecode() {
		return routecode;
	}
	public void setRoutecode(String routecode) {
		this.routecode = routecode;
	}
	public Integer getCompanyid() {
		return companyid;
	}
	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}
	public String getRouteflag() {
		return routeflag;
	}
	public void setRouteflag(String routeflag) {
		this.routeflag = routeflag;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getUseful() {
		return useful;
	}
	public void setUseful(String useful) {
		this.useful = useful;
	}
	public String getBusnummin() {
		return busnummin;
	}
	public void setBusnummin(String busnummin) {
		this.busnummin = busnummin;
	}
	public String getBusnumeffect() {
		return busnumeffect;
	}
	public void setBusnumeffect(String busnumeffect) {
		this.busnumeffect = busnumeffect;
	}
	public Integer getTripnum() {
		return tripnum;
	}
	public void setTripnum(Integer tripnum) {
		this.tripnum = tripnum;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}