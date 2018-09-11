package com.zhiyou.zc.dao;

import com.zhiyou.zc.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int upState(String code);
    
    User selectUser(String name);
    
    User getUserByEmail(String uEmail);
}