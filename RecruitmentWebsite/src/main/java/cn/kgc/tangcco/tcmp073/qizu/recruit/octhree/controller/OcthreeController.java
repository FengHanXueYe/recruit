package cn.kgc.tangcco.tcmp073.qizu.recruit.octhree.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.recruit.octhree.service.OcthreeService;

@Controller
public class OcthreeController {
	@Resource
	private OcthreeService octhreeService;

	@RequestMapping("listOcthreeController")
	public String list(Model model, int hid) {
		model.addAttribute("listOcthree", octhreeService.queryZhiwei(hid));
		return "main/index";
	}

	@RequestMapping("SuijiOcthreeController")
	public String Suiji(Model model, int hid) {
		model.addAttribute("SuijiOcthree", octhreeService.querySuiji(hid));
		return "main/index";
	}
}
