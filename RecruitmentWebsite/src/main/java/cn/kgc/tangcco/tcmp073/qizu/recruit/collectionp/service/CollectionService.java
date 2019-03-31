package cn.kgc.tangcco.tcmp073.qizu.recruit.collectionp.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Collectionp;

public interface CollectionService {
	List<Collectionp> queryAllUserCollectionp(Integer userid);

	Collectionp queryAllOccupationCollectionp(Collectionp collectionp);
	
	int addCollectionp(Collectionp collectionp);

	int deleteCollectionp(Integer cid);

	
}
