package com.zhiyou.zc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.zc.entity.Initiator;
import com.zhiyou.zc.entity.Proclass;
import com.zhiyou.zc.entity.Project;
import com.zhiyou.zc.service.AdminUserService;
import com.zhiyou.zc.service.InitiatorService;
import com.zhiyou.zc.service.ProClassService;
import com.zhiyou.zc.service.ProjectService;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {

	@Autowired
	private AdminUserService aus;
	@Autowired
	private ProjectService ps;
	@Autowired
	private InitiatorService is;
	@Autowired
	private ProClassService pcs;

	// 登录验证
	@RequestMapping("/login")
	public String login(String u_name, String u_password, HttpServletRequest req, HttpSession session) {
		// System.out.println(u_name);
		Map<String, Object> map = aus.Login(u_name, u_password);
		// System.out.println(map.get("user"));
		boolean b = (Boolean) map.get("isLogin");
		if (b) {
			// 正确
			session.setAttribute("user", map.get("user"));
			return "forward:index";
		}
		req.setAttribute("error", map.get("error"));
		return "admin/admin_login";
	}

	@SuppressWarnings("unused")
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest req) {
		int count = ps.getProCount();
		req.setAttribute("count", count);
		Double money = ps.getNowMoney();
		if (money == null) {
			double m = 0.0;
			money = m;
		}
		req.setAttribute("money", money);
		/*
		 * List<Project> list=ps.getNewPro(); req.setAttribute("list", list);
		 */
		return "admin/index";
	}

	@RequestMapping("/getProAll")
	public String getPorAll(Integer pageIndex, String pName, String pUsername, String pState, String cName,
			HttpServletRequest req) {
		if (pageIndex == null) {
			pageIndex = 1;
		}

		if ("项目类型".equals(cName)) {
			cName = null;
		}

		if ("项目状态".equals(pState)) {
			pState = null;
		}

		System.out.println(pState + "    " + cName);
		System.out.println(req.getParameter("pName"));
		List<Project> list = ps.getSelectPage(pageIndex, pName, pUsername, pState, cName);
		System.out.println("===================" + list.size());
		req.setAttribute("pageIndex", pageIndex);
		req.setAttribute("list", list);
		req.setAttribute("pName", pName);
		req.setAttribute("pUsername", pUsername);
		req.setAttribute("pState", pState);
		req.setAttribute("cName", cName);
		req.setAttribute("page", ps.getPage(pName, pUsername, pState, cName));
		return "admin/products";
	}

	@RequestMapping("/toinfo")
	public String toinfo(Integer pId, String pUsername, HttpServletRequest req) {
		/* String name=req.getParameter("pUsername"); */
		Initiator init = is.getInitByName(pUsername);
		Project pro = ps.selectByPrimaryKey(pId);
		Long date = pro.getpEtime().getTime() - pro.getpStime().getTime();
		int time = (int) (date / (24 * 60 * 60 * 1000));
		req.setAttribute("time", time);
		req.setAttribute("p", pro);
		req.setAttribute("init", init);
		return "admin/product/product-info1";
	}

	@RequestMapping("/getProClassAll")
	public String getProClassAll(Integer pageIndex, HttpServletRequest req) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		List<Proclass> list = pcs.getSelectPage(pageIndex);
		System.out.println("===================" + list.size());
		req.setAttribute("pageIndex", pageIndex);
		req.setAttribute("list", list);
		req.setAttribute("page", pcs.getPage());
		return "admin/classify/all_classity";
	}

	@RequestMapping("/toAdd")
	public String toadd() {

		return "admin/classify/add_classity";
	}

	@RequestMapping("/add")
	public String add(Proclass pro) {
		pcs.insert(pro);
		return "forward:getProClassAll";
	}

	@RequestMapping("/del")
	public String del(Integer id) {
		pcs.deleteByPrimaryKey(id);
		return "forward:getProClassAll";
	}

	@RequestMapping("/update")
	public String update(Proclass pro) {
		System.out.println("******************" + pro);
		pcs.updateByPrimaryKey(pro);
		return "forward:getProClassAll";
	}

	// 转换时间格式(客户端传过来的字符串转换为时间格式)
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@ResponseBody
	@RequestMapping("/getProByTime")
	public List<Project> getProByTime() {
		List<Project> b = ps.getNewPro();
		System.out.println(b.size());
		System.out.println("================进来了");
		return b;
	}

	@RequestMapping("/doProAudit")
	public String doProAudit(HttpServletRequest req) {
		List<Project> list = ps.getProByState();
		req.setAttribute("list", list);
		return "admin/project_audit";
	}

	@RequestMapping("/toPass")
	public String toPass(Integer id, HttpServletRequest req) {
		Project pro = ps.selectByPrimaryKey(id);
		pro.setpState("众筹中");
		ps.updateByPrimaryKey(pro);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "审核状态成功");
		req.setAttribute("map", map);
		List<Project> list = ps.getProByState();
		req.setAttribute("list", list);
		return "admin/project_audit";
	}

	@RequestMapping("/toDel")
	public String toDel(Integer id, HttpServletRequest req) {
		Project pro = ps.selectByPrimaryKey(id);
		pro.setpState("众筹失败");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "审核状态成功");
		req.setAttribute("map", map);
		List<Project> list = ps.getProByState();
		req.setAttribute("list", list);
		return "admin/project_audit";
	}

}
