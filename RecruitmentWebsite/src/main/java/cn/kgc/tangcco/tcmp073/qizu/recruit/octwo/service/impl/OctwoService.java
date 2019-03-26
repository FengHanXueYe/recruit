package cn.kgc.tangcco.tcmp073.qizu.recruit.octwo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Octwo;
import cn.kgc.tangcco.tcmp073.qizu.recruit.octwo.mapper.OctwoMapper;
@Service
public class OctwoService implements cn.kgc.tangcco.tcmp073.qizu.recruit.octwo.service.OctwoService{
@Resource
private OctwoMapper octwoMapper;

@Override
public List<Octwo> queryGangwei(int pk) {

	return octwoMapper.queryGangwei(pk);
}
}
