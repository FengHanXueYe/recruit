package cn.kgc.tangcco.tcmp073.qizu.recruit.eb.service;

import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Educationalbackground;

public interface EbService {
	int addEb(Educationalbackground eb);

	int updateEb(Educationalbackground eb);

	int deleteEb(Integer ebid);
	
	Educationalbackground queryEducationalbackground(Integer puserid);
}
