package cn.kgc.tangcco.tcmp073.qizu.recruit.project.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import cn.kgc.tangcco.tcmp073.qizu.entity.Project;

public interface ProjectMapper {
	
//	private String pname,pposition;
//	private Date pyear,pyearover;
//	private String pdescribe;
//	private Integer puserid;
	
	
	@Insert(value = "insert into project value(null,#{pro.pname},#{pro.pposition},#{pro.pyear},#{pro.pyearover},#{pro.pdescribe},#{pro.puserid})")
	int addProject(@Param("pro")Project pro);

	int updateProject(@Param("pro") Project pro);

	@Delete(value = "delete from project where pid=#{proid}")
	int deleteProject(@Param("proid") Integer proid);
	
	@Select(value="SELECT * FROM `Project` e,`recruitingusers` r WHERE r.userid=e.puserid AND r.userid=#{puserid} LIMIT 1;")
	Project queryProject(@Param("puserid")Integer puserid);

}
