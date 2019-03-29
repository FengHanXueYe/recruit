package cn.kgc.tangcco.tcmp073.qizu.recruit.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.eb.service.EbService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.service.SelfdescriptionService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.service.WorksdisplayService;

/**
 * 许茂峰
 * @author jiangwu
 *
 */
@Controller
public class MainController {
	@Resource
	private EbService ebService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private SelfdescriptionService ss;
	
	@Resource
	private WorksdisplayService ws;
	
	@RequestMapping("toIndex")
	public String toIndex(Model model) {
		return "main/index";
	}
	
	/**
	 * 去简历页
	 * @param model
	 * @return
	 */
	@RequestMapping("toResume")
	public String toResume(HttpSession session,Model model) {
		RecruitingUsers attribute = (RecruitingUsers)session.getAttribute("loginUser");
		/*储存教育背景*/
		if(attribute!=null) {
			if(ebService.queryEducationalbackground(attribute.getUserid())!=null) {
				model.addAttribute("educationalbackground", ebService.queryEducationalbackground(attribute.getUserid()));
			}
			if(ss.querySelfdescription(attribute.getUserid()).getSdescription()!=null) {
				model.addAttribute("selfdescriptionModel",ss.querySelfdescription(attribute.getUserid()).getSdescription());
			}
			if(ws.queryWorksdisplay(attribute.getUserid())!=null) {
				model.addAttribute("worksdisplayMapperModel", ws.queryWorksdisplay(attribute.getUserid()));
			}
			System.out.println("-------------------------------");
			System.err.println(ws.queryWorksdisplay(attribute.getUserid()).getWlink());
			System.out.println("-------------------------------");
			//System.err.println(ss.querySelfdescription(attribute.getUserid()).getSdescription());
		}
		return "main/jianli";
	}
	/**
	 * 去登录页
	 * @param model
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin(Model model) {
		return "main/login";
	}
	/**
	 * 去注册页
	 * @param model
	 * @return
	 */
	@RequestMapping("toRegister")
	public String toRegister(Model model) {
		return "main/register";
	}
	/**
	 * 去找回密码页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toReset")
	public String toReset(Model model) {
		return "main/reset";
	}
	
	
	
}
