package cn.kgc.tangcco.tcmp073.qizu.recruit.user.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Corporate;
import cn.kgc.tangcco.tcmp073.qizu.entity.Eclosure;
import cn.kgc.tangcco.tcmp073.qizu.entity.Educationalbackground;
import cn.kgc.tangcco.tcmp073.qizu.entity.HopeJob;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.entity.Project;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.entity.Selfdescription;
import cn.kgc.tangcco.tcmp073.qizu.entity.Worksdisplay;
import cn.kgc.tangcco.tcmp073.qizu.recruit.Corporate.service.CorporateService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.eb.service.EbService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.service.HopeJobService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service.OccupationService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.ocone.service.OconeService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.project.service.ProjectService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.service.SelfdescriptionService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.service.WorksdisplayService;

/**
 * 许茂峰
 * 
 * @author jiangwu
 *
 */
@Controller
public class MainController {
	@Resource
	private EbService ebService;

	@Resource
	private UserService userService;

	@Resource
	private SelfdescriptionService ss;

	@Resource
	private WorksdisplayService ws;

	@Resource
	private OconeService os;

	@Resource
	private CompanyService com;

	@Resource
	private OccupationService occupationService;
	
	@Resource
	private HopeJobService hopeJobService;
	
	@Resource 
	private CorporateService corporateService;

	@Resource
	private ProjectService projectService;
	
	
	
	
	
	@RequestMapping("toIndex")
	public String toIndex(Model model) {
		model.addAttribute("ocone", os.queryType());
		for (int i = 0; i < 7; i++) {
			model.addAttribute("ocone1" + i, os.querySuiji(i));
		}
		List<Company> queryalltoFounder = com.queryalltoFounder();
		for (Company company : queryalltoFounder) {
			System.err.println(company + "/n");
		}
		
		List<Company> querylikeoname = com.queryalltoFounder();
		for (Company c : querylikeoname) {
			System.err.println(c.getCfinancing());
			String num = c.getCfinancing();
			//已盗号隔开
			String[] zz = num.split("\\,");
			//声明list集合
			List<String> bq = new ArrayList<>();
			//遍历数组将每一个元素加到list集合中
			for(int a=0;a<zz.length;a++) {
				System.out.println("-------这是数组------->"+zz[a]);
				bq.add(zz[a]);
			}
			for (String string : bq) {
				System.out.println("----这是集合----->"+string);
			}
			c.setBiaoqian(bq);

		}
		List<Company> querylikeoname2 = com.queryalltozuixin();
		for (Company c : querylikeoname2) {
			System.err.println(c.getCfinancing());
			String num = c.getCfinancing();
			//已盗号隔开
			String[] zz = num.split("\\,");
			//声明list集合
			List<String> bq = new ArrayList<>();
			//遍历数组将每一个元素加到list集合中
			for(int a=0;a<zz.length;a++) {
				System.out.println("-------这是数组------->"+zz[a]);
				bq.add(zz[a]);
			}
			for (String string : bq) {
				System.out.println("----这是集合----->"+string);
			}
			c.setBiaoqian(bq);

		}
		

		model.addAttribute("com", querylikeoname);
		model.addAttribute("coo", querylikeoname2);

		return "main/index";
	}

	/**
	 * 跳转职位详情页面
	 * 
	 * @param cccname
	 * @param model
	 * @return
	 */
	@RequestMapping("toxiangqing")
	public String toxiangqing(String cccname,HttpSession session, Model model) {
		System.out.println("-------------------->>>>>>>" + cccname);
		// 查询职业详情
		Occupation queryOccupation = occupationService.queryOccupation(Integer.parseInt(cccname));
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		// 查询职业所在的公司
		Eclosure queryescName = userService.queryescName(attribute.getUserid());
		if(queryescName!=null) {
			String escName = queryescName.getEsurename();
		    int  wenjianming=escName.lastIndexOf('=');
		    int  lujin=escName.lastIndexOf('\\');
		    int  lujin1=escName.lastIndexOf('\\', lujin-1);
		    String fName = escName.substring(wenjianming+1);
		    String fNameLiJin = escName.substring(lujin1+1);
		    System.err.println(fName);
		    model.addAttribute("escname",fName); //文件名
		    model.addAttribute("fNameLiJin",fNameLiJin); //路径
		}
		Company queryCompanyByCid = com.queryCompanyByCid(queryOccupation.getOcid());
		model.addAttribute("queryOccupation", queryOccupation);
		model.addAttribute("queryCompanyByCid", queryCompanyByCid);
		return "main/jobdetail1";
	}

	/**
	 * 去简历页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toResume")
	public String toResume(HttpSession session, Model model) {
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		System.err.println(attribute.getUserid());
		/* 储存教育背景 */
		
		
		
		Integer jindutiao=0;
		
		if (attribute != null) {
			Educationalbackground queryEducationalbackground = ebService.queryEducationalbackground(attribute.getUserid());
			
			if (queryEducationalbackground != null) {
				model.addAttribute("educationalbackground", queryEducationalbackground);
				jindutiao+=15;
			}
			Selfdescription querySelfdescription = ss.querySelfdescription(attribute.getUserid());
			if (querySelfdescription != null) {
				model.addAttribute("selfdescriptionModel", querySelfdescription.getSdescription());
				jindutiao+=15;
			}
			Worksdisplay queryWorksdisplay = ws.queryWorksdisplay(attribute.getUserid());
			if (queryWorksdisplay != null) {
				model.addAttribute("worksdisplayMapperModel", queryWorksdisplay);
				jindutiao+=15;
			}
			HopeJob detailHopeJob = hopeJobService.detailHopeJob(attribute.getUserid());			
			if(detailHopeJob!=null) {
				model.addAttribute("detailHopeJob", detailHopeJob);
				jindutiao+=15;
			}
			Corporate corporate =corporateService.queryAll(attribute.getUserid());
			if(corporate!=null) {
				model.addAttribute("queryAllCorporate",corporate);
				jindutiao+=15;
			}
			Project project=projectService.queryProject(attribute.getUserid());
			if(project!=null) {
				model.addAttribute("queryAllProject",project);
				jindutiao+=15;
			}
			
			model.addAttribute("jindutiao", jindutiao);
			// System.out.println("-------------------------------");
			// System.err.println(queryWorksdisplay.getWlink());
			// System.out.println("-------------------------------");
			// System.err.println(ss.querySelfdescription(attribute.getUserid()).getSdescription());
		
		
			Eclosure queryescName = userService.queryescName(attribute.getUserid());
			if(queryescName!=null) {
				String escName = queryescName.getEsurename();
			    int  wenjianming=escName.lastIndexOf('=');
			    int  lujin=escName.lastIndexOf('\\');
			    int  lujin1=escName.lastIndexOf('\\', lujin-1);
			    String fName = escName.substring(wenjianming+1);
			    String fNameLiJin = escName.substring(lujin1+1);
			    System.err.println(fName);
			    model.addAttribute("escname",fName); //文件名
			    model.addAttribute("fNameLiJin",fNameLiJin); //路径
			}
		    
		}
		return "main/jianli";
	}

	/**
	 * 去登录页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin(Model model) {
		return "main/login";
	}

	/**
	 * 去注册页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toRegister")
	public String toRegister(Model model) {
		return "main/register";
	}

	/**
	 * 去找回密码页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toReset")
	public String toReset(Model model) {
		return "main/reset";
	}

	/**
	 * 去账号设置
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toAccountSettings")
	public String toAccountSettings(Model model) {
		return "main/accountBind";
	}

	/**
	 * 去修改密码页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdatePwd")
	public String toUpdatePwd(Model model) {
		return "main/updatePwd";
	}

	/**
	 * 去投递职位
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toDelivery")
	public String toDelivery(Model model) {
		return "main/delivery";
	}

	/**
	 * 去list页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toListOoccupation")
	public String toListOoccupation(String oname, Model model) {
        
		List<Company> querylikeoname = com.querylikeoname(oname);
		for (Company c : querylikeoname) {
			//System.err.println(c.getCfinancing());
			String num = c.getCfinancing();
			//已盗号隔开
			String[] zz = num.split("\\,");
			//声明list集合
			List<String> bq = new ArrayList<>();
			//遍历数组将每一个元素加到list集合中
			for(int a=0;a<zz.length;a++) {
				System.out.println("-------这是数组------->"+zz[a]);
				bq.add(zz[a]);
			}
			for (String string : bq) {
				System.out.println("----这是集合----->"+string);
			}
			c.setBiaoqian(bq);

		}
		
		model.addAttribute("oname", querylikeoname);
		model.addAttribute("kd", oname);
		System.err.println("_____________---------->>>>>.."+com.querytooccname(oname));
		model.addAttribute("ocname",com.querytooccname(oname));
		return "main/list";
		//aaa
	}
}
