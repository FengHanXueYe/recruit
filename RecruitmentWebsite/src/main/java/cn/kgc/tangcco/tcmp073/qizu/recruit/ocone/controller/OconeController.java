package cn.kgc.tangcco.tcmp073.qizu.recruit.ocone.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.recruit.ocone.service.OconeService;

@Controller
public class OconeController {
	@Resource
	private OconeService oconeService;

	@RequestMapping("listOconeController")
	public String list(Model model) {
		model.addAttribute("listOcone", oconeService.queryType());
		return "main/index";
	}
}
