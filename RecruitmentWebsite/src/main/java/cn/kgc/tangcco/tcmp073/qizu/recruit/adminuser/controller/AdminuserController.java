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
	
	
	/**
	 * 增加管理员
	 * @param adminuser
	 * @param model
	 * @return
	 */
	@RequestMapping("doAddAdminUser")
	public String doAddAdminUser(Adminuser adminuser,Model model) {
		int queryCountAdminUser = adminService.queryCountAdminUser();
		if(queryCountAdminUser>10) {
				model.addAttribute("admincount", "管理员人数达到上限！");
				return "redirect:toUserIndex.controller";
		}else {
			int addAdminUser = adminService.addAdminUser(adminuser);
			if(addAdminUser>0) {
				return "redirect:toUserIndex.controller";
			}else {
				model.addAttribute("addAdminuser", adminuser);
				return "backstage/User/add";
			}
		}
	}
	
	/**
	 * ajax查询用户名
	 * @param ausername
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxQueryAdminuserByName")
	public Adminuser ajaxQueryAdminuserByName(String ausername, Model model) {
		Adminuser queryAusername = adminService.queryAusername(ausername);
		return queryAusername;	
	}
	/**
	 * 修改管理员信息
	 * @param adminuser
	 * @param model
	 * @return
	 */
	@RequestMapping("doUpdateAdminuser")
	public String doUpdateAdminuser(Adminuser adminuser, Model model) {
		int updateAdminUser = adminService.updateAdminUser(adminuser);
		return "redirect:toUserIndex.controller";
	}
	
	/**
	 * 删除管理员
	 * @param aid
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxDeleteAdminuser")
	public boolean doDeleteAdminuser(Integer aid, Model model) {
		System.out.println("删除了啊啊啊啊啊啊啊啊");
		int deleteAdminUser = adminService.deleteAdminUser(aid);
		if(deleteAdminUser>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
