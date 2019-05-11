package cn.kgc.tangcco.tcmp073.qizu.recruit.Corporate.service;

import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Corporate;

public interface CorporateService {
	
	
	int addCorporate(Corporate corporate);
	
	int updateCorporate(Corporate corporate);
	
	int deleteCorporate(Integer userid);
	
    Corporate queryAll(Integer userid);
    
    int deleteCorporateById(int pk);

}
