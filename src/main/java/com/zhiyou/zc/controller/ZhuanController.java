package com.zhiyou.zc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.zc.entity.Project;
import com.zhiyou.zc.service.ProClassService;
import com.zhiyou.zc.service.ProjectService;

@Controller
@RequestMapping("/zhuan")
public class ZhuanController {

	@Autowired
	private ProClassService pcs;
	@Autowired
	private ProjectService ps;

	@RequestMapping("/admin_out")
	public String adminout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/index.jsp";
	}
	@RequestMapping("/out")
	public String out(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/index.jsp";
	}
	@RequestMapping("/toIndex1")
	public String toIndex1(){
		
		return "admin/index";
	}
	@RequestMapping("/toLogin")
	public String toLogin() {

		return "admin/admin_login";
	}

	@RequestMapping("/toProducts")
	public String toProducts() {
		return "admin/products";
	}

	@RequestMapping("/toProduct_info1")
	public String toProduct_info1() {
		return "admin/product/toproduct-info1";
	}

	// 去首页的方法
	@RequestMapping("/toIndex")
	public String toIndex(HttpServletRequest req) {
		List<Project> list = ps.getProAll();
		req.setAttribute("list", list);
		List<Project> stu=ps.getStuPro();
		System.out.println(stu.size()+"教育助学个数****************************");
		req.setAttribute("stu", stu);
		return "jsp/index";
	}

	@RequestMapping("/reg")
	public String reg() {

		return "jsp/reg";
	}

	@RequestMapping("/userLogin")
	public String toLogin1() {

		return "jsp/login";
	}

	@RequestMapping("/to_new_info")
	public String toNewInfo(HttpServletRequest req) {
		List<String> list = pcs.getProName();
		System.out.println("======================" + list.size());
		req.setAttribute("list", list);
		return "jsp/new_info";
	}

	@RequestMapping("/to_new_product")
	public String tonewproduct() {
		return "jsp/new_product";
	}

	@RequestMapping("/to_new_detail")
	public String to_new_detail() {
		return "jsp/new_detail";
	}

	@RequestMapping("/to_new_back")
	public String to_new_back() {
		return "jsp/new_back";
	}

	// 去公益众筹的页面
	@RequestMapping("/to_gyzc-list")
	public String togyzclist(Integer pageIndex,String pState,String cName,HttpServletRequest req) {
		if(pageIndex==null){
			pageIndex=1;
		}
		if("全部".equals(pState)){
			pState=null;
		}
		
		if("全部".equals(cName)){
			cName=null;
		}
		
		List<Project> list = ps.getSelectPage1(pageIndex, pState, cName);
		System.out.println("条数:"+list.size());
		req.setAttribute("pageIndex",pageIndex );
		req.setAttribute("list",list );
		
		req.setAttribute("pState",pState );
		req.setAttribute("cName",cName );		
		req.setAttribute("page", ps.getPage1(pState, cName));		
		return "jsp/gyzc-list";
	}

	@RequestMapping("/to_cop")
	public String to_cop() {
		return "jsp/cop";
	}

	@RequestMapping("/to_ly-list")
	public String to_lylist() {
		return "jsp/ly-list";
	}

	@RequestMapping("/to_user")
	public String to_user() {
		return "jsp/user";
	}
	
}
