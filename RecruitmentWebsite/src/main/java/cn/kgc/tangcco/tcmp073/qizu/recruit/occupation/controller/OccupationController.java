package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OccupationController {
	
	
	@RequestMapping("tocreate")
	public String tocreate() {
		return "main/create";
	}
	
	/**
	 * 跳转投递职位页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toToudi")
	public String toToudi(Model model) {
		return "main/toudi";
	}
	
	
	
	
	
	
	
}
