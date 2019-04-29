package cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Adminuser;
import cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.service.AdminuserService;

@Controller
public class AdminMainController {


	@Resource
	private AdminuserService adminService;
	/**
	 * 去后台登录界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toLoginAdminuser")
	public String toLoginAdminuser(Model model) {
		return "backstage/Public/login";
	}

	@RequestMapping("toNodeIndex")
	public String toNodeIndex(Model model) {
		return "backstage/Node/index";
	}

	@RequestMapping("toMenuIndex")
	public String toMenuIndex(Model model) {
		return "backstage/Menu/index";
	}

	@RequestMapping("toRoleIndex")
	public String toRoleIndex(Model model) {
		return "backstage/Role/index";
	}
	@RequestMapping("toRoleAdd")
	public String toRoleAdd(Model model) {
		return "backstage/Role/add1";
	}
	
	

	@RequestMapping("toUserIndex")
	public String toUserIndex(Adminuser adminuser,Model model) {
		List<Adminuser> queryAllAdminUser = adminService.queryAllAdminUser(adminuser);
		model.addAttribute("listAdminuser", queryAllAdminUser);
		return "backstage/User/index";
	}
	@RequestMapping("toUserAdd")
	public String toUserAdd(Model model) {
		return "backstage/User/add";
	}
	
	@RequestMapping("toUserEdit")
	public String toUserEdit(Integer aid,Model model) {
		System.out.println(aid+"----------------------------");
		Adminuser queryAusernameById = adminService.queryAusernameById(aid);
		model.addAttribute("adminuser", queryAusernameById);
		return "backstage/User/edit";
	}
	
	
}
