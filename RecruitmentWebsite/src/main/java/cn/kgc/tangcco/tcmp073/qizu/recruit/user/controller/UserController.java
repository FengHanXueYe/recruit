package cn.kgc.tangcco.tcmp073.qizu.recruit.user.controller;


import javax.annotation.Resource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.emailutils.Email;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;
/**
 * 用户servlet
 * @author HASEE
 *
 */
@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 登录
	 * @param ruser
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("userLogin")
	public String userLogin(RecruitingUsers ruser,HttpSession session,Model model) {
		//设置session有效时间
		//session.setMaxInactiveInterval(15*60);
		//System.err.println("login---->"+ruser);
		RecruitingUsers loginRecruitingUsers = userService.loginRecruitingUsers(ruser);
		//System.out.println("session==============>"+loginRecruitingUsers);
		if(loginRecruitingUsers==null) {
			model.addAttribute("ruser", ruser);
			return "main/login";
		}else {
			session.setAttribute("loginUser",loginRecruitingUsers );
			return "main/index";
		}
		
	}
	/**
	 * 判断邮箱是否被注册
	 * @param email
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxQueryEmail")
	public int ajaxQueryEmail(String email,Model model) {
		return userService.queryRecruitingUsersCount(email);
	}
	/**
	 * 注册
	 * @param model
	 * @return
	 */
	@RequestMapping("doRegister")
	public String doRegister(RecruitingUsers ruser,Model model) {
		userService.addUser(ruser);
		model.addAttribute("ruser", ruser);
		Email email = new Email();
		String sendEamilCode = email.sendEamilCode(ruser.getEmail());
		if(sendEamilCode=="成功") {
			model.addAttribute("userEmail", "邮箱已发送！");
			return "main/login";
		}else {
			model.addAttribute("ruser", ruser);
			model.addAttribute("errorEmail", "邮件发送失败！请稍后重试");
			return "main/register";
		}
		
	}
	/**
	 * 退出登录
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doRemoveSession")
	public String doRemoveSession(HttpSession session,Model model) {
		session.invalidate();
		return "main/index";
	}
	/**
	 * 修改简历
	 * @param ruser
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doUpdateResumename")
	public String doUpdateResumename(RecruitingUsers ruser,String xueli,String jingyan,HttpSession session,Model model) {
		
		RecruitingUsers attribute =(RecruitingUsers) session.getAttribute("loginUser");
		RecruitingUsers detailUser = userService.detailRecruitingUsers(attribute.getUserid());
			if(xueli!=null) {
				ruser.setEducation(Integer.parseInt(xueli));
			}else {
				ruser.setEducation(detailUser.getEducation());
			}
			if(jingyan!=null) {
				ruser.setUserlog(Integer.parseInt(jingyan));
			}else {
				ruser.setUserlog(detailUser.getUserlog());
			}
			System.err.println("经验"+jingyan+"------学历"+xueli);
			System.err.println("8888**************    "+ruser);
			ruser.setUserid(attribute.getUserid());
			System.err.println("0000000000000"+ruser.getResumeName());
			userService.updateUser(ruser);
			System.err.println("))))))))))))))))))))))"+userService.detailRecruitingUsers(attribute.getUserid()));
			session.setAttribute("loginUser", userService.detailRecruitingUsers(attribute.getUserid()));
			
		
		return "main/jianli";
	}
	
	
	
	
}
