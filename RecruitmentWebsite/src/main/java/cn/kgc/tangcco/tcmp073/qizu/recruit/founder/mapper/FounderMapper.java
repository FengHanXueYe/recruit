package cn.kgc.tangcco.tcmp073.qizu.recruit.founder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import cn.kgc.tangcco.tcmp073.qizu.entity.Founder;

public interface FounderMapper {
	
	@Insert("INSERT INTO recruitdb.founder (fid, fname, fposition, flang, fdescribe, fhead, cfid)VALUES(default, #{fname}, #{fposition}, #{flang}, #{fdescribe}, #{fhead}, #{cfid});")
	int addFounder(Founder founder);
	List<Founder> queryByCId(int cid);
	
	
}
