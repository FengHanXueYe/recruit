package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service.OccupationService;

@Controller
public class OccupationController {
	@Resource
	private OccupationService service;
	@RequestMapping("tocreate")
	public String tocreate() {
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
		Company con=(Company) session.getAttribute("companys");
		occ.setOcid(con.getCid());
		occ.setOstate(0);
		int row=this.service.addOccupation(occ);
		if(row>0) {
			return "main/index06";
		}else {
			return "main/create";
		}
		
	}
	
	
	
	
	
}
