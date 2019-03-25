package cn.kgc.tangcco.tcmp073.qizu.recruit.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyController {
	
	//跳转到公司页面
	@RequestMapping("tocompanlist")
	public String companylist() {

		return "main/companylist";
	}
	
	
	
	
	
	
	
	
	
	
}
