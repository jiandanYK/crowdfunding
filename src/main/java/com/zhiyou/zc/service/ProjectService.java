package com.zhiyou.zc.service;

import java.util.List;
import java.util.Map;

import com.zhiyou.zc.entity.Project;

public interface ProjectService {
	
	int deleteByPrimaryKey(Integer pId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    
    List<Project> getSelectPage(Integer pageIndex, String pName,String pUsername,String pState,String cName);
    
    int getPage( String pName,String pUsername,String pState,String cName);

    List<Project> getProByName(String uName);
    
    List<Project> getProByState1(String name);
    
    int getMaxId();
    
    List<Project> getProAll();
    
    double getNowMoney();
    
    int getProCount();
    
    List<Project> getNewPro();
    
    List<Project> getProByState();
    
    List<Project> getSelectPage1(Integer pageIndex,String pState,String cName);
    
    int getPage1( String pState,String cName);
    
  //教育助学的项目
    List<Project> getStuPro();
}
