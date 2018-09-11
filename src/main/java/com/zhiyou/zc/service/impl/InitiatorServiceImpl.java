package com.zhiyou.zc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.zc.dao.InitiatorMapper;
import com.zhiyou.zc.entity.Initiator;
import com.zhiyou.zc.service.InitiatorService;
@Service
public class InitiatorServiceImpl implements InitiatorService {

	@Autowired
	private InitiatorMapper dao;
	@Override
	public int deleteByPrimaryKey(String iId) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(iId);
	}

	@Override
	public int insert(Initiator record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Initiator record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public Initiator selectByPrimaryKey(String iId) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(iId);
	}

	@Override
	public int updateByPrimaryKeySelective(Initiator record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Initiator record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public Initiator getInitByName(String name) {
		// TODO Auto-generated method stub
		return dao.getInitByName(name);
	}

}
