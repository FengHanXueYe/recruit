package cn.kgc.tangcco.tcmp073.qizu.recruit.product.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Product;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.product.service.ProductService;

@Controller

public class ProdictController {
	@Resource
	private ProductService service;
	@Resource
	private CompanyService comservice;
	@RequestMapping("doAddProductController")
	public String doAdd(Product pro,Model model,String cemail) {
		int row=this.service.addProduct(pro);
		if(row>0) {
			model.addAttribute("company",this.comservice.queryByEmail(cemail));
			return "main/index03";
		}else {
			return "main/index02";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
