package cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.entity.Adminuser;
import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.service.AdminuserService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service.OccupationService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

@Controller
public class AdminMainController {


	@Resource
	private AdminuserService adminService;
	@Resource
	private CompanyService companyservice;
	@Resource
	private OccupationService occupationservice;
	@Resource
	private UserService userService;
	
	
	
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
	//去后台公司管理页面
	@RequestMapping("toNodeIndex")
	public String toNodeIndex(Model model,String cname) {
		model.addAttribute("listCompany", this.companyservice.queryAllCompany(cname));
		return "backstage/Node/index";
	}
	//去公司编辑
	@RequestMapping("toNodeEdit")
	public String NodeEdit(Model model,int cid) {
		model .addAttribute("company", this.companyservice.queryCompanyByCid(cid));
		return "backstage/Node/edit";
	}
	//公司编辑
	@RequestMapping("doUpdateCompany")
	public String doUpdateCompany(Company com) {
		this.companyservice.updateCompanys(com);
		return "redirect:toNodeIndex.controller";
	}
	//公司禁用
	@RequestMapping("doUpdateOstate")
	public String doUpdateOstate(int cid,int cstate) {
		this.companyservice.updateCompanyCstate(cid,cstate);
		return "redirect:toNodeIndex.controller";
	}
	//职位禁用
	@RequestMapping("toxiaxian")
	public String xiaxian(Model model,int oid) {
		 this.adminService.updataOccStatic(oid);
		return "redirect:toMenuIndex.controller";
	}
	//公司删除
	@RequestMapping("deleteCompany")
	public String deleteCompany(int cid) {
		this.companyservice.deleteCompany(cid);
		return "redirect:toNodeIndex.controller";
	}

	
	@RequestMapping("toMenuIndex")
	public String toMenuIndex(Model model,String oname) {
		List<Company> querylikeoname = adminService.querylikeoname(oname);
		model.addAttribute("zhiwei",querylikeoname);
		for (Company company : querylikeoname) {
			System.err.println("===========>"+company);
			System.out.println();
		}
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
	//去用户编辑
	@RequestMapping("toeditUser")
	public String toedituser(Integer userid,Model model) {
		RecruitingUsers queryRusernameById = adminService.queryRecuitUserById(userid);
		model.addAttribute("recuitUser", queryRusernameById);
		return "backstage/Role/edit";
	}	
	
	//用户编辑
		@RequestMapping("doUpdateUser")
		public String doUpdateUser(RecruitingUsers users) {
			this.adminService.updateRecuitUser(users);
			return "redirect:toRecuitUserIndex.controller";
		}
	
	/**
	 * 删除用户
	 * @param userid
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxDeleteUser")
	public boolean doDeleteUser(Integer pk, Model model) {
		System.out.println("用户已删除");
		int delUser = userService.deleteUser(pk);
		if(delUser>0) {
			return true;
		}else {
			return false;
		}
	}
	@ResponseBody
	@RequestMapping("ajaxDeleteOcc")
	public boolean deleteocc(Model model,Integer oid) {
		int deleteocc=adminService.deleteOcc(oid);
		if(deleteocc>0) {
			return true;
		}else {
			return false;	
		}
		
	}
	@RequestMapping("toDetailOcc")
	public String chakan(Model model,int oid) {
		
//		companyservice.queryCompanyByCid(cid)
		
		System.out.println("我是id=====》"+oid);
		model.addAttribute("detailOcc",adminService.queryDatial(oid));
		System.err.println(")))))))))))))))))))))"+adminService.queryDatial(oid));
		return "backstage/Menu/add";
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
