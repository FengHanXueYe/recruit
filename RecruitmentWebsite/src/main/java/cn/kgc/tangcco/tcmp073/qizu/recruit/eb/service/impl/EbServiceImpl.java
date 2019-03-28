package cn.kgc.tangcco.tcmp073.qizu.recruit.eb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Educationalbackground;
import cn.kgc.tangcco.tcmp073.qizu.recruit.eb.mapper.EbMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.eb.service.EbService;
@Service
public class EbServiceImpl implements EbService {

	@Resource
	private EbMapper ebMapper;
	
	@Override
	public int addEb(Educationalbackground eb) {
		return ebMapper.addEb(eb);
	}

	@Override
	public int updateEb(Educationalbackground eb) {
		return ebMapper.updateEb(eb);
	}

	@Override
	public int deleteEb(Integer ebid) {
		return ebMapper.deleteEb(ebid);
	}

	@Override
	public Educationalbackground queryEducationalbackground(Integer puserid) {
		return ebMapper.queryEducationalbackground(puserid);
	}
	
	

}
