package cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.Selfdescription;

public interface SelfdescriptionMapper {
	@Insert(value = "insert into Selfdescription value(null,#{sion.sdescription},#{sion.suserid})")
	int addSelfdescription(@Param("sion") Selfdescription sion);

	@Update(value = "update Selfdescription set sdescription=#{sion.sdescription} where sid=#{sion.sid}")
	int updateSelfdescription(@Param("sion") Selfdescription sion);

	@Delete(value = "delete from Selfdescription where sid=#{sid}")
	int deleteSelfdescription(@Param("sid") Integer sid);

	@Select("SELECT * FROM `selfdescription` s ,`recruitingusers` r WHERE s.`suserid`=r.userid AND r.userid=#{userid} LIMIT 1;")
	Selfdescription querySelfdescription(@Param("userid") Integer userid);
	
	
	@Delete("DELETE  FROM selfdescription WHERE suserid=#{id}")
	int deleteSelfdescriptionById(@Param("id")int pk);
	

}
