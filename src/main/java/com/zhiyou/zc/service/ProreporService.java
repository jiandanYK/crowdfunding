package com.zhiyou.zc.service;

import com.zhiyou.zc.entity.Proreport;

public interface ProreporService {
	int deleteByPrimaryKey(Integer rId);

    int insert(Proreport record);

    int insertSelective(Proreport record);

    Proreport selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Proreport record);

    int updateByPrimaryKey(Proreport record);
    
    int getMaxId();
}
