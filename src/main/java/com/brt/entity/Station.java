package com.brt.entity;

import java.io.Serializable;
import java.util.Date;

public class Station implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String code;
	private String name;
	private String nameforshort;
	private Integer obuid;
	private String parkingarea;
	private String ordernum;
	private String type;
	private String address;
	private String regioncode;
	private String streetcode;
	private String longitude;
	private String latitude;
	private String arrivalradius;
	private String departureradius;
	private String arrivalsoundfilename;
	private String arrivalvideofilename;
	private String departuresoundfilename;
	private String departvideofilename;
	private String instopledcmd;
	private String outstopledcmd;
	private String status;
	private String mileage;
	private Date createtime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameforshort() {
		return nameforshort;
	}
	public void setNameforshort(String nameforshort) {
		this.nameforshort = nameforshort;
	}
	public Integer getObuid() {
		return obuid;
	}
	public void setObuid(Integer obuid) {
		this.obuid = obuid;
	}
	public String getParkingarea() {
		return parkingarea;
	}
	public void setParkingarea(String parkingarea) {
		this.parkingarea = parkingarea;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegioncode() {
		return regioncode;
	}
	public void setRegioncode(String regioncode) {
		this.regioncode = regioncode;
	}
	public String getStreetcode() {
		return streetcode;
	}
	public void setStreetcode(String streetcode) {
		this.streetcode = streetcode;
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
	public String getArrivalradius() {
		return arrivalradius;
	}
	public void setArrivalradius(String arrivalradius) {
		this.arrivalradius = arrivalradius;
	}
	public String getDepartureradius() {
		return departureradius;
	}
	public void setDepartureradius(String departureradius) {
		this.departureradius = departureradius;
	}
	public String getArrivalsoundfilename() {
		return arrivalsoundfilename;
	}
	public void setArrivalsoundfilename(String arrivalsoundfilename) {
		this.arrivalsoundfilename = arrivalsoundfilename;
	}
	public String getArrivalvideofilename() {
		return arrivalvideofilename;
	}
	public void setArrivalvideofilename(String arrivalvideofilename) {
		this.arrivalvideofilename = arrivalvideofilename;
	}
	public String getDeparturesoundfilename() {
		return departuresoundfilename;
	}
	public void setDeparturesoundfilename(String departuresoundfilename) {
		this.departuresoundfilename = departuresoundfilename;
	}
	public String getDepartvideofilename() {
		return departvideofilename;
	}
	public void setDepartvideofilename(String departvideofilename) {
		this.departvideofilename = departvideofilename;
	}
	public String getInstopledcmd() {
		return instopledcmd;
	}
	public void setInstopledcmd(String instopledcmd) {
		this.instopledcmd = instopledcmd;
	}
	public String getOutstopledcmd() {
		return outstopledcmd;
	}
	public void setOutstopledcmd(String outstopledcmd) {
		this.outstopledcmd = outstopledcmd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}