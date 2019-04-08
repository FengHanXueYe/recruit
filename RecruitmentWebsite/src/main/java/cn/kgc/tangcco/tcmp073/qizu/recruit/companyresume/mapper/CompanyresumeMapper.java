package cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Companyresume;

public interface CompanyresumeMapper {
	@Insert("insert into Companyresume value(null,#{cr.company.cid},#{cr.occupation.oid},#{cr.cuser.userid},#{cr.dstatus},default,null)")
	int addCompanyresume(@Param("cr")Companyresume cr);
	
	int updateCompanyresume(@Param("cr")Companyresume cr);
	
	@Delete("delete from Companyresume where crid=#{crid}")
	int deleteCompanyresume(@Param("crid")Integer crid);
	
	List<Companyresume> queryAllCompanyresume(@Param("cr")Companyresume cr);
	
	
}
