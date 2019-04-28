package cn.kgc.tangcco.tcmp073.qizu.recruit.founder.service;

import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Founder;

public interface FounderService {
	int addFounder(Founder founder);
	int update(Founder fou);
}
