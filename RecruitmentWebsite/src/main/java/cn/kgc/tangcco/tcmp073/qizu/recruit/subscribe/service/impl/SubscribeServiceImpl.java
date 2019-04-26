package cn.kgc.tangcco.tcmp073.qizu.recruit.subscribe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Subscribe;
import cn.kgc.tangcco.tcmp073.qizu.recruit.subscribe.mapper.SubscribeMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.subscribe.service.SubscribeService;

@Service
public class SubscribeServiceImpl implements SubscribeService{

	
	@Resource
	private SubscribeMapper subscribeMapper;
	
	@Override
	public int addsubscribe(Subscribe sub) {
		return subscribeMapper.addsubscribe(sub);
	}

	@Override
	public List<Subscribe> detailquery(Integer id) {
		return subscribeMapper.detailquery(id);
	}
	
	

}
