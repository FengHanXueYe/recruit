package cn.kgc.tangcco.tcmp073.qizu.recruit.recommendVO.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.HopeJob;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecommendVO;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.service.HopeJobService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.recommendVO.service.RecommendVOService;

@Controller
public final class RecommendVOController {
	
	@Resource
	private RecommendVOService recommendVOService;
	
	@Resource
	private HopeJobService hopeJobService;
	
	@RequestMapping("doQueryRecommendVO")
	public String doQueryRecommendVO(HttpSession session,Model model) {
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		RecommendVO rvo = new RecommendVO();
		
		String xl = "";
		if(attribute.getUserlog()!=null) {
			if(attribute.getUserlog()==1) {
				xl = "应届毕业生";
			}else if(attribute.getUserlog()==2) {
				xl = "1";
			}else if(attribute.getUserlog()==3) {
				xl = "2";
			}else if(attribute.getUserlog()==4) {
				xl = "3";
			}else if(attribute.getUserlog()==5) {
				xl = "4";
			}else if(attribute.getUserlog()==6) {
				xl = "5";
			}else if(attribute.getUserlog()==7) {
				xl = "6";
			}else if(attribute.getUserlog()==8) {
				xl = "7";
			}else if(attribute.getUserlog()==9) {
				xl = "8";
			}else if(attribute.getUserlog()==10) {
				xl = "9";
			}else if(attribute.getUserlog()==11) {
				xl = "10";
			}else{
				xl = "以上";
			}
			Occupation occ = new Occupation();
			occ.setOlog(xl);
			rvo.setOccupation(occ);
			System.err.println("-----1------"+occ.getOlog());
		}
		if(attribute.getEducation()!=null){
			rvo.setRuser(attribute);
			System.err.println("-----2------"+attribute.getEducation());
		}
		HopeJob detailHopeJob = hopeJobService.detailHopeJob(attribute.getUserid());
		if(detailHopeJob.getHname()!=null) {
			rvo.setHopeJob(detailHopeJob);
			System.err.println("-----3------"+detailHopeJob.getHname());
		}
		List<RecommendVO> queryRecommendVO = recommendVOService.queryRecommendVO(rvo);
		model.addAttribute("queryRecommendVO", queryRecommendVO);
		
		return "main/mList";
	}
	
	
	
}
