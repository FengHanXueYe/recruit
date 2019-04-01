package cn.kgc.tangcco.tcmp073.qizu.recruit.project.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Educationalbackground;
import cn.kgc.tangcco.tcmp073.qizu.entity.Project;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.project.service.ProjectService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

/**
 * 
 * @author jiangwu
 *
 */
@Controller
public class ProjectController {

	@Resource
	private ProjectService proService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("doAddProject")
	public String doAddProject(Project pro,HttpSession session,Model model) {
		System.err.println("doAddProject-----"+pro);
		RecruitingUsers attribute = (RecruitingUsers)session.getAttribute("loginUser");
		Project queryProject = proService.queryProject(attribute.getUserid());
		System.out.println("----------->"+queryProject);
		pro.setPuserid(attribute.getUserid());
		if(queryProject==null) {
			proService.addProject(pro);
		}else {
			pro.setPid(queryProject.getPid());
			proService.updateProject(pro);
		}
		/*修改时间*/
		userService.updateTime(attribute.getUserid());
		session.setAttribute("loginUser",userService.detailRecruitingUsers(attribute.getUserid()));
		return "redirect:toResume.controller";
	}

	

	
	
	
	
	
	
}
