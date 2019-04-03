package cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.mapper.CompanyMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
@Controller
public class CompanyServiceImpl implements CompanyService {
	//123
	@Resource
	private CompanyMapper mapper;
	@Override
	public int addCompanyOne(Company com) {
		return mapper.addCompanyOne(com);
	}
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
			String cdetail,String cscale,int cid) {
		return mapper.updateCompanyTwo(cabbreviation, curl, caddress, cfield, cfs, cdetail,cscale,cid);
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
	
	//1232
}
