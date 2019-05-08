package cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.entity.Adminuser;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
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



	@RequestMapping("toRoleAdd")
	public String toRoleAdd(Model model) {
		return "backstage/Role/add1";
	}
	
	
    //管理员
	@RequestMapping("toUserIndex")
	public String toUserIndex(Adminuser adminuser,Model model) {
		List<Adminuser> queryAllAdminUser = adminService.queryAllAdminUser(adminuser);
		model.addAttribute("listAdminuser", queryAllAdminUser);
		return "backstage/User/index";
	}
	//用户管理
	@RequestMapping("toRecuitUserIndex")
	public String torecuitUSer(String username,Model model) {
		List<RecruitingUsers> queryAllUser=adminService.queryAllrecuit(username);
		model.addAttribute("listrecuit",queryAllUser);
		return "backstage/Role/index";
	}
	@RequestMapping("toeditUser")
	public String toedituser(Integer userid,Model model) {
		System.out.println(userid+"----------------------------");
		RecruitingUsers queryRusernameById = adminService.queryRecuitUserById(userid);
		model.addAttribute("recuitUser", queryRusernameById);
		return "backstage/Role/edit";
	}	
	
	/**
	 * 删除用户
	 * @param userid
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxDeleteUser")
	public boolean doDeleteUser(Integer userid, Model model) {
		System.out.println("用户已删除");
		int deleteUser = adminService.deleterecutUser(userid);
		if(deleteUser>0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * 禁用用户
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxJingyongUser")
	public int doJingyongUser(Integer userid, Model model) {
		System.out.println("用户已禁用");
		int jingyongUser = adminService.ProhibitRecuitUser(userid);
		return jingyongUser;
			
		}
	/**
	 * 
	 * 恢复用户
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxRecoveryUser")
	public String doRecoveryUser(Integer userid, Model model) {
		System.out.println("用户已恢复");
		int RecoveryUser = adminService.RecoveryUser(userid);
	 return "backstage/Role/edit";
				
	}
	
	/**
	 * ajax查询用户名
	 * @param username
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxQueryUserByName")
	public RecruitingUsers ajaxQueryUserByName(String username, Model model) {
		RecruitingUsers queryUsername = adminService.queryUsername(username);
		return queryUsername;	
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
