package cn.kgc.tangcco.tcmp073.qizu.recruit.collectionp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.entity.Collectionp;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.collectionp.service.CollectionService;

@Controller
public class CollectionpController {

	
	@Resource
	private CollectionService cs;
	
	/**
	 * 查询用户收藏的职位
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doListCollectionp")
	public String doListCollectionp(HttpSession session,Model model) {
		//从session中取用户
		RecruitingUsers attribute =(RecruitingUsers) session.getAttribute("loginUser");
		System.out.println("-----doListCollectionp----->"+attribute);
		List<Collectionp> queryAllUserCollectionp = cs.queryAllUserCollectionp(attribute.getUserid());
		model.addAttribute("queryAllUserCollectionp", queryAllUserCollectionp);
		System.err.println("--我的收藏职位--"+queryAllUserCollectionp);
		return "main/collections";
	}
	/**
	 * 判断职位是否被收藏&增加
	 * @param oid
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxQueryAllUserCollectionp")
	public boolean ajaxQueryAllUserCollectionp(Integer oid,HttpSession session,Model model) {
		//得到用户
		RecruitingUsers attribute =(RecruitingUsers) session.getAttribute("loginUser");
		//实例收藏
		Collectionp c = new Collectionp();
		//将用户信息传给收藏表中的用户属性
		c.setCuser(attribute);
		//实例职业
		Occupation o = new Occupation();
		//将前台传来的职业id赋值给职业实体
		o.setOid(oid);
		//将职业赋值给收藏表中的职业属性
		c.setOccupation(o);
		//查询用户是已经收藏此职业
		Collectionp queryAllOccupationCollectionp = cs.queryAllOccupationCollectionp(c);
		//判断为null则没收藏
		if(queryAllOccupationCollectionp==null) {
			//为给用户收藏此职位
			cs.addCollectionp(c);
			return true;
		}else {
			cs.deleteCollectionp(queryAllOccupationCollectionp.getCid());
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping("doDeleteCollectionp")
	public boolean doDeleteCollectionp(Integer cid,Model model) {
		if(cs.deleteCollectionp(cid)>0) {
			cs.deleteCollectionp(cid);
			return true;
		}else {
			return false;
		}
	}
	
	
}
