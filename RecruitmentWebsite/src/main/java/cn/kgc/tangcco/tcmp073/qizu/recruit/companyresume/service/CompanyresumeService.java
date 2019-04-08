package cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Companyresume;
import cn.kgc.tangcco.tcmp073.qizu.entity.CpCy;

public interface CompanyresumeService {
	
	int addCompanyresume(Companyresume cr);
	
	int updateCompanyresume(Companyresume cr);
	
	int deleteCompanyresume(Integer crid);
	
	List<Companyresume> queryAllCompanyresume(Companyresume cr);
	
	Companyresume queryOccuotion(Integer userid);
	
	Companyresume detailCompanyresume(Integer crid);
	
}
