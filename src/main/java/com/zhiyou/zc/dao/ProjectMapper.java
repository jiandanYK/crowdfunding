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
    
    //��ȡ���е�project
    List<Project> getProAll();
    
    double getNowMoney();
    
    int getProCount();
    
    List<Project> getNewPro();
    
    //��ȡ���м�����ʼ����Ŀ
    List<Project> getProByState();
    
    //ǰ̨ҳ�����״̬��ѯ�ķ�ҳ��ģ����ѯ
    int getPage1(Map<String, Object> map);
    
    List<Project> getSelectPage1(Map<String, Object> map);
    
    //������ѧ����Ŀ
    List<Project> getStuPro();
}