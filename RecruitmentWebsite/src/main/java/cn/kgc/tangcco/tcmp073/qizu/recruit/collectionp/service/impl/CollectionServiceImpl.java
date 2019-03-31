package cn.kgc.tangcco.tcmp073.qizu.recruit.collectionp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Collectionp;
import cn.kgc.tangcco.tcmp073.qizu.recruit.collectionp.mapper.CollectionpMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.collectionp.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService {
		

	@Resource
	private CollectionpMapper cm;

	@Override
	public List<Collectionp> queryAllUserCollectionp(Integer userid) {
		return cm.queryAllUserCollectionp(userid);
	}


	@Override
	public int addCollectionp(Collectionp collectionp) {
		return cm.addCollectionp(collectionp);
	}

	@Override
	public int deleteCollectionp(Integer cid) {
		return cm.deleteCollectionp(cid);
	}


	@Override
	public Collectionp queryAllOccupationCollectionp(Collectionp collectionp) {
		return cm.queryAllOccupationCollectionp(collectionp);
	}

}
