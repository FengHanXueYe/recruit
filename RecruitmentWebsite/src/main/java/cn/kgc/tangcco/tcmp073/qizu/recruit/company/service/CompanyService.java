package cn.kgc.tangcco.tcmp073.qizu.recruit.company.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;

public interface CompanyService {
	int addCompanyOne(Company com);
	Company queryByEmail(String cemail);
	int updateCompany(Company com);
	int updateCompanyTwo(String cabbreviation,String curl,String caddress,String cfield,String cfs,String cdetail,String cscale,int cid);
	int updateCompanyThree(String cfinancing,int cid);
	int updateCompanyProfile(String companyProfile,int cid);
	Company qyeryAllCompany(int cuid);
	List<Company> queryalltoFounder();
	 List<Company> queryalltozuixin();
	 Company queryByUid(int userid);
	//123
	 /**
	  * 许茂峰
	  * @param cid
	  * @return
	  */
	 Company queryCompanyByCid(Integer cid);
	 
}
