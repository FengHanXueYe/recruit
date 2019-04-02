package cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.entity.Deliverypost;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.service.DeliverypostService;

@Controller
public class DeliverypostController {
	
	@Resource
	private DeliverypostService ds;
	/**
	 * 查询所有的投递的职位
	 * @param userid
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doListDeliverypost")
	public String doListDeliverypost(Integer userid,HttpSession session,Model model) {
		//获取用户
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		//实例一个投递的职位
		Deliverypost dp = new Deliverypost();
		//将用户赋值给投递职位中的用户属性
		dp.setRuser(attribute);
		//查询用户投递的职位
		List<Deliverypost> queryAllDeliverypost = ds.queryAllDeliverypost(dp);
		//转发到页面
		model.addAttribute("listDeliverypost", queryAllDeliverypost);
		System.out.println("(((((((((((((((("+queryAllDeliverypost);
		return "main/delivery";
	}
	
	/**
	 * ajax查询投递职位的状态
	 * @param status
	 * @param session
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxQueryDeliverypost")
	public List<Deliverypost> ajaxQueryDeliverypost(Integer status,HttpSession session,Model model) {
		System.out.println("------状态------->"+status);
		//得到用户
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		Deliverypost dp = new Deliverypost();
		//赋值用户id
		dp.setRuser(attribute);
		//赋值状态
		dp.setDstatus(status);
		List<Deliverypost> queryAllDeliverypost = ds.queryAllDeliverypost(dp);
		System.err.println("===========》"+queryAllDeliverypost);
		return queryAllDeliverypost;
	}
	//阿萨大
	
	
}
