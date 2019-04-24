package cn.kgc.tangcco.tcmp073.qizu.recruit.backstage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackstageController {

	@RequestMapping("toBackstageIndex")
	public String toBackstageIndex(Model model) {
		
		return "backstage/index";
	}
	
}
