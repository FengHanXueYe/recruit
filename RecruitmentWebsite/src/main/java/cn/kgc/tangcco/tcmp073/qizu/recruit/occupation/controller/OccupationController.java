package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OccupationController {
	
	
	@RequestMapping("tocreate")
	public String tocreate() {
		return "main/create";
	}
	
	
	
	
	
	
	
	
	
}
