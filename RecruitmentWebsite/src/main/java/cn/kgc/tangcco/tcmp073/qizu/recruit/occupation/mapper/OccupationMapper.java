package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.mapper;

import org.apache.ibatis.annotations.Insert;

import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;

public interface OccupationMapper {
	@Insert("INSERT INTO recruitdb.occupation VALUES(default, #{oname}, #{odepartment}, #{onature}, #{ominsalary}, #{omaxsalary}, #{ocity}, #{olog}, #{oeducation}, #{owelfare}, #{odetail}, #{oaddress}, #{oemail}, #{ophone}, #{ostate}, NOW(), #{otype},#{ocid});")	
	int addOccupation(Occupation occ);
}
