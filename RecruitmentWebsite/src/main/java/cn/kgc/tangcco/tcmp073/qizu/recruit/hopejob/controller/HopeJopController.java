package cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.HopeJob;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.entity.Worksdisplay;
import cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.mapper.HopeJobMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.service.HopeJobService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

@Controller
public class HopeJopController {

	@Resource
	private HopeJobService hopeJobService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("doAddUpdateHopeJon")
	public String doAddUpdateHopeJon(HopeJob hm,HttpSession session,Model model) {
		System.err.println("doAddUpdateHopeJon------"+hm);
		RecruitingUsers attribute = (RecruitingUsers)session.getAttribute("loginUser");
		
		HopeJob detailHopeJob = hopeJobService.detailHopeJob(attribute.getUserid());
		if(detailHopeJob==null) {
			hm.setHuserid(attribute.getUserid());
			hopeJobService.addHopeJob(hm);
		}else {
			hm.setHid(detailHopeJob.getHid());
			hopeJobService.updateHopeJob(hm);
		}
		/*修改时间*/
		userService.updateTime(attribute.getUserid());
		session.setAttribute("loginUser",userService.detailRecruitingUsers(attribute.getUserid()));
		return "redirect:toResume.controller";
	}
	
	
}
