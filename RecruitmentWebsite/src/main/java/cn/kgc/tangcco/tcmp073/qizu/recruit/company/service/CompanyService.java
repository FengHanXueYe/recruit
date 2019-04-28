package cn.kgc.tangcco.tcmp073.qizu.recruit.company.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.github.pagehelper.PageInfo;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;

public interface CompanyService {
	int addCompanyOne(Company com);

	Company queryByEmail(String cemail);

	int updateCompany(Company com);

	int updateCompanyTwo(String cabbreviation, String curl, String caddress, String cfield, String cfs, String cdetail,
			String cscale, int cid,String comtuxiang);

	int updateCompanyThree(String cfinancing, int cid);

	int updateCompanyProfile(String companyProfile, int cid);

	Company qyeryAllCompany(int cuid);
	//a

	List<Company> queryalltoFounder();

	List<Company> queryalltozuixin();

	List<Company> querylikeoname(String oname);

	Company queryByUid(int userid);

	List<Company> querylikeomaxsalary(Occupation occ);

	List<Company> querylikeolog(String olog);

	List<Company> querylikeename(String ename);

	List<Company> querylikeonature(int onature);

	List<Company> querylikeorelease(int orelease);
	List<Company> querytooccname(String ocname);

	// 123
	/**
	 * 许茂峰
	 * 
	 * @param cid
	 * @return
	 */
	Company queryCompanyByCid(Integer cid);
	//公司页面查询方法
	PageInfo<Company> queryListCompany(String ocity,String cfs,String cfield);
	PageInfo<Company> queryListCompanylimit(String ocity,String cfs,String cfield,int PageSize,int PageNum);
	//公司页面的公司简称 介绍的修改
	int UpdateCompanyById(String cabbreviation,String companyProfile,int cid);
	//公司页面修改公司介绍
	int updateCompanyProfileById(String companyProfile,int cid);
	//公司页面修改 地址 网址 领域 规模
	int updateCompanys(String caddress,String curl,String cfield,String cscale,int cid);
		
}
