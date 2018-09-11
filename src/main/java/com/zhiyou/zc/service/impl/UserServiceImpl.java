package com.zhiyou.zc.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.zc.dao.UserMapper;
import com.zhiyou.zc.entity.User;
import com.zhiyou.zc.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer uId) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(uId);
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer uId) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(uId);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int upState(String code) {
		// TODO Auto-generated method stub
		return dao.upState(code);
	}

	@Override
	public User selectUser(String name) {
		// TODO Auto-generated method stub
		return dao.selectUser(name);
	}
 
	@Override
	public Map<String, Object> login(String uEmail, String uPwd) {
		User user=dao.getUserByEmail(uEmail);
		Map<String, Object> map=new HashMap<String, Object>();
		if(user==null){
			map.put("error", "用户不存在");
			map.put("isLogin", false);	
		}else{
			if(uPwd.equals(user.getuPwd())){
				map.put("user", user);
				map.put("isLogin", true);
			}else{
				map.put("isLogin", false);
				map.put("error", "密码错误");
			}			
		}
		return map;
	}

	@Override
	public User getUserByEmail(String uEmail) {
		// TODO Auto-generated method stub
		return dao.getUserByEmail(uEmail);
	}

}
