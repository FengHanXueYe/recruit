package cn.kgc.tangcco.tcmp073.qizu.recruit.project.service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Project;

public interface ProjectService {
	
	
	int addProject(Project pro);

	int updateProject(Project pro);

	int deleteProject(Integer proid);
	
	Project queryProject(Integer puserid);

}
