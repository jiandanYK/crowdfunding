package com.zhiyou.zc.dao;

import com.zhiyou.zc.entity.Initiator;

public interface InitiatorMapper {
    int deleteByPrimaryKey(String iId);

	int insert(Initiator record);

	int insertSelective(Initiator record);

	Initiator selectByPrimaryKey(String iId);

	int updateByPrimaryKeySelective(Initiator record);

	int updateByPrimaryKey(Initiator record);
	
    Initiator getInitByName(String name);
}