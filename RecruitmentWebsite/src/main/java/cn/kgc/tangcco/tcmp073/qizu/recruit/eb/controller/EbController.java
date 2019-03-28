package cn.kgc.tangcco.tcmp073.qizu.recruit.eb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Educationalbackground;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.eb.service.EbService;

@Controller
public class EbController {

	@Resource
	private EbService ebService;
	
	@RequestMapping("doAddEb")
	public String doAddEb(Educationalbackground eb,HttpSession session,Model model) {
		System.err.println("doAddEb-----"+eb);
		RecruitingUsers attribute = (RecruitingUsers)session.getAttribute("loginUser");
		Educationalbackground queryEducationalbackground = ebService.queryEducationalbackground(attribute.getUserid());
		eb.setPuserid(attribute.getUserid());
		if(queryEducationalbackground==null) {
			ebService.addEb(eb);
		}else {
			eb.setEid(queryEducationalbackground.getEid());
			ebService.updateEb(eb);
		}
		return "redirect:toResume.controller";
	}
	
	
	
	
	
	
}
