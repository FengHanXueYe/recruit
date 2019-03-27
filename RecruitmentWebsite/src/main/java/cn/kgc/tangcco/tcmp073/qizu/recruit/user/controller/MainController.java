package cn.kgc.tangcco.tcmp073.qizu.recruit.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 许茂峰
 * @author jiangwu
 *
 */
@Controller
public class MainController {
	@RequestMapping("toIndex")
	public String toIndex(Model model) {
		return "main/index";
	}
	
	/**
	 * 去简历页
	 * @param model
	 * @return
	 */
	@RequestMapping("toResume")
	public String toResume(Model model) {
		return "main/jianli";
	}
	/**
	 * 去登录页
	 * @param model
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin(Model model) {
		return "main/login";
	}
	/**
	 * 去注册页
	 * @param model
	 * @return
	 */
	@RequestMapping("toRegister")
	public String toRegister(Model model) {
		return "main/register";
	}
	/**
	 * 去找回密码页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toReset")
	public String toReset(Model model) {
		return "main/reset";
	}
	
	
	
}
