package cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.service;


import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Worksdisplay;

public interface WorksdisplayService {
	int addWorksdisplay(Worksdisplay wd);

	int updateWorksdisplay(Worksdisplay wd);

	int deleteWorksdisplay(Integer wid);

	Worksdisplay queryWorksdisplay(Integer userid);
	
	int deleteWorkdisplayById(int pk);
}
