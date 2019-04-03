package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service;

import java.util.List;

import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;

public interface OccupationService {
	int addOccupation(Occupation occ);
	List<Occupation> queryall();//热门搜索
}
