package cn.kgc.tangcco.tcmp073.qizu.recruit.ocone.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Ocone;
import cn.kgc.tangcco.tcmp073.qizu.recruit.ocone.mapper.OconeMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.ocone.service.OconeService;

@Service
public class OconeServiceImpl implements OconeService{
      @Resource
      private OconeMapper oconeMapper;

	@Override
	public List<Ocone> queryType() {
		return oconeMapper.queryType();
	}

	@Override
	public List<Ocone> querySuiji(int pk) {
		// TODO Auto-generated method stub
		return oconeMapper.querySuiji(pk);
	}
}
