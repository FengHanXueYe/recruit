package cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.service;


import cn.kgc.tangcco.tcmp073.qizu.entity.Selfdescription;

public interface SelfdescriptionService {

	int addSelfdescription(Selfdescription sion);

	int updateSelfdescription(Selfdescription sion);

	int deleteSelfdescription(Integer sid);

	Selfdescription querySelfdescription(Integer userid);
	
	
}
