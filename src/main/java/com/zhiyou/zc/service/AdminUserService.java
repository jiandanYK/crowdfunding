package com.zhiyou.zc.service;

import java.util.Map;

import com.zhiyou.zc.entity.AdminUser;

public interface AdminUserService {

	int deleteByPrimaryKey(Integer adminId);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
    
    //µÇÂ¼ÑéÖ¤
    public Map<String, Object> Login(String name,String pwd);
    
    
}
