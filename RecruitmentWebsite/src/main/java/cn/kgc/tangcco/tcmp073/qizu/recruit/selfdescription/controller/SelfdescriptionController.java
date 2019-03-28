package cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.entity.Selfdescription;
import cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.service.SelfdescriptionService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

@Controller
public class SelfdescriptionController {
	
	@Resource
	private SelfdescriptionService ss;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("doAddSelfdescription")
	public String doAddSelfdescription(Selfdescription sion,HttpSession session,Model model) {
		RecruitingUsers attribute = (RecruitingUsers)session.getAttribute("loginUser");
		Selfdescription querySelfdescription = ss.querySelfdescription(attribute.getUserid());
		sion.setSuserid(attribute.getUserid());
		if(querySelfdescription==null) {
			ss.addSelfdescription(sion);
		}else {
			sion.setSid(querySelfdescription.getSid());
			ss.updateSelfdescription(sion);
		}
		/*修改时间*/
		userService.updateTime(attribute.getUserid());
		session.setAttribute("loginUser",userService.detailRecruitingUsers(attribute.getUserid()));
		return "redirect:toResume.controller";
	}
	
	
	
	
}
