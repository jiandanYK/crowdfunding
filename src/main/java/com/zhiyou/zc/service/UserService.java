package com.zhiyou.zc.service;

import java.util.Map;

import com.zhiyou.zc.entity.User;

public interface UserService {

	int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int upState(String code);
    
    User selectUser(String name);
    
    Map<String, Object> login(String uEmail,String uPwd ); 
    
    User getUserByEmail(String uEmail);
    
}
