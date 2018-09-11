package com.zhiyou.zc.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhiyou.zc.dao.ProjectMapper;
import com.zhiyou.zc.entity.Project;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext cxt=new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
		ProjectMapper dao = cxt.getBean(ProjectMapper.class);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("cName", null);
		map.put("pState", null);
		map.put("startRow",11);
		//int page = dao.getPage1(map);
		//System.out.println(page);
		List<Project> list=dao.getSelectPage1(map);
		System.out.println(list.size());
	}
}
