package cn.kgc.tangcco.tcmp073.qizu.recruit.project.service;

import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Project;

public interface ProjectService {
	
	
	int addProject(Project pro);

	int updateProject(Project pro);

	int deleteProject(Integer proid);
	
	Project queryProject(Integer puserid);
	
	int deleteProjectById(int pk);

}
