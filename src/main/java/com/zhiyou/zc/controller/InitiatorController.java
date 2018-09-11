package com.zhiyou.zc.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zhiyou.zc.entity.Initiator;
import com.zhiyou.zc.entity.Proclass;
import com.zhiyou.zc.entity.Prodesc;
import com.zhiyou.zc.entity.Project;
import com.zhiyou.zc.entity.Proreport;
import com.zhiyou.zc.service.InitiatorService;
import com.zhiyou.zc.service.ProClassService;
import com.zhiyou.zc.service.ProdescService;
import com.zhiyou.zc.service.ProjectService;
import com.zhiyou.zc.service.ProreporService;

@Controller
@RequestMapping("/Initiator")
public class InitiatorController {

	@Autowired
	private InitiatorService is;
	@Autowired
	private ProjectService ps;
	@Autowired
	private ProClassService pcs;
	@Autowired
	private ProdescService pds;
	@Autowired
	private ProreporService prs;
	@RequestMapping("/addInitiator")
	public String addInitiator(Initiator initiator,String a,String b,HttpSession session){		
		initiator.setiAddress(a+b);
		System.out.println(initiator);		
		is.insert(initiator);
		session.setAttribute("initiator", initiator);
		return "redirect:/zhuan/to_new_info";	
		}
	
	@RequestMapping(value="/addPro",method=RequestMethod.POST)
	public String addPro(Project pro,String a,String b,Integer day,String id,HttpSession session,HttpServletRequest req){
		
		pro.setpPlace(a+b);
		//日期的处理
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dateString = formatter.format(currentTime);
		 ParsePosition pos = new ParsePosition(0);
		 Date date = formatter.parse(dateString, pos);
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//String enddate = format.format(d)+day;		
		pro.setpStime(date);
		Calendar ca=Calendar.getInstance();
		ca.add(Calendar.DATE, day);
		Date d2=ca.getTime();
		pro.setpEtime(d2);
		//id的处理
		int cid=pcs.getId(id);
		pro.setpCid(cid);
		System.out.println("****************************************开始照片处理");
		//上传照片的处理
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		//获得上传的文件对象 表单中name=file 得到当前文件
		MultipartFile file = mreq.getFile("file");
		String fileName = file.getOriginalFilename();
		//System.out.println("上传文件的名称:"+fileName);
		//创建simpledateformat对象
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		System.out.println(UUID.randomUUID().toString());//得到一个随机的很长数字
		//得到上传文件的后缀名称
		System.out.println("****************************************正在照片处理");
		String end = fileName.substring(fileName.lastIndexOf("."));
		ServletContext application = req.getSession().getServletContext();
		String path = application.getRealPath("/upload");
		System.out.println("服务器端的路径"+path);
		//文件上传
		OutputStream output;
		String  name=sdf.format(new Date())+end;
		try {
			output = new FileOutputStream(path+"/"+name);
			IOUtils.copy(file.getInputStream(), output);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pro.setpCover(name);
		//姓名的处理
		/*Initiator init=(Initiator) session.getAttribute("initiator");
		System.out.println("**********************************"+init.getiName());
		pro.setpUsername(init.getiName());*/
		ps.insert(pro);
		session.setAttribute("pro",pro);
		return "jsp/new_detail";
	}
	//项目详情
	@RequestMapping("/addProDesc")
	public String addProDesc(Prodesc prodesc,HttpSession session){
		session.setAttribute("prodesc", prodesc);
		pds.insert(prodesc);
		return "jsp/new_back";
	}
	//项目回报
	@RequestMapping("/addProReport")
	public String addProReport(Proreport proreport,HttpSession session){
		
		prs.insert(proreport);
		session.setAttribute("proreport",proreport );
		Project pro=(Project) session.getAttribute("pro");
		Prodesc prodesc=(Prodesc) session.getAttribute("prodesc");
		Initiator init=(Initiator) session.getAttribute("initiator");
		System.out.println("**********************************"+init.getiName());
		pro.setpUsername(init.getiName());
		
		int p_did=pds.getMaxId();
		pro.setpDid(p_did);
		
		int p_rid=prs.getMaxId();
		pro.setpRid(p_rid);
		
		int i_pid=ps.getMaxId();
		init.setiPid(i_pid);
		
		pro.setpState("即将开始");
		pro.setpId(i_pid);
		pro.setpRaise(0.0);
		pro.setpJoin(0);
		
		ps.updateByPrimaryKeySelective(pro);
		is.updateByPrimaryKey(init);
						
		session.removeAttribute("pro");
		session.removeAttribute("prodesc");
		session.removeAttribute("initiator");
		session.removeAttribute("proreport");
		return "redirect:/zhuan/toIndex";
	}
	
	//项目详情页
       @RequestMapping("/toProduct-detail")
	   public String toProductDetail(int id,HttpServletRequest req,HttpSession session){
			Project pro=ps.selectByPrimaryKey(id);
			Integer c_id=pro.getpCid();
			Proclass proclass = pcs.selectByPrimaryKey(c_id);
			String name=proclass.getcName();
			req.setAttribute("name", name);
			System.out.println(pro);
			req.setAttribute("p", pro);
			session.setAttribute("id", id);
			return "jsp/product-detail";
		}
       
       //开始捐钱 一块的
       @RequestMapping("/to-detail")
       public String todetail(HttpServletRequest req,HttpSession session){
    	   int p_id =  (Integer) session.getAttribute("id");
    	   Project pro=ps.selectByPrimaryKey(p_id);
    	   pro.setpRaise(pro.getpRaise()+1);
    	   pro.setpJoin(pro.getpJoin()+1);
    	   ps.updateByPrimaryKey(pro);
    	   req.setAttribute("p",pro);    	   
    	   return "jsp/product-detail";
       } 
       
       //开始捐钱 十块的
       @RequestMapping("/to-detail1")
       public String todetail1(HttpServletRequest req,HttpSession session){
    	   int p_id =  (Integer) session.getAttribute("id");
    	   Project pro=ps.selectByPrimaryKey(p_id);
    	   pro.setpRaise(pro.getpRaise()+10);
    	   pro.setpJoin(pro.getpJoin()+1);
    	   ps.updateByPrimaryKey(pro);
    	   req.setAttribute("p",pro);    	   
    	   return "jsp/product-detail";
       } 
       //开始捐钱 100
       @RequestMapping("/to-detail2")
       public String todetail2(HttpServletRequest req,HttpSession session){
    	   int p_id =  (Integer) session.getAttribute("id");
    	   Project pro=ps.selectByPrimaryKey(p_id);
    	   pro.setpRaise(pro.getpRaise()+100);
    	   pro.setpJoin(pro.getpJoin()+1);
    	   ps.updateByPrimaryKey(pro);
    	   req.setAttribute("p",pro);    	   
    	   return "jsp/product-detail";
       }
       //开始捐钱 200
       @RequestMapping("/to-detail3")
       public String todetail3(HttpServletRequest req,HttpSession session){
    	   int p_id =  (Integer) session.getAttribute("id");
    	   Project pro=ps.selectByPrimaryKey(p_id);
    	   pro.setpRaise(pro.getpRaise()+200);
    	   pro.setpJoin(pro.getpJoin()+1);
    	   ps.updateByPrimaryKey(pro);
    	   req.setAttribute("p",pro);    	   
    	   return "jsp/product-detail";
       }
       //开始捐钱 500
       @RequestMapping("/to-detail4")
       public String todetail4(HttpServletRequest req,HttpSession session){
    	   int p_id =  (Integer) session.getAttribute("id");
    	   Project pro=ps.selectByPrimaryKey(p_id);
    	   pro.setpRaise(pro.getpRaise()+500);
    	   pro.setpJoin(pro.getpJoin()+1);
    	   ps.updateByPrimaryKey(pro);
    	   req.setAttribute("p",pro);    	   
    	   return "jsp/product-detail";
       }
       //开始捐钱 1000
       @RequestMapping("/to-detail5")
       public String todetail5(HttpServletRequest req,HttpSession session){
    	   int p_id =  (Integer) session.getAttribute("id");
    	   Project pro=ps.selectByPrimaryKey(p_id);
    	   pro.setpRaise(pro.getpRaise()+1000);
    	   pro.setpJoin(pro.getpJoin()+1);
    	   ps.updateByPrimaryKey(pro);
    	   req.setAttribute("p",pro);    	   
    	   return "jsp/product-detail";
       }
       
}
