package cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.entity.CoRe;
import cn.kgc.tangcco.tcmp073.qizu.entity.Companyresume;
import cn.kgc.tangcco.tcmp073.qizu.entity.CpCy;
import cn.kgc.tangcco.tcmp073.qizu.entity.Deliverypost;
import cn.kgc.tangcco.tcmp073.qizu.entity.Educationalbackground;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.entity.Selfdescription;
import cn.kgc.tangcco.tcmp073.qizu.entity.Worksdisplay;
import cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.service.CompanyresumeService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.service.DeliverypostService;
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

	@Resource
	private DeliverypostService ds;

	/**
	 * 查询收到的简历
	 * 
	 * @param dstatus
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doListCompanyresume")
	public String doListCompanyresume(String dstatus, HttpSession session, Model model) {
		// 从session中取用户
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		List<CoRe> coreList = new ArrayList<>();
		CoRe core = null;
		Companyresume cr = new Companyresume();

		Companyresume queryOccuotion = cs.queryOccuotion(attribute.getUserid());
		
		System.out.println(queryOccuotion + "--------------------" + attribute.getUserid());
		if(queryOccuotion!=null) {
			cr.setCompany(queryOccuotion.getCompany());
			if (dstatus != null) {
				cr.setDstatus(Integer.parseInt(dstatus));
			} else {
				cr.setDstatus(5);
			}
			List<Companyresume> queryAllCompanyresume = cs.queryAllCompanyresume(cr);
			for (Companyresume companyresume : queryAllCompanyresume) {
				core = new CoRe();
				Educationalbackground queryEducationalbackground = ebService
						.queryEducationalbackground(companyresume.getCuser().getUserid());
				if (queryEducationalbackground != null) {
					core.setEb(queryEducationalbackground);
				}
				Selfdescription querySelfdescription = ss.querySelfdescription(companyresume.getCuser().getUserid());
				if (querySelfdescription != null) {
					core.setSelfdescription(querySelfdescription);
				}
				Worksdisplay queryWorksdisplay = ws.queryWorksdisplay(companyresume.getCuser().getUserid());
				if (queryWorksdisplay != null) {
					core.setWorksdisplay(queryWorksdisplay);
				}
				core.setCompanyresume(companyresume);
				coreList.add(core);
			}
			System.err.println("我是公司查看----》" + queryAllCompanyresume);
			model.addAttribute("queryAllCompanyresume", coreList);
			model.addAttribute("queryAllCompanyresumeCount", queryAllCompanyresume.size());
		}


		return "main/canInterviewResumes";
	}

	@RequestMapping("doAddCompanyresume")
	public String doAddCompanyresume(Model model) {

		return "";
	}

	@RequestMapping("doUpdateCompanyresume")
	public String doUpdateCompanyresume(Companyresume cr, Model model) {

		return "";
	}

	@RequestMapping("doDeleteCompanyresume")
	public String doDeleteCompanyresume(Integer crid, Model model) {

		return "";
	}

	/**
	 * ajax修改简历状态
	 * 
	 * @param dstatus
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxUpdateCompanyresume")
	public boolean ajaxUpdateCompanyresume(String dstatus, String crid, Model model) {
		// 实例公司查看投递简历实体
		Companyresume cr = new Companyresume();
		// 赋值id
		cr.setCrid(Integer.parseInt(crid));
		// 赋值状态
		cr.setDstatus(Integer.parseInt(dstatus));
		// 根据id查询投递用户，职位
		Companyresume detailCompanyresume = cs.detailCompanyresume(Integer.parseInt(crid));
		// 实例投递简历实例
		Deliverypost dp = new Deliverypost();
		// 实例用户实体
		RecruitingUsers ruser = new RecruitingUsers();
		// 将公司查看投递简历的用户的id赋值给投递的用户
		ruser.setUserid(detailCompanyresume.getCuser().getUserid());
		// 将用户的id赋值给Deliverypost
		dp.setRuser(ruser);
		// 实例职位实体
		Occupation occ = new Occupation();
		// 将查询到的职位的id给Occupation
		occ.setOid(detailCompanyresume.getOccupation().getOid());
		// 给Deliverypost中的职位对象赋值
		dp.setOccupation(occ);
		// 通过用户的id和职位的id查询投递职位的id
		Deliverypost detailDeliverypost = ds.detailDeliverypost(dp);
		// 修改Deliverypost的状态
		detailDeliverypost.setDstatus(Integer.parseInt(dstatus));
		System.out.println("5555---55555>>>" + detailDeliverypost);
		// 实现修改两个表的状态
		int updateDeliverypost = ds.updateDeliverypost(detailDeliverypost);
		int updateCompanyresume = cs.updateCompanyresume(cr);
		System.out.println(dstatus + "_________________>>>>" + crid);
		if (updateCompanyresume > 0 && updateDeliverypost > 0) {
			return true;
		} else {
			return false;
		}
	}

	@ResponseBody
	@RequestMapping("ajaxLookStatus")
	public List<CoRe> ajaxLookStatus(String zt,HttpSession session, Model model) {
		// 从session中取用户
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		List<CoRe> coreList = new ArrayList<>();
		CoRe core = null;
		Companyresume cr = new Companyresume();

		Companyresume queryOccuotion = cs.queryOccuotion(attribute.getUserid());

		System.out.println(queryOccuotion + "--------------------" + attribute.getUserid());
		cr.setCompany(queryOccuotion.getCompany());

		if (zt != null) {
			cr.setDstatus(Integer.parseInt(zt));
		} else {
			cr.setDstatus(5);
		}
		List<Companyresume> queryAllCompanyresume = cs.queryAllCompanyresume(cr);
		for (Companyresume companyresume : queryAllCompanyresume) {
			core = new CoRe();
			Educationalbackground queryEducationalbackground = ebService
					.queryEducationalbackground(companyresume.getCuser().getUserid());
			if (queryEducationalbackground != null) {
				core.setEb(queryEducationalbackground);
			}
			Selfdescription querySelfdescription = ss.querySelfdescription(companyresume.getCuser().getUserid());
			if (querySelfdescription != null) {
				core.setSelfdescription(querySelfdescription);
			}
			Worksdisplay queryWorksdisplay = ws.queryWorksdisplay(companyresume.getCuser().getUserid());
			if (queryWorksdisplay != null) {
				core.setWorksdisplay(queryWorksdisplay);
			}
			core.setCompanyresume(companyresume);
			coreList.add(core);
		}
		System.err.println("我是公司查看----》" + queryAllCompanyresume);
		return coreList;
	}

}
