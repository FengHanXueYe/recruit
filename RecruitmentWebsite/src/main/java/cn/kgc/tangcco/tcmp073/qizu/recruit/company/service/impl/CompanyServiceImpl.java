package cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.entity.ZuHe;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.mapper.CompanyMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;

@Controller
public class CompanyServiceImpl implements CompanyService {
	// 1234   4
	@Resource
	private CompanyMapper mapper;

	@Override
	public int addCompanyOne(Company com) {
		return mapper.addCompanyOne(com);
	}
//a
	@Override
	public Company queryByEmail(String cemail) {
		return mapper.queryByEmail(cemail);
	}

	@Override
	public int updateCompany(Company com) {
		return mapper.updateCompany(com);
	}

	@Override
	public int updateCompanyTwo(String cabbreviation, String curl, String caddress, String cfield, String cfs,
			String cdetail, String cscale, int cid,String comtuxiang) {
		return mapper.updateCompanyTwo(cabbreviation, curl, caddress, cfield, cfs, cdetail, cscale, cid,comtuxiang);
	}

	@Override
	public int updateCompanyThree(String cfinancing, int cid) {
		return mapper.updateCompanyThree(cfinancing, cid);
	}

	@Override
	public int updateCompanyProfile(String companyProfile, int cid) {
		return mapper.updateCompanyProfile(companyProfile, cid);
	}

	@Override
	public Company qyeryAllCompany(int cuid) {
		return mapper.qyeryAllCompany(cuid);
	}

	@Override
	public List<Company> queryalltoFounder() {
		return mapper.queryalltoFounder();
	}

	@Override
	public List<Company> queryalltozuixin() {
		return mapper.queryalltozuixin();
	}

	@Override
	public Company queryByUid(int userid) {
		return mapper.queryByUid(userid);
	}

	@Override
	public Company queryCompanyByCid(Integer cid) {
		return mapper.queryCompanyByCid(cid);
	}

	@Override
	public List<Company> querylikeoname(String oname) {
		return mapper.querylikeoname(oname);
	}

	@Override
	public List<Company> querylikeomaxsalary(Occupation occ) {
		return mapper.querylikeomaxsalary(occ);
	}

	@Override
	public int deleteAdminCompanys(int pk) {
		return mapper.deleteAdminCompanys(pk);
	}
	
	@Override
	public List<Company> querylikeolog(String olog) {
		return mapper.querylikeolog(olog);
	}

	@Override
	public List<Company> querylikeename(String ename) {
		return mapper.querylikeename(ename);
	}

	@Override
	public List<Company> querylikeonature(int onature) {
		return mapper.querylikeonature(onature);
	}

	@Override
	public List<Company> querylikeorelease(int orelease) {
		return mapper.querylikeorelease(orelease);
	}
	@Override
	public PageInfo<Company> queryListCompany(String ocity, String cfs, String cfield) {
		PageHelper.startPage(1, 9);
		List<Company> list = mapper.queryListCompanylimit(ocity, cfs, cfield);
		PageInfo<Company> pageInfo = new PageInfo<>(list);
		return pageInfo;
	
	}
	@Override
	public List<Company> querytooccname(String ocname) {
		return mapper.querytooccname(ocname);
	}
	@Override
	public PageInfo<Company> queryListCompanylimit(String ocity, String cfs, String cfield, int PageSize, int PageNum) {
		PageHelper.startPage(PageNum, PageSize);
		List<Company> list = mapper.queryListCompanylimit(ocity, cfs, cfield);
		PageInfo<Company> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	//公司页面的公司简称 介绍的修改
	@Override
	public int UpdateCompanyById(String cabbreviation, String companyProfile, int cid) {
		return mapper.UpdateCompanyById(cabbreviation, companyProfile, cid);
	}
	@Override
	public int updateCompanyProfileById(String companyProfile, int cid) {
		return mapper.updateCompanyProfileById(companyProfile, cid);
	}
	@Override
	public int updateCompanys(String caddress, String curl, String cfield, String cscale,int cid) {
		return mapper.updateCompanys(caddress, curl, cfield, cscale,cid);
	}
	@Override
	public PageInfo<Company> querytoZuhe(ZuHe zuhe, int PageSize, int PageNum) {
		
		return null;
	}
	
	@Override
	public List<Company> queryAllCompany(String cname) {
		List<Company> com=mapper.queryAllCompany(cname);
		
		//PageHelper.startPage(1,3);
//		List<Company> list = mapper.queryAllCompany();
//		PageInfo<Company> pageInfo = new PageInfo<>(list);
		return mapper.queryAllCompany(cname);
	}
	@Override
	public int updateCompanys(Company com) {
		return mapper.updateCompanyss(com);
	}
}
