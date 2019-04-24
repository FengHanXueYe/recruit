package cn.kgc.tangcco.tcmp073.qizu.recruit.company.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;

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
}
