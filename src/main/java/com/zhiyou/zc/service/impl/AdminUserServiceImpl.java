package com.zhiyou.zc.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.zc.dao.AdminUserMapper;
import com.zhiyou.zc.entity.AdminUser;
import com.zhiyou.zc.service.AdminUserService;
@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer adminId) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(adminId);
	}

	@Override
	public int insert(AdminUser record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(AdminUser record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public AdminUser selectByPrimaryKey(Integer adminId) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(adminId);
	}

	@Override
	public int updateByPrimaryKeySelective(AdminUser record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AdminUser record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public Map<String, Object> Login(String name, String pwd) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 通过用户名先去验证对象是否存在
		AdminUser adminUser = dao.getAdminUser(name);
		if (adminUser == null) {
			// 表示没有这个用户
			map.put("error", "用户名不存在");
			map.put("isLogin", false);
		} else {
			// 存在
			if (pwd.equals(adminUser.getAdminPwd())) {
                //密码正确
				map.put("user", adminUser);
				map.put("isLogin", true);
			}else{
				map.put("error", "用户名或者密码不正确");
				map.put("isLogin", false);
			}
		}
		return map;
	}

}
