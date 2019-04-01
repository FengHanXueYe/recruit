package cn.kgc.tangcco.tcmp073.qizu.recruit.company.service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;

public interface CompanyService {
	int addCompanyOne(Company com);
	Company queryByEmail(String cemail);
	int updateCompany(Company com);
	int updateCompanyTwo(String cabbreviation,String curl,String caddress,String cfield,String cfs,String cdetail,String cscale,int cid);
	int updateCompanyThree(String cfinancing,int cid);
	int updateCompanyProfile(String companyProfile,int cid);
	Company qyeryAllCompany(int cuid);
	//123
}
