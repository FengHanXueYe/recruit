package cn.kgc.tangcco.tcmp073.qizu.recruit.education.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.Education;

public interface EducationaMapper {
	@Select(value="select * from education")
	List<Education> queryAllEducation();
	
	@Delete("DELETE FROM educationalbackground WHERE puserid=#{id}")
	int deleteEducationaById(@Param("id")int pk);
	
	
	
}
