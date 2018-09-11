package com.zhiyou.zc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.zc.dao.ProclassMapper;
import com.zhiyou.zc.entity.Proclass;

import com.zhiyou.zc.service.ProClassService;
@Service
public class ProClassServiceImpl implements ProClassService {
 
	@Autowired
	private ProclassMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer cId) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(cId);
	}

	@Override
	public int insert(Proclass record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Proclass record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public Proclass selectByPrimaryKey(Integer cId) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(cId);
	}

	@Override
	public int updateByPrimaryKeySelective(Proclass record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Proclass record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}
	
	@Override
	public List<Proclass> getSelectPage(Integer pageIndex) {
		Map<String, Object> map=new HashMap<String, Object>();
		int startRow=(pageIndex-1)*3;
		map.put("startRow",startRow);
		return dao.getSelectPage(map);
	}

	@Override
	public int getPage() {
		
		return dao.getPage()%3==0?dao.getPage()/3:dao.getPage()/3+1;
	}

	@Override
	public List<String> getProName() {
		// TODO Auto-generated method stub
		return dao.getProName();
	}

	@Override
	public int getId(String cName) {
		// TODO Auto-generated method stub
		return dao.getId(cName);
	}


}
