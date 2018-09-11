package com.zhiyou.zc.dao;

import com.zhiyou.zc.entity.Prodesc;

public interface ProdescMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Prodesc record);

    int insertSelective(Prodesc record);

    Prodesc selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Prodesc record);

    int updateByPrimaryKey(Prodesc record);
    
    int getMaxId();
}