package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.service;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;

public interface OccupationService {
	int addOccupation(Occupation occ);
	List<Occupation> queryall();//热门搜索
	
	Occupation queryOccupation(Integer oid);
	List<Occupation> queryBystate(int pk,int ostate);//查看已发布的职位
	int deleteOccupation(int oid);//删除发布的职位
	int updateOccupation(int oid,int ostate);//修改已发布职位的状态
}
