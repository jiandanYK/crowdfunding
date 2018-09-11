package com.zhiyou.zc.service;

import com.zhiyou.zc.entity.Initiator;

public interface InitiatorService {

	int deleteByPrimaryKey(String iId);

    int insert(Initiator record);

    int insertSelective(Initiator record);

    Initiator selectByPrimaryKey(String iId);

    int updateByPrimaryKeySelective(Initiator record);

    int updateByPrimaryKey(Initiator record);
    
    Initiator getInitByName(String name);
}
