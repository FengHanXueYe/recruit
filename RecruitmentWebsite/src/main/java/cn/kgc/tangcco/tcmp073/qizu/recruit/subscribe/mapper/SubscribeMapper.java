package cn.kgc.tangcco.tcmp073.qizu.recruit.subscribe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.Subscribe;

public interface SubscribeMapper {
	
	
	@Insert("insert into subscribe values(default,#{email},#{sendMailPer},#{positionName},#{city},#{financeStage},#{industryField},#{salary},#{suserid})")
	int addsubscribe(Subscribe sub);
	
	
	@Select("SELECT * FROM subscribe,recruitingusers WHERE subscribe.`suserid`=recruitingusers.`userid` AND  suserid=3")
	List<Subscribe> detailquery(@Param("id")Integer id);
	 
	
	
	
	

}
