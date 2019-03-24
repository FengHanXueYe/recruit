package cn.kgc.tangcco.tcmp073.qizu.recruit.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 许茂峰楞🐕
 * @author jiangwu
 *
 */
@Controller
public class MainController {
	@RequestMapping("toIndex")
	public String toIndex(Model model) {
		System.out.println("asdasd");
		
		return "main/index";
	}
	
	
}
