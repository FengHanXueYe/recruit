package cn.kgc.tangcco.tcmp073.qizu.recruit.recommendVO.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecommendVO;
import cn.kgc.tangcco.tcmp073.qizu.recruit.recommendVO.mapper.RecommendVOMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.recommendVO.service.RecommendVOService;
@Service
public class RecommendVOServiceImpl implements RecommendVOService {

	@Resource
	private RecommendVOMapper recommendVOMapper;
	
	@Override
	public List<RecommendVO> queryRecommendVO(RecommendVO rvo) {
		return recommendVOMapper.queryRecommendVO(rvo);
	}

}
