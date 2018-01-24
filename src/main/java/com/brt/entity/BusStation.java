package com.brt.entity;

import java.io.Serializable;

public class BusStation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 组织机构ID
	 */
	private Integer id;
	
	/**
	 * 车站编码
	 */
	private String stopcode;
	
	/**
	 * 排列循序
	 */
	private String ordernumber;
	
	/**
	 * 车站名称
	 */
	private String stopname;

	/**
	 * 名称简称
	 */
	private String nameforshort;

	/**
	 * 车站类型
	 */
	private String stoptype;

	/**
	 * 经度
	 */
	private String longitude;
	 
	/**
	 * 纬度
	 */
	private String latitude;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStopcode() {
		return stopcode;
	}

	public void setStopcode(String stopcode) {
		this.stopcode = stopcode;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getStopname() {
		return stopname;
	}

	public void setStopname(String stopname) {
		this.stopname = stopname;
	}

	public String getNameforshort() {
		return nameforshort;
	}

	public void setNameforshort(String nameforshort) {
		this.nameforshort = nameforshort;
	}

	public String getStoptype() {
		return stoptype;
	}

	public void setStoptype(String stoptype) {
		this.stoptype = stoptype;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}