package cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.Worksdisplay;

public interface WorksdisplayMapper {
	@Insert(value = "insert into Worksdisplay value(null,#{wd.wlink},#{wd.wexplain},#{wd.wuserid})")
	int addWorksdisplay(@Param("wd") Worksdisplay wd);

	int updateWorksdisplay(@Param("wd") Worksdisplay wd);

	@Delete(value = "delete from Worksdisplay where wid=#{wid}")
	int deleteWorksdisplay(@Param("wid") Integer wid);

	@Select(value = "SELECT * FROM `recruitingusers` r, `Worksdisplay` w WHERE w.`wuserid`=r.`userid` AND r.userid=#{userid} LIMIT 1")
	Worksdisplay queryWorksdisplay(@Param("userid") Integer userid);
}
