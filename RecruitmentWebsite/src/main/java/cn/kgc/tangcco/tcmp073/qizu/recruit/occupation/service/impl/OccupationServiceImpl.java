package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.mapper.OccupationMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service.OccupationService;
@Service
public class OccupationServiceImpl implements OccupationService {
	@Resource
	private OccupationMapper mapper;

	@Override
	public int addOccupation(Occupation occ) {
		return mapper.addOccupation(occ);
	}
	
	

}
