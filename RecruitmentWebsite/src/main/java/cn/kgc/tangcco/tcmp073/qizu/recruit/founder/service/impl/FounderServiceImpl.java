package cn.kgc.tangcco.tcmp073.qizu.recruit.founder.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Founder;
import cn.kgc.tangcco.tcmp073.qizu.recruit.founder.mapper.FounderMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.founder.service.FounderService;
@Service
public class FounderServiceImpl implements FounderService {
	
	@Resource
	private FounderMapper mapper;
	@Override
	public int addFounder(Founder founder) {
		return mapper.addFounder(founder);
	}
	@Override
	public int update(Founder fou) {
		return mapper.update(fou);
	}
	@Override
	public int deleteFounder(int pk) {
		
		return mapper.deleteFounder(pk);
	}

}
