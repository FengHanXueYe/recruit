package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;

public interface OccupationMapper {
	@Insert("INSERT INTO recruitdb.occupation VALUES(default, #{oname}, #{odepartment}, #{onature}, #{ominsalary}, #{omaxsalary}, #{ocity}, #{olog}, #{oeducation}, #{owelfare}, #{odetail}, #{oaddress}, #{oemail}, #{ophone}, #{ostate}, NOW(), #{otype},#{ocid});")	
	int addOccupation(Occupation occ);
	List<Occupation> queryall();//热门搜索
	
	
	Occupation queryOccupation(@Param("oid")Integer oid);
	List<Occupation> querylike(String oname);
	
}
