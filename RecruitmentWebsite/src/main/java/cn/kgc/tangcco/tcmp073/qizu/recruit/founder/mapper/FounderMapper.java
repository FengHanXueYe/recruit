package cn.kgc.tangcco.tcmp073.qizu.recruit.founder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.Founder;

public interface FounderMapper {
	
	@Insert("INSERT INTO recruitdb.founder (fid, fname, fposition, flang, fdescribe, fhead, cfid)VALUES(default, #{fname}, #{fposition}, #{flang}, #{fdescribe}, #{fhead}, #{cfid});")
	int addFounder(Founder founder);
	List<Founder> queryByCId(int cid);
	
	//公司页面修改创始人信息
	@Update("UPDATE recruitdb.founder SET  fname = #{fou.fname} , fposition = #{fou.fposition} , flang = #{fou.flang}, fdescribe = #{fou.fdescribe} , fhead = #{fou.fhead}  WHERE fid = #{fou.fid};")
	int update(@Param("fou")Founder fou);
	
	//事务删除创世人
	@Delete("DELETE FROM founder WHERE cfid IN(SELECT cid FROM company WHERE cuid=#{pk})")
	int deleteFounder(@Param("pk")int pk);
	//公司后台删除
	@Delete("delete from founder where cfid=#{cid}")
	int deleteCompany(@Param("cid")int cid);
}
