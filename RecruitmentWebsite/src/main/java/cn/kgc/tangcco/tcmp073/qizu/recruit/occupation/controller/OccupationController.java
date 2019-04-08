package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service.OccupationService;

@Controller
public class OccupationController {
	@Resource
	private OccupationService service;
	@Resource
	private CompanyService comservice;
	@RequestMapping("tocreate")
	public String tocreate(Model model,HttpSession session) {
		RecruitingUsers user=(RecruitingUsers) session.getAttribute("loginUser");
		Company con=(Company) this.comservice.queryByUid(user.getUserid());
		session.setAttribute("companys",this.comservice.queryByUid(user.getUserid()));
		
		return "main/create";
	}
	
	/**
	 * 跳转投递职位页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toToudi")
	public String toToudi(Model model) {
		return "main/toudi";
	}
	@RequestMapping("toZhiye")
	public String toZhiye(Model model) {
		return "main/list";
	}
	
	@RequestMapping("doAddOccupation")
	public String doAdd(Occupation occ,HttpSession session) {
		RecruitingUsers user=(RecruitingUsers) session.getAttribute("loginUser");
		Company con=(Company) this.comservice.queryByUid(user.getUserid());
		occ.setOcid(con.getCid());
		occ.setOstate(0);
		int row=this.service.addOccupation(occ);
		if(row>0) {
			return "main/index06";
		}else {
			return "main/create";
		}
		
	}
	//查看状态已下线和未下线的职位
	@RequestMapping("queryByOstateController")
	public String queryByOstate(int pk,int ostate,Model model) {
		List<Occupation> occ=this.service.queryBystate(pk, ostate);
		int size=occ.size();
		model.addAttribute("ostate", ostate);
		model.addAttribute("size", size);
		model.addAttribute("Occupation", this.service.queryBystate(pk, ostate));
		return "main/positions";
	}
	@RequestMapping("deleteOccupation")
	public String deleteOccupation(int oid,int ostate,int pk,Model model) {
		this.service.deleteOccupation(oid);
		List<Occupation> occ=this.service.queryBystate(pk, ostate);
		int size=occ.size();
		model.addAttribute("ostate", ostate);
		model.addAttribute("size", size);
		model.addAttribute("Occupation", this.service.queryBystate(pk, ostate));
		
		return "main/positions";
	}
	@RequestMapping("updateOstate")
	public String updateOstate(int oid,int ostates,Model model,int pk,int ostate) {
		this.service.updateOccupation(oid,ostates);
		List<Occupation> occ=this.service.queryBystate(pk, ostate);
		int size=occ.size();
		model.addAttribute("ostate", ostate);
		model.addAttribute("size", size);
		model.addAttribute("Occupation", this.service.queryBystate(pk, ostate));
		return "main/positions";
	}
	
	
}
