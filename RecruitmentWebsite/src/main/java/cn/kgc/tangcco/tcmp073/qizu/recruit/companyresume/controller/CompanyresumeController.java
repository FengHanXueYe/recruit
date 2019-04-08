package cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.CoRe;
import cn.kgc.tangcco.tcmp073.qizu.entity.Companyresume;
import cn.kgc.tangcco.tcmp073.qizu.entity.CpCy;
import cn.kgc.tangcco.tcmp073.qizu.entity.Educationalbackground;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.entity.Selfdescription;
import cn.kgc.tangcco.tcmp073.qizu.entity.Worksdisplay;
import cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.service.CompanyresumeService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.eb.service.EbService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.service.SelfdescriptionService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.service.WorksdisplayService;

@Controller
public class CompanyresumeController {

	@Resource
	private CompanyresumeService cs;
	
	@Resource
	private EbService ebService;
	
	@Resource
	private SelfdescriptionService ss;

	@Resource
	private WorksdisplayService ws;
	/**
	 * 查询收到的简历
	 * @param dstatus
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doListCompanyresume")
	public String doListCompanyresume(String dstatus,HttpSession session,Model model) {
		// 从session中取用户
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		List<CoRe> coreList = new ArrayList<>();
		CoRe core = null;
		Companyresume cr = new Companyresume();
		
		Companyresume queryOccuotion = cs.queryOccuotion(attribute.getUserid());
		
		System.out.println(queryOccuotion+"--------------------"+attribute.getUserid());
		cr.setCompany(queryOccuotion.getCompany());
		
		if(dstatus!=null) {
			cr.setDstatus(Integer.parseInt(dstatus));
		}else {
			cr.setDstatus(5);
		}
		List<Companyresume> queryAllCompanyresume = cs.queryAllCompanyresume(cr);
		for (Companyresume companyresume : queryAllCompanyresume) {
			core = new CoRe();
			Educationalbackground queryEducationalbackground = ebService.queryEducationalbackground(companyresume.getCuser().getUserid());
			if(queryEducationalbackground!=null) {
				core.setEb(queryEducationalbackground);
			}
			Selfdescription querySelfdescription = ss.querySelfdescription(companyresume.getCuser().getUserid());
			if(querySelfdescription!=null) {
				core.setSelfdescription(querySelfdescription);
			}
			Worksdisplay queryWorksdisplay = ws.queryWorksdisplay(companyresume.getCuser().getUserid());
			if(queryWorksdisplay!=null) {
				core.setWorksdisplay(queryWorksdisplay);
			}
			core.setCompanyresume(companyresume);
			coreList.add(core);
		}
		System.err.println("我是公司查看----》"+queryAllCompanyresume);
		model.addAttribute("queryAllCompanyresume", coreList);
		model.addAttribute("queryAllCompanyresumeCount", queryAllCompanyresume.size());
		
		return "main/canInterviewResumes";
	}
	
	
	@RequestMapping("doAddCompanyresume")
	public String doAddCompanyresume(Model model) {

		return "";
	}
	
	@RequestMapping("doUpdateCompanyresume")
	public String doUpdateCompanyresume(Companyresume cr,Model model) {
		
		return "";
	}
	
	@RequestMapping("doDeleteCompanyresume")
	public String doDeleteCompanyresume(Integer crid,Model model) {
		
		return "";
	}
	
	
}
