package cn.kgc.tangcco.tcmp073.qizu.recruit.company.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Product;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.utilEmail.CEmail;
import cn.kgc.tangcco.tcmp073.qizu.recruit.product.service.ProductService;


@Controller
public class CompanyController {
	@Resource
	private CompanyService service;
	@Resource
	private ProductService proservice;
	
	
	//跳转到公司页面
	@RequestMapping("tocompanlist")
	public String companylist() {

		return "main/companylist";
	}
	//跳转到公司注册页面
	@RequestMapping("toNavController")
	public String toNav(HttpSession session) {
		RecruitingUsers users=(RecruitingUsers) session.getAttribute("loginUser");
		Company comm=this.service.queryByUid(users.getUserid());
		if(comm==null) {
			return "main/bindstep1";
		}else {
			return "redirect:tomyhome.controller";
		}
		
	}
	
	@RequestMapping("AddCompanyOneController")
	public String AddCompanyOne(Company com,Model model,HttpSession session) {
		
		RecruitingUsers user=(RecruitingUsers) session.getAttribute("loginUser");
		com.setCuid(user.getUserid());
		int row=this.service.addCompanyOne(com);		
		model.addAttribute("company",this.service.queryByEmail(com.getCemail()));
		if(row>0) {
			return "main/bindStep2";
		}else {
			return "main/bindstep1";
		}
		
		
	}
	//123
	@RequestMapping("UpdateCNameController")
	public String updateCName(Company com,Model model,HttpSession session) {
		int row=this.service.updateCompany(com);
		if(row>0) {
			session.setAttribute("companys", this.service.queryByEmail(com.getCemail()));
			model.addAttribute("company2", this.service.queryByEmail(com.getCemail()));
			CEmail email=new CEmail();
			email.sendEamilCode(com.getCemail());
			
			return "main/bindStep3";
		}else {
			return "main/bindStep2";	
		}
	}
	@RequestMapping("toIndex01")
	public String toIndex01(Model model,Company com) {
		model.addAttribute("company", this.service.queryByEmail(com.getCemail()));
		return "main/index01";
	}	
//	
//	@RequestMapping("ajaxUpdateCompanyTwo")
//	public String  ajaxUpdateCompanyTwo(String cabbreviation,String curl,String caddress,String cfield,String cfs,String cdetail,String cemail,int cid) {
//		  System.out.println("+++++++++++++++++"+cabbreviation+curl+caddress+cfield+cfs+cdetail+cemail+cid);
//		 this.service.queryByEmail(cemail);
//		 int row=this.service.updateCompanyTwo(cabbreviation,curl,caddress,cfield,cfs,cdetail,cid);
//		
//			return "main/index02";
//		
//	}
	@RequestMapping("ajaxUpdateCompanyTwo")
	public String  ajaxUpdateCompanyTwo(Company com,Model model) {
		  int row=this.service.updateCompanyTwo(com.getCabbreviation(),com.getCurl(),com.getCaddress(),com.getCfield(),com.getCfs(),com.getCdetail(),com.getCscale(),com.getCid());
		  model.addAttribute("company",this.service.queryByEmail(com.getCemail()));
		  return "main/tag";
	}
	@RequestMapping("UpdateCompanyThree")
	public String UpdateCompanyThree(Company com,Model model) {
		model.addAttribute("company", this.service.queryByEmail(com.getCemail()));
		int row=this.service.updateCompanyThree(com.getCfinancing(), com.getCid());
		return "main/founder";
	}
	@RequestMapping("UpdateCompanyProfile")
	public String  updateCompanyProfile(String companyProfile,int cid) {
		int row=this.service.updateCompanyProfile(companyProfile, cid);
		if(row>0) {
		return "main/success";	
		}else {
		return "main/index03";
		}
	}
	
	//去公司主页1234
	@RequestMapping("tomyhome")
	public String tomyhome(HttpSession session,Model model) {
		RecruitingUsers user=(RecruitingUsers) session.getAttribute("loginUser");
		
		Company com=this.service.qyeryAllCompany(user.getUserid());
		String  tag=com.getCfinancing();
		String taglist[]=tag.split(",");
		model.addAttribute("taglist", taglist);
		model.addAttribute("listCompany",this.service.qyeryAllCompany(user.getUserid()));
		return "main/myhome";
	}
	//修改公司主页的产品
	@ResponseBody
	@RequestMapping("updateProductController")
	public Company updateProduct(Product pro,HttpSession session) {
		int row=this.proservice.updateProduct(pro);
		RecruitingUsers user=(RecruitingUsers) session.getAttribute("loginUser");
		return this.service.qyeryAllCompany(user.getUserid());
	}
	
	
	
}
