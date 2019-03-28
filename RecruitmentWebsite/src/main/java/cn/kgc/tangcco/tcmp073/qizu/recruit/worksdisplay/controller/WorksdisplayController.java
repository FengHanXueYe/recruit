package cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.entity.Worksdisplay;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.service.WorksdisplayService;

@Controller
public class WorksdisplayController {

	@Resource
	private WorksdisplayService ws;
	
	@Resource
	private UserService userService;
	
	/**
	 * 增加 修改展示作品
	 * @param wd
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doAddUpdateWorksdisplay")
	public String doAddUpdateWorksdisplay(Worksdisplay wd,HttpSession session,Model model) {
		System.err.println("doAddUpdateWorksdisplay------"+wd);
		RecruitingUsers attribute = (RecruitingUsers)session.getAttribute("loginUser");
		Worksdisplay queryWorksdisplay = ws.queryWorksdisplay(attribute.getUserid());
		if(queryWorksdisplay==null) {
			wd.setWuserid(attribute.getUserid());
			ws.addWorksdisplay(wd);
		}else {
			wd.setWuserid(queryWorksdisplay.getWid());
			ws.updateWorksdisplay(wd);
		}
		/*修改时间*/
		userService.updateTime(attribute.getUserid());
		session.setAttribute("loginUser",userService.detailRecruitingUsers(attribute.getUserid()));
		return "redirect:toResume.controller";
	}
	
}
