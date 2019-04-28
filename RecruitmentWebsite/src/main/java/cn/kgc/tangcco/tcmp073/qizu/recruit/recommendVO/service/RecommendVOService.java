package cn.kgc.tangcco.tcmp073.qizu.recruit.recommendVO.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecommendVO;

public interface RecommendVOService {
	
	List<RecommendVO> queryRecommendVO(@Param("rvo")RecommendVO rvo);
	
	int queryCount();
}
