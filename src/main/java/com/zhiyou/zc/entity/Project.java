package com.zhiyou.zc.entity;

import java.util.Date;

public class Project {
    private Integer pId;

    private Integer pCid;

    private String pName;

    private String pUsername;

    private Integer pDid;

    private Integer pRid;

    private String pPlace;

    private Double pMoney;

    private Double pRaise;

    private Date pStime;

    private Date pEtime;

    private Integer pJoin;

    private String pCover;

    private String pState;
    
    private Proclass proclass;
    
    private String pAim;
    
    private Integer second;    
    
    public Integer getSecond() {
		return second;
	}

	public void setSecond(Integer second) {
		this.second = second;
	}

	public String getpAim() {
		return pAim;
	}

	public void setpAim(String pAim) {
		this.pAim = pAim;
	}

	public Proclass getProclass() {
		return proclass;
	}

	public void setProclass(Proclass proclass) {
		this.proclass = proclass;
	}

	public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getpCid() {
        return pCid;
    }

    public void setpCid(Integer pCid) {
        this.pCid = pCid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpUsername() {
        return pUsername;
    }

    public void setpUsername(String pUsername) {
        this.pUsername = pUsername;
    }

    public Integer getpDid() {
        return pDid;
    }

    public void setpDid(Integer pDid) {
        this.pDid = pDid;
    }

    public Integer getpRid() {
        return pRid;
    }

    public void setpRid(Integer pRid) {
        this.pRid = pRid;
    }

    public String getpPlace() {
        return pPlace;
    }

    public void setpPlace(String pPlace) {
        this.pPlace = pPlace;
    }

    public Double getpMoney() {
        return pMoney;
    }

    public void setpMoney(Double pMoney) {
        this.pMoney = pMoney;
    }

    public Double getpRaise() {
        return pRaise;
    }

    public void setpRaise(Double pRaise) {
        this.pRaise = pRaise;
    }

    public Date getpStime() {
        return pStime;
    }

    public void setpStime(Date pStime) {
        this.pStime = pStime;
    }

    public Date getpEtime() {
        return pEtime;
    }

    public void setpEtime(Date pEtime) {
        this.pEtime = pEtime;
    }

    public Integer getpJoin() {
        return pJoin;
    }

    public void setpJoin(Integer pJoin) {
        this.pJoin = pJoin;
    }

    public String getpCover() {
        return pCover;
    }

    public void setpCover(String pCover) {
        this.pCover = pCover;
    }

    public String getpState() {
        return pState;
    }

    public void setpState(String pState) {
        this.pState = pState;
    }
}