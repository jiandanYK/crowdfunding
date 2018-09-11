package com.zhiyou.zc.dao;

import com.zhiyou.zc.entity.AdminUser;

public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
    
    public AdminUser getAdminUser(String name);
}