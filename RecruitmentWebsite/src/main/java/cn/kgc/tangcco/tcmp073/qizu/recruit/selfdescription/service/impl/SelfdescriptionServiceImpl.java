package cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Selfdescription;
import cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.mapper.SelfdescriptionMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.service.SelfdescriptionService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.mapper.UserMapper;
@Service
public class SelfdescriptionServiceImpl implements SelfdescriptionService {

	@Resource
	private SelfdescriptionMapper selfdescriptionService;
	
	@Resource
	private UserMapper userMapper;
	@Override
	public int addSelfdescription(Selfdescription sion) {
		return selfdescriptionService.addSelfdescription(sion);
	}

	@Override
	public int updateSelfdescription(Selfdescription sion) {
		return selfdescriptionService.updateSelfdescription(sion);
	}

	@Override
	public int deleteSelfdescription(Integer sid) {
		return selfdescriptionService.deleteSelfdescription(sid);
	}

	@Override
	public Selfdescription querySelfdescription(Integer userid) {
		return selfdescriptionService.querySelfdescription(userid);
	}


}
