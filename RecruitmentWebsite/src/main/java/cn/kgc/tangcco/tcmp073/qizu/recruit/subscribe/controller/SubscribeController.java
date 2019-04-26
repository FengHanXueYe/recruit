package cn.kgc.tangcco.tcmp073.qizu.recruit.subscribe.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.entity.Subscribe;
import cn.kgc.tangcco.tcmp073.qizu.recruit.subscribe.service.SubscribeService;


@Controller
public class SubscribeController {
	
	@Resource
	private SubscribeService subservice;
	
	@RequestMapping("toListsubscribe.controller")
	public String toadd() {
		return "main/subscribe";
	}
	
	
	@RequestMapping("doListsubscribe.controller")
	public String doadd(Subscribe sub,HttpSession session) {
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		sub.setSuserid(attribute.getUserid());
		this.subservice.addsubscribe(sub);
		return "redirect:listqueryscribe.controller";
	}
	
	@RequestMapping("listqueryscribe")
	public String query(Integer id,HttpSession session, Model model) {
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		List<Subscribe> query=subservice.detailquery(attribute.getUserid());
		System.err.println(query);
		model.addAttribute("subquery", query);
		return "main/subscribe01";
		
	}

}
