package cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Companyresume;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.service.CompanyresumeService;

@Controller
public class CompanyresumeController {

	@Resource
	private CompanyresumeService cs;
	
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
		Companyresume cr = new Companyresume();
		cr.setCuser(attribute);
		if(dstatus!=null) {
			cr.setDstatus(Integer.parseInt(dstatus));
		}
		List<Companyresume> queryAllCompanyresume = cs.queryAllCompanyresume(cr);
		System.err.println("我是公司查看----》"+queryAllCompanyresume);
		model.addAttribute("queryAllCompanyresume", queryAllCompanyresume);
		
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
