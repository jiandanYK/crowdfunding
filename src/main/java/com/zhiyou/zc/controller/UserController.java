package com.zhiyou.zc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;
import com.zhiyou.zc.entity.Project;
import com.zhiyou.zc.entity.User;
import com.zhiyou.zc.service.ProjectService;
import com.zhiyou.zc.service.UserService;
import com.zhiyou.zc.util.CodeUtil;
import com.zhiyou.zc.util.MailUtil;
import com.zhiyou.zc.util.SMSUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;
	@Autowired
	private ProjectService ps;
	@RequestMapping("/reg")
	public String reg(User user,HttpServletRequest req){
		
		if(!user.getuEmail().matches("^\\w+@(\\w+\\.)+\\w+$")){
			//生成激活码
			return "jsp/reg";
			/*String code=CodeUtil.generateUniqueCode();*/
		}
		//生成激活码
		String code=CodeUtil.generateUniqueCode();
		user.setuCode(code);
		user.setuState(0);
		int num=us.insertSelective(user);
		if(num>0){			
			new Thread(new MailUtil(user.getuEmail(), code)).start();
			return "jsp/login";
		}		
		return "jsp/reg";
	}
	
	//激活
	@RequestMapping("jihuo")
	public String jihuo(String code,HttpServletRequest req){
		int num1=us.upState(code);
		if(num1>0){
			req.setAttribute("error", "激活成功");
			return "jsp/index";
		}		
		req.setAttribute("error", "激活失败");
		return "jsp/index";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin(String uEmail,String uPwd,HttpServletRequest req,HttpSession session){
		Map<String, Object> map=us.login(uEmail, uPwd);
		boolean flag=(Boolean) map.get("isLogin");
		if(flag){
			//req.setAttribute("user", map.get("user"));
			List<Project> stu=ps.getStuPro();
			System.out.println(stu.size()+"教育助学个数****************************");
			req.setAttribute("stu", stu);
			session.setAttribute("user", map.get("user"));
			return "jsp/index";
		}else{
			req.setAttribute("error", map.get("error"));
			//转发回登陆页面
			return "jsp/login";
		}
		
	}
	
	@RequestMapping("/toAjax")
	public void ajax(String name,HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=null;
		try {
			out=resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		User user=us.selectUser(name);
		String name1="";
		if(user!=null){
			 name1="该用户名已存在！！！";
		}else{
			name1=""; 
		}
		//System.out.println("ajax的方法执行了");
		//输出名称,中文是否乱码
		//out.print(name);
		out.write(name1);
	}
	
	//短信注册
	@RequestMapping("/getCode")
	public void getCode(String tel,HttpServletRequest request){
		System.out.println(tel);
		//获取tel
		//生成验证码
		String [] codes={"0","1","2","3","4","5","6","7","8","9"};
		//生成一个6位数的验证码
		String code="";
		for(int i=0;i<6;i++){
			int j=(int)(Math.random()*10);
			code+=codes[j];
		}
		
		//调用方法
		try {
			SMSUtil.sendSms(tel, code);			
			//把code放到session里，并设置有限期
			HttpSession session=request.getSession();
			session.setAttribute("code", code);
			//设置有效时间
			session.setMaxInactiveInterval(10*60);			
			//return "200";
			System.out.println("....................");
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return "400";
		}
		
	}
	
	@RequestMapping("/togo")
	public String  togo(User user,HttpServletRequest request,HttpSession session){
		//比较两次的验证码是否中正
		String code1 = (String) session.getAttribute("code");
		System.out.println("session中的："+code1);
		//用户输入的
		String code2 = user.getuCode();
		System.out.println("用户输入的:"+code2);
		if(code1.equals(code2)){
			//添加
			us.insert(user);
			return "jsp/login";
		}
		return "jsp/reg";
	}
	
	@RequestMapping("/to_user")
	public String to_user(HttpServletRequest req,HttpSession session){
		//User user=(User) session.getAttribute("user");
		String name=req.getParameter("uName");
		List<Project> list=ps.getProByName(name);
		req.setAttribute("list", list);
	    List<Project> pros=ps.getProByState1(name);
	    req.setAttribute("pros", pros);
	    //req.setAttribute("user", user);
	    return "jsp/user";
	}
	
	@RequestMapping("/to_update")
	public String toupdate(HttpServletRequest req,HttpSession session){
		User user=(User) session.getAttribute("user");
		req.setAttribute("user", user);
		System.out.println("******************************");
		return "jsp/update-user";
	}
	
	@RequestMapping("/update")
	public String update(User user){
		
		us.updateByPrimaryKeySelective(user);
		
		return "forward:/user/to_user";
	}
}
