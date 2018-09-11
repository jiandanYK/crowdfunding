package com.zhiyou.zc.entity;

public class Initiator {
    private String iId;

	private String iName;

	private Integer iPid;

	private String iPhone;

	private String iPname;

	private String iPtel;

	private String iAddress;


	public String getiId() {
		return iId;
	}

	public void setiId(String iId) {
		this.iId = iId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public Integer getiPid() {
		return iPid;
	}

	public void setiPid(Integer iPid) {
		this.iPid = iPid;
	}

	public String getiPhone() {
		return iPhone;
	}

	public void setiPhone(String iPhone) {
		this.iPhone = iPhone;
	}

	public String getiPname() {
		return iPname;
	}

	public void setiPname(String iPname) {
		this.iPname = iPname;
	}

	public String getiPtel() {
		return iPtel;
	}

	public void setiPtel(String iPtel) {
		this.iPtel = iPtel;
	}

	public String getiAddress() {
		return iAddress;
	}

	public void setiAddress(String iAddress) {
		this.iAddress = iAddress;
	}


	public Initiator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Initiator(String iId, String iName, Integer iPid, String iPhone,
			String iPname, String iPtel, String iAddress) {
		super();
		this.iId = iId;
		this.iName = iName;
		this.iPid = iPid;
		this.iPhone = iPhone;
		this.iPname = iPname;
		this.iPtel = iPtel;
		this.iAddress = iAddress;
		
	}

	@Override
	public String toString() {
		return "Initiator [iId=" + iId + ", iName=" + iName + ", iPid=" + iPid
				+ ", iPhone=" + iPhone + ", iPname=" + iPname + ", iPtel="
				+ iPtel + ", iAddress=" + iAddress + "]";
	}
}