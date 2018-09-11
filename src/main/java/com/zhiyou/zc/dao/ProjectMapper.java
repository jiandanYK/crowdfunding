package com.zhiyou.zc.dao;

import java.util.List;
import java.util.Map;

import com.zhiyou.zc.entity.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    
    List<Project> getSelectPage(Map<String, Object> map);
    
    int getPage(Map<String, Object> map);
    
    List<Project> getProByName(String uName);
    
    List<Project> getProByState1(String name);
    
    int getMaxId();
    
    //获取所有的project
    List<Project> getProAll();
    
    double getNowMoney();
    
    int getProCount();
    
    List<Project> getNewPro();
    
    //获取所有即将开始的项目
    List<Project> getProByState();
    
    //前台页面根据状态查询的分页和模糊查询
    int getPage1(Map<String, Object> map);
    
    List<Project> getSelectPage1(Map<String, Object> map);
    
    //教育助学的项目
    List<Project> getStuPro();
}