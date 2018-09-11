package com.zhiyou.zc.dao;

import java.util.List;
import java.util.Map;

import com.zhiyou.zc.entity.Proclass;

public interface ProclassMapper {
    int deleteByPrimaryKey(Integer cId);

	int insert(Proclass record);

	int insertSelective(Proclass record);

	Proclass selectByPrimaryKey(Integer cId);

	int updateByPrimaryKeySelective(Proclass record);

	int updateByPrimaryKey(Proclass record);
    
    List<String> getProName();
    
    List<Proclass> getSelectPage(Map<String, Object> map);
    
    int getPage();
    
    int getId(String cName);
}