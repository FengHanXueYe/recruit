package cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Companyresume;
import cn.kgc.tangcco.tcmp073.qizu.entity.Deliverypost;
import cn.kgc.tangcco.tcmp073.qizu.entity.DpCy;
import cn.kgc.tangcco.tcmp073.qizu.entity.Educationalbackground;
import cn.kgc.tangcco.tcmp073.qizu.entity.HopeJob;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.entity.Selfdescription;
import cn.kgc.tangcco.tcmp073.qizu.entity.Worksdisplay;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.service.CompanyresumeService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.service.DeliverypostService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.eb.service.EbService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.service.HopeJobService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service.OccupationService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.service.SelfdescriptionService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.service.WorksdisplayService;

@Controller
public class DeliverypostController {
	
	@Resource
	private DeliverypostService ds;
	
	@Resource
	private UserService userService;
	
	@Resource
	private EbService ebService;
	
	@Resource
	private SelfdescriptionService ss;
	
	@Resource
	private WorksdisplayService ws;
	
	@Resource
	private CompanyService companyService;
	
	@Resource
	private CompanyresumeService CompanyresumeService;
	
	@Resource
	private OccupationService occupationService;
	
	@Resource
	private HopeJobService hopeJobService;
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
		List<DpCy> dpcyList = new ArrayList<>();
		DpCy dpcy = null;
		
		//实例一个投递的职位
		Deliverypost dp = new Deliverypost();
		//将用户赋值给投递职位中的用户属性
		dp.setRuser(attribute);
		//查询用户投递的职位
		
		List<Deliverypost> queryAllDeliverypost = ds.queryAllDeliverypost(dp);
		for (Deliverypost deliverypost : queryAllDeliverypost) {
			dpcy = new DpCy();
			dpcy.setDeliverypost(deliverypost);
			Company queryCompanyByCid = companyService.queryCompanyByCid(deliverypost.getOccupation().getOcid());
			dpcy.setCompany(queryCompanyByCid);
			dpcy.setCuser(userService.detailRecruitingUsers(queryCompanyByCid.getCuid()));
			dpcyList.add(dpcy);
		}
		//转发到页面
		model.addAttribute("listDeliverypost", dpcyList);
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
	public List<DpCy> ajaxQueryDeliverypost(Integer status,HttpSession session,Model model) {
		System.out.println("------状态------->"+status);
		//得到用户
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		Deliverypost dp = new Deliverypost();
		
		List<DpCy> dpcyList = new ArrayList<>();
		DpCy dpcy = null;
		//赋值用户id
		dp.setRuser(attribute);
		//赋值状态
		if(status!=9) {
			dp.setDstatus(status);
		}
		List<Deliverypost> queryAllDeliverypost = ds.queryAllDeliverypost(dp);
		for (Deliverypost deliverypost : queryAllDeliverypost) {
			dpcy = new DpCy();
			dpcy.setDeliverypost(deliverypost);
			Company queryCompanyByCid = companyService.queryCompanyByCid(deliverypost.getOccupation().getOcid());
			dpcy.setCompany(queryCompanyByCid);
			dpcy.setCuser(userService.detailRecruitingUsers(queryCompanyByCid.getCuid()));
			dpcyList.add(dpcy);
		}
		System.err.println("===========》"+queryAllDeliverypost);
		return dpcyList;
	}
	/**
	 * 去查看简历页面
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping("doCheckView")
	public String doCheckView(String userid,Model model) {
		System.err.println("查看用户的简历"+userid);
		/*RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		System.err.println(attribute.getUserid());*/
		/* 储存教育背景 */
		if (userid != null) {
			Educationalbackground queryEducationalbackground = ebService
					.queryEducationalbackground(Integer.parseInt(userid));
			if (queryEducationalbackground != null) {
				model.addAttribute("educationalbackground", queryEducationalbackground);
			}
			Selfdescription querySelfdescription = ss.querySelfdescription(Integer.parseInt(userid));
			if (querySelfdescription != null) {
				model.addAttribute("selfdescriptionModel", querySelfdescription.getSdescription());
			}
			Worksdisplay queryWorksdisplay = ws.queryWorksdisplay(Integer.parseInt(userid));
			if (queryWorksdisplay != null) {
				model.addAttribute("worksdisplayMapperModel", queryWorksdisplay);
			}
			HopeJob detailHopeJob = hopeJobService.detailHopeJob(Integer.parseInt(userid));			
			if(detailHopeJob!=null) {
				model.addAttribute("detailHopeJob", detailHopeJob);
			}
			
		}
		
		
		return "main/preview";
	}
	/**
	 * 投递简历
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping("doAddDeliverypost")
	public String doAddDeliverypost(String oid,HttpSession session,Model model) {
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		
		//判断是否登录
		if(attribute!=null) {
			
			
			Educationalbackground queryEducationalbackground = ebService.queryEducationalbackground(attribute.getUserid());
			//判断信息的完整性
			if(queryEducationalbackground!=null && attribute.getUsername()!=null && attribute.getEducation()!=null && attribute.getTelephone()!=null && attribute.getUserlog()!=null && attribute.getGender()!=null) {
				//实例投递简历
				Deliverypost dp = new Deliverypost();
				//实例职位
				Occupation occ = new Occupation();
				//将职位id赋值给职位对象
				occ.setOid(Integer.parseInt(oid));
				dp.setRuser(attribute);
				dp.setOccupation(occ);
				
				Deliverypost detailDeliverypost = ds.detailDeliverypost(dp);
				if(detailDeliverypost!=null) {
					return "redirect:toIndex.controller";
				}
				//赋值状态默认5，投递成功
				dp.setDstatus(5);
				//实例公司查看的投递信息
				Companyresume cr = new Companyresume();
				//实例公司
				Company company = new Company();
				//根据职位id查职位再查发布公司
				Occupation queryOccupation = occupationService.queryOccupation(Integer.parseInt(oid));
				//赋值公司id
				company.setCid(queryOccupation.getOcid());
				//将公司赋值给Companyresume实体
				cr.setCompany(company);
				//职业赋值给Companyresume
				cr.setOccupation(queryOccupation);
				//用户赋值给Companyresume
				cr.setCuser(attribute);
				//赋值状态
				cr.setDstatus(5);
				//添加投递信息
				int addDeliverypost = ds.addDeliverypost(dp);
				//实现公司查看收到简历表的增加
				int addCompanyresume = CompanyresumeService.addCompanyresume(cr);
				if(addDeliverypost>0 && addCompanyresume>0) {
					return "redirect:doListDeliverypost.controller";
				}else {
					return "redirect:toIndex.controller";
				}
			}else {
				model.addAttribute("jiaoyubeijin", "请完善基本信息和教育背景！");
				return "redirect:toResume.controller";
			}
		}else {
			return "redirect:toLogin.controller";
		}
	}
	/**
	 * 去我的推荐职位页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toMyList")
	public String toMyList(/*int sshu,*/Model model) {
	/*	System.out.println("----------------------------");
		   sshu=ds.queryCount();
		   System.err.println(sshu);
		   model.addAttribute("count", sshu);*/
		return "main/mList";
	}
	
}
