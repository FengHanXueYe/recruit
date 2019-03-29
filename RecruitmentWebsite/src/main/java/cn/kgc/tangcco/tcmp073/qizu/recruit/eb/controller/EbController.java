package cn.kgc.tangcco.tcmp073.qizu.recruit.eb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Educationalbackground;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.eb.service.EbService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

@Controller
public class EbController {

	@Resource
	private EbService ebService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("doAddEb")
	public String doAddEb(Educationalbackground eb,HttpSession session,Model model) {
		System.err.println("doAddEb-----"+eb);
		RecruitingUsers attribute = (RecruitingUsers)session.getAttribute("loginUser");
		Educationalbackground queryEducationalbackground = ebService.queryEducationalbackground(attribute.getUserid());
		System.out.println("----------->"+queryEducationalbackground);
		eb.setPuserid(attribute.getUserid());
		if(queryEducationalbackground==null) {
			ebService.addEb(eb);
		}else {
			eb.setEid(queryEducationalbackground.getEid());
			ebService.updateEb(eb);
		}
		/*修改时间*/
		userService.updateTime(attribute.getUserid());
		session.setAttribute("loginUser",userService.detailRecruitingUsers(attribute.getUserid()));
		return "redirect:toResume.controller";
	}

	

	
	
	
	
	
	
}
