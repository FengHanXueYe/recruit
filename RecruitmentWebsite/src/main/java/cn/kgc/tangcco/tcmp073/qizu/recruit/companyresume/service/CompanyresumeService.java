package cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.service;

import java.util.List;


import cn.kgc.tangcco.tcmp073.qizu.entity.Companyresume;

public interface CompanyresumeService {
	
	int addCompanyresume(Companyresume cr);
	
	int updateCompanyresume(Companyresume cr);
	
	int deleteCompanyresume(Integer crid);
	
	List<Companyresume> queryAllCompanyresume(Companyresume cr);
	
}
