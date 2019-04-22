package cn.kgc.tangcco.tcmp073.qizu.recruit.Corporate.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.Corporate;

/**
 * 
 * @author jiangwu
 * 工作经历
 */

public interface CorporateMapper {

	@Insert("insert into corporate values(null,#{cname},#{cposition},#{cyear},#{cyearover},#{cuserid})")
	int addCorporate(Corporate corporate);
	
	
	int updateCorporate(Corporate corporate);
	
	int deleteCorporate(Integer userid);
	
	@Select("select * from corporate where cid=#{userid}")
    Corporate queryAll(Integer userid);
}
