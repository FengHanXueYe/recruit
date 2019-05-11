package cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.HopeJob;
import cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.mapper.HopeJobMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.service.HopeJobService;
@Service
public class HopeJobServiceImpl implements HopeJobService {

	
	@Resource
	private HopeJobMapper hopeJobMapper;
	@Override
	public int addHopeJob(HopeJob hm) {
		return hopeJobMapper.addHopeJob(hm);
	}

	@Override
	public int updateHopeJob(HopeJob hm) {
		return hopeJobMapper.updateHopeJob(hm);
	}

	@Override
	public int deleteHopeJobById(int pk) {
		return hopeJobMapper.deleteHopeJobById(pk);
	}

	@Override
	public int deleteHopeJob(Integer hid) {
		return hopeJobMapper.deleteHopeJob(hid);
	}

	@Override
	public HopeJob detailHopeJob(Integer userid) {
		return hopeJobMapper.detailHopeJob(userid);
	}

}
