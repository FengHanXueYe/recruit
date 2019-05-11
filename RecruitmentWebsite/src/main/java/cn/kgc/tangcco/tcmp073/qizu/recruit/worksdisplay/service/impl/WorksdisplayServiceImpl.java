package cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Worksdisplay;
import cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.mapper.WorksdisplayMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.service.WorksdisplayService;
@Service
public class WorksdisplayServiceImpl implements WorksdisplayService {

	@Resource
	private WorksdisplayMapper wm;
	@Override
	public int addWorksdisplay(Worksdisplay wd) {
		return wm.addWorksdisplay(wd);
	}

	@Override
	public int updateWorksdisplay(Worksdisplay wd) {
		return wm.updateWorksdisplay(wd);
	}

	@Override
	public int deleteWorksdisplay(Integer wid) {
		return wm.deleteWorksdisplay(wid);
	}

	@Override
	public Worksdisplay queryWorksdisplay(Integer userid) {
		return wm.queryWorksdisplay(userid);
	}

	@Override
	public int deleteWorkdisplayById(int pk) {
		return wm.deleteWorkdisplayById(pk);
	}

}
