package cn.kgc.tangcco.tcmp073.qizu.recruit.recommendVO.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecommendVO;

public interface RecommendVOMapper {
	
	List<RecommendVO> queryRecommendVO(@Param("rvo")RecommendVO rvo);
	
	
	
	@Select("SELECT COUNT(*) FROM subscribe")
	int queryCount();
	
}
