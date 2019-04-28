package cn.kgc.tangcco.tcmp073.qizu.recruit.recommend.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.recommend.mapper.RecommendMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.recommend.service.RecommendService;

@Service
public class RecommendServiceImpl implements RecommendService {
	
	@Resource
    private RecommendMapper recommendMapper;
	
	@Override
	public List<RecruitingUsers> queryAllHopeJob() {
		return recommendMapper.queryAllHopeJob();
	}

}
