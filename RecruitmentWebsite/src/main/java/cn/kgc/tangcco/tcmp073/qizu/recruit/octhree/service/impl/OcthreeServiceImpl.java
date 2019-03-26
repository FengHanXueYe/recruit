package cn.kgc.tangcco.tcmp073.qizu.recruit.octhree.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.recruit.octhree.mapper.OcthreeMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.octhree.service.OcthreeService;

@Service
public class OcthreeServiceImpl implements OcthreeService{
@Resource
private OcthreeMapper octhreeMapper;

@Override
public List<OcthreeMapper> queryZhiwei(int pk) {
	return octhreeMapper.queryZhiwei(pk);
}

@Override
public List<OcthreeMapper> querySuiji(int pk) {
	return octhreeMapper.querySuiji(pk);
}
}
