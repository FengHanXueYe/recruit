package cn.kgc.tangcco.tcmp073.qizu.recruit.project.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Project;
import cn.kgc.tangcco.tcmp073.qizu.recruit.project.mapper.ProjectMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.project.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Resource
	private ProjectMapper proMapper;
	
	
	@Override
	public int addProject(Project pro) {
		return proMapper.addProject(pro);
	}

	@Override
	public int updateProject(Project pro) {
		return proMapper.updateProject(pro);
	}

	@Override
	public int deleteProject(Integer proid) {
		return proMapper.deleteProject(proid);
	}

	@Override
	public Project queryProject(Integer puserid) {
		return proMapper.queryProject(puserid);
	}

}
