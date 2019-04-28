package cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.entity.Adminuser;
import cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.service.AdminuserService;

@Controller
public class AdminuserController {
	
	@Resource
	private AdminuserService adminService;
	
	/**
	 * 管理员登录
	 * @param adminuser
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doLoginAdminUser")
	public String doLoginAdminUser(Adminuser adminuser, HttpSession session, Model model) {
		System.out.println(adminuser+"--------------------");
		Adminuser loginAdminUser = adminService.loginAdminUser(adminuser);
		if(loginAdminUser!=null) {
			session.setAttribute("loginUserAdmin", loginAdminUser);
			return "backstage/index";
		}else {
			model.addAttribute("adminlogin", adminuser);
			return "backstage/Public/login";
		}
	}
	
	/**
	 * ajax查询管理员
	 * @param adminuser
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxListAdminUser")
	public List<Adminuser> doListAdminUser(String ausername,Model model) {
		Adminuser adminuser = new Adminuser();
		adminuser.setAusername(ausername);
		System.err.println(adminuser+"--------------------------------------");
		List<Adminuser> queryAllAdminUser = adminService.queryAllAdminUser(adminuser);
		return queryAllAdminUser;
	}
	
	/**
	 * 退出管理员登录状态
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doOutAdminuser")
	public String doOutAdminuser(HttpSession session, Model model) {
		session.removeAttribute("loginUserAdmin");
		return "backstage/Public/login";
	}
	
	
	//http://localhost:8080/toBackstageIndex.controller
	/**
	 * 增加管理员
	 * @param adminuser
	 * @param model
	 * @return
	 */
	@RequestMapping("doAddAdminUser")
	public String doAddAdminUser(Adminuser adminuser,Model model) {
		int addAdminUser = adminService.addAdminUser(adminuser);
		if(addAdminUser>0) {
			return "redirect:toUserIndex.controller";
		}else {
			model.addAttribute("addAdminuser", adminuser);
			return "backstage/User/add";
		}
	}
	
	
}
