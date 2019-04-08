package cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.mapper.CompanyMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;

@Controller
public class CompanyServiceImpl implements CompanyService {
	// 123
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
			String cdetail, String cscale, int cid) {
		return mapper.updateCompanyTwo(cabbreviation, curl, caddress, cfield, cfs, cdetail, cscale, cid);
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
	public List<Company> querylikeomaxsalary(double omaxsalary, double ominsalary) {
		return mapper.querylikeomaxsalary(omaxsalary, ominsalary);
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

	// 1232
}
