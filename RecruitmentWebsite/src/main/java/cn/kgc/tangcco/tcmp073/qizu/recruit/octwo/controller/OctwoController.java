package cn.kgc.tangcco.tcmp073.qizu.recruit.octwo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.recruit.octwo.service.OctwoService;

@Controller
public class OctwoController {
	@Resource
	private OctwoService octwoService;

	@RequestMapping("listOctwoController")
	public String list(Model model, Integer wid) {
		model.addAttribute("listOctwo",octwoService.queryGangwei(wid));
		return "main/index";
	}
}
