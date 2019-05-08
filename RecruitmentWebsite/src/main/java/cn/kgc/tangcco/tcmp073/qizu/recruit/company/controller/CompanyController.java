package cn.kgc.tangcco.tcmp073.qizu.recruit.company.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.jms.Session;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.entity.Product;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.entity.ZuHe;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.utilEmail.CEmail;
import cn.kgc.tangcco.tcmp073.qizu.recruit.product.service.ProductService;

@Controller
public class CompanyController {
	@Resource
	private CompanyService service;

	@Resource
	private ProductService proservice;

	// 跳转到公司页面
	@RequestMapping("tocompanlist")
	public String companylist() {

		return "main/companylist";
	}

	// 跳转到公司注册页面
	@RequestMapping("toNavController")
	public String toNav(HttpSession session) {
		RecruitingUsers users = (RecruitingUsers) session.getAttribute("loginUser");
		Company comm = this.service.queryByUid(users.getUserid());
		if (comm == null) {
			return "main/bindstep1";
		} else {
			return "redirect:tomyhome.controller";
		}

	}

	@RequestMapping("AddCompanyOneController")
	public String AddCompanyOne(Company com, Model model, HttpSession session) {

		RecruitingUsers user = (RecruitingUsers) session.getAttribute("loginUser");
		com.setCuid(user.getUserid());
		int row = this.service.addCompanyOne(com);
		model.addAttribute("company", this.service.queryByEmail(com.getCemail()));
		if (row > 0) {
			return "main/bindStep2";
		} else {
			return "main/bindstep1";
		}

	}

	// 123
	@RequestMapping("UpdateCNameController")
	public String updateCName(Company com, Model model, HttpSession session) {
		int row = this.service.updateCompany(com);
		if (row > 0) {
			session.setAttribute("companys", this.service.queryByEmail(com.getCemail()));
			model.addAttribute("company2", this.service.queryByEmail(com.getCemail()));
			CEmail email = new CEmail();
			email.sendEamilCode(com.getCemail());

			return "main/bindStep3";
		} else {
			return "main/bindStep2";
		}
	}

	@RequestMapping("toIndex01")
	public String toIndex01(Model model, Company com) {
		model.addAttribute("company", this.service.queryByEmail(com.getCemail()));
		return "main/index01";
	}

	//
	// @RequestMapping("ajaxUpdateCompanyTwo")
	// public String ajaxUpdateCompanyTwo(String cabbreviation,String curl,String
	// caddress,String cfield,String cfs,String cdetail,String cemail,int cid) {
	// System.out.println("+++++++++++++++++"+cabbreviation+curl+caddress+cfield+cfs+cdetail+cemail+cid);
	// this.service.queryByEmail(cemail);
	// int
	// row=this.service.updateCompanyTwo(cabbreviation,curl,caddress,cfield,cfs,cdetail,cid);
	//
	// return "main/index02";
	//
	// }
	@RequestMapping("ajaxUpdateCompanyTwo")
	public String ajaxUpdateCompanyTwo(Company com, Model model) throws IOException {
		// 保存数据库的路径
		String sqlPath = null;
		// 定义文件保存的本地路径
		File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();
		System.out.println("---------------------------我是路径---》》》》" + courseFile);
		String localPath = courseFile + "\\src\\main\\webapp\\images\\";
		// 定义 文件名
		String filename = null;
		if (!com.getFile().isEmpty()) {
			// 生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType = com.getFile().getContentType();
			// 获得文件后缀名
			String suffixName = contentType.substring(contentType.indexOf("/") + 1);
			// 得到 文件名
			filename = uuid + "." + suffixName;
			System.out.println(filename);
			// 文件保存路径
			try {
				com.getFile().transferTo(new File(localPath + filename));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		// 把图片的相对路径保存至数据库
		sqlPath = "/images/" + filename;
		System.out.println(sqlPath);
		com.setComtuxiang(sqlPath);
		int row = this.service.updateCompanyTwo(com.getCabbreviation(), com.getCurl(), com.getCaddress(),
				com.getCfield(), com.getCfs(), com.getCdetail(), com.getCscale(), com.getCid(), com.getComtuxiang());
		model.addAttribute("company", this.service.queryByEmail(com.getCemail()));
		return "main/tag";
	}

	@RequestMapping("UpdateCompanyThree")
	public String UpdateCompanyThree(Company com, Model model) {
		model.addAttribute("company", this.service.queryByEmail(com.getCemail()));
		int row = this.service.updateCompanyThree(com.getCfinancing(), com.getCid());
		return "main/founder";
	}

	@RequestMapping("UpdateCompanyProfile")
	public String updateCompanyProfile(String companyProfile, int cid) {
		int row = this.service.updateCompanyProfile(companyProfile, cid);
		if (row > 0) {
			return "main/success";
		} else {
			return "main/index03";
		}
	}

	// 去公司主页1234
	@RequestMapping("tomyhome")
	public String tomyhome(HttpSession session, Model model) {
		RecruitingUsers user = (RecruitingUsers) session.getAttribute("loginUser");

		Company com = this.service.qyeryAllCompany(user.getUserid());
		String tag = com.getCfinancing();
		String taglist[] = tag.split(",");
		model.addAttribute("taglist", taglist);
		model.addAttribute("listCompany", this.service.qyeryAllCompany(user.getUserid()));

		return "main/myhome";
	}

	@RequestMapping("tosalary")
	@ResponseBody
	public List<Company> querylikesalary(Occupation occ, Model model) {
		List<Company> querylikeoname = service.querylikeomaxsalary(occ);
		for (Company c : querylikeoname) {
			System.err.println(c.getCfinancing());
			String num = c.getCfinancing();
			// 已盗号隔开
			String[] zz = num.split("\\,");
			// 声明list集合
			List<String> bq = new ArrayList<>();
			// 遍历数组将每一个元素加到list集合中
			for (int a = 0; a < zz.length; a++) {
				System.out.println("-------这是数组------->" + zz[a]);
				bq.add(zz[a]);
			}
			for (String string : bq) {
				System.out.println("----这是集合----->" + string);
			}
			c.setBiaoqian(bq);

		}
		System.out.println(occ);
		System.out.println("_____________________<>>>>" + querylikeoname);
		return querylikeoname;
	}

	@RequestMapping("toolog")
	@ResponseBody
	public List<Company> querylikeolog(String olog) {
		List<Company> querylikeoname = service.querylikeolog(olog);
		for (Company c : querylikeoname) {
			System.err.println(c.getCfinancing());
			String num = c.getCfinancing();
			// 已盗号隔开
			String[] zz = num.split("\\,");
			// 声明list集合
			List<String> bq = new ArrayList<>();
			// 遍历数组将每一个元素加到list集合中
			for (int a = 0; a < zz.length; a++) {
				System.out.println("-------这是数组------->" + zz[a]);
				bq.add(zz[a]);
			}
			for (String string : bq) {
				System.out.println("----这是集合----->" + string);
			}
			c.setBiaoqian(bq);

		}

		System.out.println("_____________________<>>>>" + querylikeoname);
		return querylikeoname;
	}

	@RequestMapping("toename")
	@ResponseBody
	public List<Company> querylikeename(String ename) {
		List<Company> querylikeoname = service.querylikeename(ename);
		for (Company c : querylikeoname) {
			System.err.println(c.getCfinancing());
			String num = c.getCfinancing();
			// 已盗号隔开
			String[] zz = num.split("\\,");
			// 声明list集合
			List<String> bq = new ArrayList<>();
			// 遍历数组将每一个元素加到list集合中
			for (int a = 0; a < zz.length; a++) {
				System.out.println("-------这是数组------->" + zz[a]);
				bq.add(zz[a]);
			}
			for (String string : bq) {
				System.out.println("----这是集合----->" + string);
			}
			c.setBiaoqian(bq);

		}

		System.out.println("_____________________<>>>>" + querylikeoname);
		return querylikeoname;
	}

	@RequestMapping("toonature")
	@ResponseBody
	public List<Company> querylikeonature(int onature) {
		List<Company> querylikeoname = service.querylikeonature(onature);
		for (Company c : querylikeoname) {
			System.err.println(c.getCfinancing());
			String num = c.getCfinancing();
			// 已盗号隔开
			String[] zz = num.split("\\,");
			// 声明list集合
			List<String> bq = new ArrayList<>();
			// 遍历数组将每一个元素加到list集合中
			for (int a = 0; a < zz.length; a++) {
				System.out.println("-------这是数组------->" + zz[a]);
				bq.add(zz[a]);
			}
			for (String string : bq) {
				System.out.println("----这是集合----->" + string);
			}
			c.setBiaoqian(bq);

		}
     System.err.println(querylikeoname);
		System.out.println("_____________________<>>>>" + querylikeoname);
		return querylikeoname;
	}

	@RequestMapping("toorelease")
	@ResponseBody
	public List<Company> querylikeolog(int orelease) {
		List<Company> querylikeorelease = service.querylikeorelease(orelease);
		for (Company company : querylikeorelease) {
			System.err.println(company+"\t\t");
			System.out.println();
		}
		System.out.println(querylikeorelease);
		/*System.err.println(orelease);
		System.err.println(service.querylikeorelease(-30));*/
		return querylikeorelease;
	}

	// 修改公司主页的产品
	@ResponseBody
	@RequestMapping("updateProductController")
	public Company updateProduct(Product pro, HttpSession session) {
		RecruitingUsers user = (RecruitingUsers) session.getAttribute("loginUser");
		return this.service.qyeryAllCompany(user.getUserid());
	}

	@RequestMapping("queryListCompany")
	public String queryListCompany(String ocity, String cfs, String cfield, Model model) {
		System.err.println("_________________+>" + ocity);
		System.err.println("_________________+>" + cfs);
		System.err.println("_________________+>" + cfield);
		if (cfs != null || cfs != "") {
			model.addAttribute("cfs", cfs);
		}
		if (ocity != null || ocity != "") {
			model.addAttribute("ocity", ocity);
		}
		if (cfield != null || cfield != "") {
			model.addAttribute("cfield", cfield);
		}
		model.addAttribute("ListCompanys", this.service.queryListCompany(ocity, cfs, cfield));
		
		return "main/companylist";
	}
	//条件查询
		@ResponseBody
		@RequestMapping("queryListCompanyLimit")
		public PageInfo<Company> querylimit(String ocity, String cfs,String cfield,HttpSession session) {
			session.setAttribute("limitocity", ocity);
			session.setAttribute("limitcfs", cfs);
			session.setAttribute("limitcfield", cfield);
			PageInfo<Company> list=this.service.queryListCompanylimit(ocity, cfs, cfield, 1,1);
			session.setAttribute("PageNum",list.getPageNum());
			int PageSize=1,PageNum=1;
			
			return this.service.queryListCompanylimit(ocity, cfs, cfield, PageSize, PageNum);
		
		}
		//输入框页数
		@ResponseBody
		@RequestMapping("queryListCompanyLimitss")
		public PageInfo<Company> querylimits(int PageNum2,HttpSession session) {
			String ocity=(String) session.getAttribute("limitocity");
			String cfs=(String) session.getAttribute("limitcfs");
			String cfield=(String) session.getAttribute("limitcfield");
			int PageSize=1;
			session.setAttribute("aaaa", "you");
			session.setAttribute("pagenum", PageNum2);
			return this.service.queryListCompanylimit(ocity, cfs, cfield, PageSize,PageNum2);
		
		}
		
		//上下页
		@ResponseBody
		@RequestMapping("queryListCompanyLimits")
		public PageInfo<Company> querylimit(int PageNum,HttpSession session) {
			String ocity=(String) session.getAttribute("limitocity");
			String cfs=(String) session.getAttribute("limitcfs");
			String cfield=(String) session.getAttribute("limitcfield");
			int PageSize=1;
			int PageNum2;
			int pageNum;
			String pagenum=(String) session.getAttribute("aaaa");
			if(pagenum==null) {
				pageNum=1;
			}else {
				pageNum=(int) session.getAttribute("pagenum");
				System.err.println("=====================>"+pageNum);
			}
			PageInfo<Company> list=this.service.queryListCompanylimit(ocity, cfs, cfield, PageSize,pageNum);
			if(PageNum==1) {
				PageNum2=1;
			}else if(PageNum==2) {
				PageNum2=list.getPrePage();
				session.setAttribute("aaaa", "you");
				session.setAttribute("pagenum", list.getPageNum()-1);
			}else if(PageNum==3) {
				PageNum2=list.getNextPage();
				session.setAttribute("aaaa", "you");
				session.setAttribute("pagenum", list.getPageNum()+1);
			}else{
				PageNum2=list.getPages();
			}	
			return this.service.queryListCompanylimit(ocity, cfs, cfield, PageSize,PageNum2);
		
		}

		@ResponseBody
		@RequestMapping("qeryxuheController")
		public PageInfo<Company> queryzuhe(Model model,ZuHe zuhe,HttpSession session) 
		{
			int PageSize=10;
			int PageNum=1;
		  session.setAttribute("zuhe",zuhe);
			return this.service.querytoZuhe(zuhe, PageSize, PageNum);
		}
		
		//公司页面的公司简称 介绍的修改
		@RequestMapping("UpdateCompany")
		public String updateCompany(String cabbreviation,String cdetail,int cid) {
			System.err.println("=======================>"+cabbreviation+"+"+cdetail+"+"+cid);
			int row=this.service.UpdateCompanyById(cabbreviation, cdetail, cid);
			return "redirect:tomyhome.controller";
		}
		//公司页面修改公司简介
		@RequestMapping("UpdateCompanyProfiles")
		public String UpdateCompanyProfiles(int cid,String companyProfile) {
			int row=this.service.updateCompanyProfile(companyProfile, cid);
			return "redirect:tomyhome.controller";
		}
		//公司页面修改 地址 网址 领域 规模
		@RequestMapping("UpdateCompanys")
		public String updateCompanys(String caddress,String curl,String cfield,String cscale,int cid) {
			int row=this.service.updateCompanys(caddress, curl, cfield, cscale,cid);
			return "redirect:tomyhome.controller";
		}
		//去公司认证页面
		@RequestMapping("toauth")
		public String toauth() {

			return "main/auth";
		}
}
