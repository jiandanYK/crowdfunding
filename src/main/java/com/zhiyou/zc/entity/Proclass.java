package com.zhiyou.zc.entity;

import java.util.Date;

public class Proclass {
    private Integer cId;

	private String cName;

	private String cDesc;

	private Date cTime;

	private Integer cState;

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcDesc() {
		return cDesc;
	}

	public void setcDesc(String cDesc) {
		this.cDesc = cDesc;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public Integer getcState() {
		return cState;
	}

	public void setcState(Integer cState) {
		this.cState = cState;
	}

	public Proclass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proclass(Integer cId, String cName, String cDesc, Date cTime,
			Integer cState) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cDesc = cDesc;
		this.cTime = cTime;
		this.cState = cState;
	}

	@Override
	public String toString() {
		return "Proclass [cId=" + cId + ", cName=" + cName + ", cDesc=" + cDesc
				+ ", cTime=" + cTime + ", cState=" + cState + "]";
	}
	
}