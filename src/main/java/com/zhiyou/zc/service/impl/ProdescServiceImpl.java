package com.zhiyou.zc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.zc.dao.ProdescMapper;
import com.zhiyou.zc.entity.Prodesc;
import com.zhiyou.zc.service.ProdescService;
@Service
public class ProdescServiceImpl implements ProdescService {

	@Autowired
	private ProdescMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer dId) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(dId);
	}

	@Override
	public int insert(Prodesc record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Prodesc record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public Prodesc selectByPrimaryKey(Integer dId) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(dId);
	}

	@Override
	public int updateByPrimaryKeySelective(Prodesc record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Prodesc record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		return dao.getMaxId();
	}

}
