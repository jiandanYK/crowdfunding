package com.zhiyou.zc.service;

import com.zhiyou.zc.entity.Prodesc;

public interface ProdescService {
	int deleteByPrimaryKey(Integer dId);

    int insert(Prodesc record);

    int insertSelective(Prodesc record);

    Prodesc selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Prodesc record);

    int updateByPrimaryKey(Prodesc record);
    
    int getMaxId();
}
