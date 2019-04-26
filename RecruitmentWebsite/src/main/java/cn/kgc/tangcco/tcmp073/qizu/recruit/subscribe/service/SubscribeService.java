package cn.kgc.tangcco.tcmp073.qizu.recruit.subscribe.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Subscribe;

public interface SubscribeService {
	
	int addsubscribe(Subscribe sub);
	
	List<Subscribe> detailquery(Integer id);

}
