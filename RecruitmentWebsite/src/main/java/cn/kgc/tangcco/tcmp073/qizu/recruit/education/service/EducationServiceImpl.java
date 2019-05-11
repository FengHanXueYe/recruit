package cn.kgc.tangcco.tcmp073.qizu.recruit.education.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.recruit.education.mapper.EducationaMapper;

@Service
public class EducationServiceImpl implements EducationService {

	@Resource
	private EducationaMapper educationMapper;
	
	@Override
	public int deleteEducationaById(int pk) {
		return educationMapper.deleteEducationaById(pk);
	}

}
