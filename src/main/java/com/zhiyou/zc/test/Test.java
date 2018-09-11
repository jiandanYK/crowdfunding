package com.zhiyou.zc.test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhiyou.zc.dao.AdminUserMapper;

public class Test {

	private static AdminUserMapper am;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext cxt = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
		am = (AdminUserMapper) cxt.getBean("adminUserMapper");
		// AdminUser user = am.selectByPrimaryKey(1);
		// System.out.println("ID:"+user.getAdminId()+"–’√˚:"+user.getAdminName()+"√‹¬Î:"+user.getAdminPwd());
		// SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss");
		// String time = tempDate.format(new java.util.Date());

		// System.out.println(time);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(dateString, pos);
		System.out.println(date);

	}

}
