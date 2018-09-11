package com.zhiyou.zc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.zc.dao.ProreportMapper;
import com.zhiyou.zc.entity.Proreport;
import com.zhiyou.zc.service.ProreporService;
@Service
public class ProreporServiceImpl implements ProreporService {

	@Autowired
	private ProreportMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer rId) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(rId);
	}

	@Override
	public int insert(Proreport record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Proreport record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public Proreport selectByPrimaryKey(Integer rId) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(rId);
	}

	@Override
	public int updateByPrimaryKeySelective(Proreport record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Proreport record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		return dao.getMaxId();
	}

}
