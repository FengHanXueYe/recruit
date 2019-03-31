package cn.kgc.tangcco.tcmp073.qizu.recruit.collectionp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Collectionp;

public interface CollectionpMapper {

	List<Collectionp> queryAllUserCollectionp(@Param("userid") Integer userid);

	Collectionp queryAllOccupationCollectionp(Collectionp collectionp);

	@Insert(value = "insert into Collectionp value(null,#{cuser.userid},#{occupation.oid})")
	int addCollectionp(Collectionp collectionp);

	@Delete(value = "delete from Collectionp where cid=#{cid}")
	int deleteCollectionp(@Param("cid") Integer cid);

}
