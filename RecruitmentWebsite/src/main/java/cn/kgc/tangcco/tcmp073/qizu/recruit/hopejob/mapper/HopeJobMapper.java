package cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.HopeJob;

public interface HopeJobMapper {

	@Insert("insert into HopeJob value(null,#{hm.hcity},#{hm.htype},#{hm.hname},#{hm.hmoney},#{hm.huserid})")
	int addHopeJob(@Param("hm") HopeJob hm);

	int updateHopeJob(@Param("hm") HopeJob hm);

	@Delete("delete from HopeJob where hid=#{hid}")
	int deleteHopeJob(@Param("hid") Integer hid);

	@Select("select * from HopeJob where huserid=#{userid}")
	HopeJob detailHopeJob(@Param("userid") Integer userid);

	//关联外键事务删除
	@Delete("DELETE FROM hopejob WHERE huserid=#{id}")
	int deleteHopeJobById(@Param("id")int pk);
	
}
