package cn.kgc.tangcco.tcmp073.qizu.recruit.company.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.entity.ZuHe;

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

	

	Company queryByUid(int userid);
	List<Company> querylikeoname(String oname);
	List<Company> querylikeomaxsalary(Occupation occ);

	List<Company> querylikeolog(String olog);

	List<Company> querylikeename(String ename);

	List<Company> querylikeonature(int onature);

	List<Company> querylikeorelease(int orelease);
	List<Company> querytooccname(String ocname);
	PageInfo<Company> querytoZuhe(ZuHe zuhe, int PageSize, int PageNum);

	// 123
	/**
	 * 许茂峰
	 * 
	 * @param cid
	 * @return
	 */
	Company queryCompanyByCid(Integer cid);
	//公司页面查询方法
	List<Company> queryListCompany(String ocity,String cfs,String cfield);
	PageInfo<Company> queryListCompanylimit(String ocity,String cfs,String cfield,int PageSize,int PageNum);
}
