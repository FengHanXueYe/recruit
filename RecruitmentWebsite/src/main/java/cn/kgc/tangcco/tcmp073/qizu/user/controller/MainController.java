package cn.kgc.tangcco.tcmp073.qizu.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("toIndex")
	public String toIndex(Model model) {

		return "main/index";
	}
	
	
}
