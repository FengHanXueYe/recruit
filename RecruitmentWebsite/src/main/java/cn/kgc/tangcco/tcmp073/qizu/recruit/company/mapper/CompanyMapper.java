package cn.kgc.tangcco.tcmp073.qizu.recruit.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.entity.ZuHe;

public interface CompanyMapper {
	@Insert("INSERT INTO recruitdb.company (cid,cuid,cphone, cemail ) VALUES(DEFAULT,#{cuid},#{cphone},#{cemail});")
	int addCompanyOne(Company com);

	@Select("select * from company where cemail=#{cemail}")
	Company queryByEmail(String cemail);

	@Update("update company set cname=#{cname} where cid=#{cid}")
	int updateCompany(Company com);

	@Update("update company set comtuxiang=#{comtuxiang},cabbreviation=#{cabbreviation},curl=#{curl},caddress=#{caddress},cfield=#{cfield},cfs=#{cfs},cdetail=#{cdetail},cscale=#{cscale} where cid=#{cid}")
	int updateCompanyTwo(@Param("cabbreviation") String cabbreviation, @Param("curl") String curl,
			@Param("caddress") String caddress, @Param("cfield") String cfield, @Param("cfs") String cfs,
			@Param("cdetail") String cdetail, @Param("cscale") String cscale, @Param("cid") int cid,@Param("comtuxiang")String comtuxiang);

	@Update("update company set cfinancing=#{cfinancing} where cid=#{cid}")
	int updateCompanyThree(@Param("cfinancing") String cfinancing, @Param("cid") int cid);

	@Update("update company set companyProfile=#{companyProfile} where cid=#{cid}")
	int updateCompanyProfile(@Param("companyProfile") String companyProfile, @Param("cid") int cid);

	List<Company> queryalltoFounder();

	List<Company> queryalltozuixin();

	List<Company> querylikeoname(@Param("oname") String oname);

	List<Company> querylikeomaxsalary(Occupation occ);

	List<Company> querylikeolog(String olog);

	List<Company> querylikeename(String ename);

	List<Company> querylikeonature(int onature);

	List<Company> querylikeorelease(int orelease);
	//aa
	List<Company> querytooccname(String ocnames);
	List<Company> querytoZuhe(@Param("zuhe")ZuHe zuhe);

	Company qyeryAllCompany(int cuid);

	Company queryByUid(int cuid);

	/**
	 * 许茂峰（查询公司详情根据公司id）
	 */
	Company queryCompanyByCid(@Param("cid") Integer cid);
	//公司页面查询方法
	List<Company> queryListCompany(@Param("ocity")String ocity,@Param("cfs")String cfs,@Param("cfield")String cfield);
	//ajax查询公司
	List<Company> queryListCompanylimit(@Param("ocity")String ocity,@Param("cfs")String cfs,@Param("cfield")String cfield);
	//公司页面的公司简称 介绍的修改
	@Update("update company set cabbreviation=#{cabbreviation},cdetail=#{cdetail}  where cid=#{cid}")
	int UpdateCompanyById(@Param("cabbreviation")String cabbreviation,@Param("cdetail")String cdetail,@Param("cid")int cid);
	//公司页面修改公司介绍
	@Update("update company set companyProfile=#{companyProfile}  where cid=#{cid}")
	int updateCompanyProfileById(@Param("companyProfile")String companyProfile,@Param("cid")int cid);
	//公司页面修改 地址 网址 领域 规模
	@Update("UPDATE company SET caddress=#{caddress},curl=#{curl},cfield=#{cfield},cscale=#{cscale} where cid=#{cid}")
	int updateCompanys(@Param("caddress")String caddress,@Param("curl")String curl,@Param("cfield")String cfield,@Param("cscale")String cscale,@Param("cid")int cid);
	//公司后台的查看方法
	List<Company> queryAllCompany(@Param("cname")String cname);
	//公司后台修改方法
	@Update("UPDATE recruitdb.company SET cphone=#{com.cphone},cdetail=#{com.cdetail},caddress=#{com.caddress},cemail =#{com.cemail},cname=#{com.cname},cabbreviation=#{com.cabbreviation},curl=#{com.curl},companyProfile=#{com.companyProfile}  WHERE cid =#{com.cid}")
	int updateCompanyss(@Param("com")Company com);
	
	








}
