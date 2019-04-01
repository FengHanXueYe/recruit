package cn.kgc.tangcco.tcmp073.qizu.recruit.founder.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Founder;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.founder.service.FounderService;

@Controller
public class FounderController {
	@Resource
	private FounderService service;
	@Resource
	private CompanyService comservice;
	@RequestMapping("doAddFounderController")
	public String addFounder(Founder founder,Model model,String cemail) {
		int row=this.service.addFounder(founder);
		
		if(row>0) {
			model.addAttribute("company",this.comservice.queryByEmail(cemail));
			return "main/index02";
		}else {
			return "main/founder";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
