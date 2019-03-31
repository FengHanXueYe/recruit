package cn.kgc.tangcco.tcmp073.qizu.recruit.user.controller;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.emailutils.Email;
import cn.kgc.tangcco.tcmp073.qizu.encryption.Encryption;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

/**
 * 用户servlet
 * 
 * @author HASEE
 *
 */
@Controller
public class UserController {

	@Resource
	private UserService userService;

	/**
	 * 登录
	 * 
	 * @param ruser
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("userLogin")
	public String userLogin(RecruitingUsers ruser, HttpSession session, Model model) {
		String ruserpwd = ruser.getPassword();
		// 设置session有效时间
		// session.setMaxInactiveInterval(15*60);
		// System.err.println("login---->"+ruser);
		// 得到密码
		String password = ruser.getPassword();
		// MD5加密
		password = Encryption.md5Encode(password.getBytes());
		// base64编码
		password = Encryption.base64Encode(password.getBytes());
		System.out.println("=====登录====>" + password);
		// 重新赋值给password
		ruser.setPassword(password);
		// 从数据库中查询是否有这样一个用户
		RecruitingUsers loginRecruitingUsers = userService.loginRecruitingUsers(ruser);
		// System.out.println("session==============>"+loginRecruitingUsers);
		session.setAttribute("ruserpwd", ruserpwd);
		if (loginRecruitingUsers == null) {
			model.addAttribute("ruser", ruser);
			return "main/login";
		} else {
			session.setAttribute("loginUser", loginRecruitingUsers);
			return "main/index";
		}

	}

	/**
	 * 判断邮箱是否被注册
	 * 
	 * @param email
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxQueryEmail")
	public int ajaxQueryEmail(String email, Model model) {
		return userService.queryRecruitingUsersCount(email);
	}

	/**
	 * 注册
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("doRegister")
	public String doRegister(RecruitingUsers ruser, Model model) {
		// 得到注册时的密码
		String password = ruser.getPassword();
		// 再次储存方便转发到登录界面
		String password1 = ruser.getPassword();
		// MD5
		password = Encryption.md5Encode(password.getBytes());
		// base64
		password = Encryption.base64Encode(password.getBytes());
		System.out.println("====注册====>" + password);
		// 赋值给password
		ruser.setPassword(password);
		Email email = new Email();
		// 实现邮箱发送
		String sendEamilCode = email.sendEamilCode(ruser.getEmail());
		// 判断是否成功
		if (sendEamilCode == "成功") {
			// 增加一个用户
			userService.addUser(ruser);
			// 将注册时的密码储存
			ruser.setPassword(password1);
			// 储存发闪送到登录界面
			model.addAttribute("userEmail", "邮箱已发送！");
			model.addAttribute("ruser", ruser);
			return "main/login";
		} else {
			model.addAttribute("ruser", ruser);
			model.addAttribute("errorEmail", "邮件发送失败！请稍后重试");
			return "main/register";
		}

	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doRemoveSession")
	public String doRemoveSession(HttpSession session, Model model) {
		// 消除session
		session.invalidate();
		return "main/index";
	}

	/**
	 * 修改简历
	 * 
	 * @param ruser
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doUpdateResumename")
	public String doUpdateResumename(RecruitingUsers ruser, String xueli, String jingyan, HttpSession session,
			Model model) {
		// 从session中取用户
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		// 查询该用户的详细信息
		RecruitingUsers detailUser = userService.detailRecruitingUsers(attribute.getUserid());
		if (xueli != null) {
			ruser.setEducation(Integer.parseInt(xueli));
		} else {
			ruser.setEducation(detailUser.getEducation());
		}
		if (jingyan != null) {
			ruser.setUserlog(Integer.parseInt(jingyan));
		} else {
			ruser.setUserlog(detailUser.getUserlog());
		}
		// 将用户的id赋值给ruser（因为前台没传用户id）
		ruser.setUserid(attribute.getUserid());
		// 执行修改
		userService.updateUser(ruser);
		// 再次查询该用户信息储存到session中覆盖
		session.setAttribute("loginUser", userService.detailRecruitingUsers(attribute.getUserid()));
		return "main/jianli";
	}

	/**
	 * 修改用户密码
	 * 
	 * @param newpassword
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doUpdatePassword")
	public String doUpdatePassword(String newpassword, HttpSession session, Model model) {
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		// MD5
		newpassword = Encryption.md5Encode(newpassword.getBytes());
		// base64
		newpassword = Encryption.base64Encode(newpassword.getBytes());
		RecruitingUsers ruser = new RecruitingUsers();
		ruser.setPassword(newpassword);
		ruser.setUserid(attribute.getUserid());
		int updateUser = userService.updateUser(ruser);
		if (updateUser > 0) {
			model.addAttribute("updatepwdruser", "修改成功！");
		}
		;
		return "main/accountBind";
	}

	/**
	 * 判断用户密码是否正确
	 * 
	 * @param password
	 * @param session
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxPdPassword")
	public boolean ajaxPdPassword(String password, HttpSession session, Model model) {
		// 从session中取用户密码
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		RecruitingUsers detailRecruitingUsers = userService.detailRecruitingUsers(attribute.getUserid());
		// MD5
		password = Encryption.md5Encode(password.getBytes());
		// base64
		password = Encryption.base64Encode(password.getBytes());
		System.out.println(detailRecruitingUsers.getPassword() + "+----------------");
		System.out.println(password + "pwd----------------");
		if (password.equals(detailRecruitingUsers.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}
