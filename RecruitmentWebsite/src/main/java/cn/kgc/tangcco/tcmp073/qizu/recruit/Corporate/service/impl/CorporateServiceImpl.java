package cn.kgc.tangcco.tcmp073.qizu.recruit.Corporate.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Corporate;
import cn.kgc.tangcco.tcmp073.qizu.recruit.Corporate.mapper.CorporateMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.Corporate.service.CorporateService;
@Service
public class CorporateServiceImpl implements CorporateService{
	
	
	@Resource
	private CorporateMapper corporateMapper;

	@Override
	public int addCorporate(Corporate corporate) {
		return corporateMapper.addCorporate(corporate);
	}
	
	@Override
	public int deleteCorporateById(int pk) {
		return corporateMapper.deleteCorporateById(pk);
	}


	@Override
	public int updateCorporate(Corporate corporate) {
		return corporateMapper.updateCorporate(corporate);
	}

	@Override
	public int deleteCorporate(Integer userid) {
		return 0;
	}

	@Override
	public Corporate queryAll(Integer userid) {
		return corporateMapper.queryAll(userid);
	}
	
	

}
