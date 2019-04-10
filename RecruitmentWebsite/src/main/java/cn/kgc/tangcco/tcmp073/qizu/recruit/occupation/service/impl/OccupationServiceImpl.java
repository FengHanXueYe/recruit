package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.mapper.OccupationMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service.OccupationService;

@Service
public class OccupationServiceImpl implements OccupationService {
	@Resource
	private OccupationMapper mapper;

	@Override
	public int addOccupation(Occupation occ) {
		return mapper.addOccupation(occ);
	}

	@Override
	public List<Occupation> queryall() {
		return mapper.queryall();//sad
	}

	@Override
	public Occupation queryOccupation(Integer oid) {
		return mapper.queryOccupation(oid);
	}
	//查看已发布的职位
	@Override
	public List<Occupation> queryBystate(int pk, int ostate) {
		return mapper.queryBystate(pk, ostate);
	}
	//删除已发布的职位
	@Override
	public int deleteOccupation(int oid) {
		return mapper.deleteOccupation(oid);
	}
	//修改已发布职位的状态
	@Override
	public int updateOccupation(int oid,int ostate) {
		return mapper.updateOccupation(oid,ostate);
	}
	//编辑职位信息使用的方法
	@Override
	public Occupation queryByoid(int oid) {
		return mapper.queryByoid(oid);
	}
	
}
