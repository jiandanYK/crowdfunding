package com.zhiyou.zc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.zc.dao.ProjectMapper;
import com.zhiyou.zc.entity.Project;
import com.zhiyou.zc.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper dao;
	
	@Override
	public int deleteByPrimaryKey(Integer pId) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(pId);
	}

	@Override
	public int insert(Project record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Project record) {
		
		return dao.insertSelective(record);
	}

	@Override
	public Project selectByPrimaryKey(Integer pId) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(pId);
	}

	@Override
	public int updateByPrimaryKeySelective(Project record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Project record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}


	@Override
	public List<Project> getProByName(String uName) {
		// TODO Auto-generated method stub
		return dao.getProByName(uName);
	}

	@Override
	public List<Project> getProByState1(String name) {
		// TODO Auto-generated method stub
		return dao.getProByState1(name);
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		return dao.getMaxId();
	}

	@Override
	public List<Project> getProAll() {
		// TODO Auto-generated method stub
		return dao.getProAll();
	}

	@Override
	public double getNowMoney() {
		// TODO Auto-generated method stub
		return dao.getNowMoney();
	}

	@Override
	public int getProCount() {
		// TODO Auto-generated method stub
		return dao.getProCount();
	}

	@Override
	public List<Project> getNewPro() {
		// TODO Auto-generated method stub
		return dao.getNewPro();
	}

	@Override
	public List<Project> getProByState() {
		// TODO Auto-generated method stub
		return dao.getProByState();
	}

	@Override
	public List<Project> getSelectPage(Integer pageIndex, String pName,
			String pUsername, String pState, String cName) {
		Map<String, Object> map=new HashMap<String, Object>();
		int startRow=(pageIndex-1)*3;
		map.put("startRow",startRow);
		map.put("pName",pName );
		map.put("pUsername",pUsername );
		map.put("pState", pState);
		map.put("cName", cName);
		return dao.getSelectPage(map);
	}
	
	@Override
	public int getPage(String pName, String pUsername, String pState,
			String cName) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pName",pName );
		map.put("pUsername",pUsername );
		map.put("pState", pState);
		map.put("cName", cName);
		return dao.getPage(map)%3==0?dao.getPage(map)/3:dao.getPage(map)/3+1;
	}
	
	@Override
	public List<Project> getSelectPage1(Integer pageIndex, String pState,
			String cName) {
		Map<String, Object> map=new HashMap<String, Object>();
		int startRow=(pageIndex-1)*12;
		map.put("startRow",startRow);
		map.put("pState", pState);
		map.put("cName", cName);
		return dao.getSelectPage1(map);
	}

	@Override
	public int getPage1(String pState, String cName) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pState", pState);
		map.put("cName", cName);
		return dao.getPage1(map)%12==0?dao.getPage1(map)/12:dao.getPage1(map)/12+1;
	}

	@Override
	public List<Project> getStuPro() {
		// TODO Auto-generated method stub
		return dao.getStuPro();
	}

}
