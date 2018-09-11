package com.zhiyou.zc.service;

import java.util.List;
import java.util.Map;

import com.zhiyou.zc.entity.Proclass;
import com.zhiyou.zc.entity.Project;

public interface ProClassService {
	
	int deleteByPrimaryKey(Integer cId);

	int insert(Proclass record);

	int insertSelective(Proclass record);

	Proclass selectByPrimaryKey(Integer cId);

	int updateByPrimaryKeySelective(Proclass record);

	int updateByPrimaryKey(Proclass record);
    
    List<Proclass> getSelectPage(Integer pageIndex);
    
    int getPage();
    
    List<String> getProName();
    
    int getId(String cName);
}
