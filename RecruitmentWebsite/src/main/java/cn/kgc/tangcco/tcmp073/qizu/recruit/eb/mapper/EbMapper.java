package cn.kgc.tangcco.tcmp073.qizu.recruit.eb.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.Educationalbackground;

public interface EbMapper {
	@Insert(value = "insert into educationalbackground value(null,#{eb.ename},#{eb.eeducation},#{eb.emajor},#{eb.pyear},#{eb.pyearover},#{eb.puserid})")
	int addEb(@Param("eb")Educationalbackground eb);

	int updateEb(@Param("eb") Educationalbackground eb);

	@Delete(value = "delete from educationalbackground where eid=#{ebid}")
	int deleteEb(@Param("ebid") Integer ebid);
	
	@Select(value="SELECT * FROM `educationalbackground` e,`recruitingusers` r WHERE r.userid=e.puserid AND r.userid=#{puserid} LIMIT 1;")
	Educationalbackground queryEducationalbackground(@Param("puserid")Integer puserid);
	
	
	

}
