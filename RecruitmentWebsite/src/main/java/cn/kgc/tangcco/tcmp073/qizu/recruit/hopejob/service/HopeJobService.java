package cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.service;

import cn.kgc.tangcco.tcmp073.qizu.entity.HopeJob;

public interface HopeJobService {
	int addHopeJob(HopeJob hm);

	int updateHopeJob(HopeJob hm);

	int deleteHopeJob(Integer hid);
	
	HopeJob detailHopeJob(Integer userid);
	
	int deleteHopeJobById(int pk);
	
}
