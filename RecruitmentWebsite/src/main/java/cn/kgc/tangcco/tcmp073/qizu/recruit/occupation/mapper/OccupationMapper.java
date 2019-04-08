package cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.Occupation;

public interface OccupationMapper {
	@Insert("INSERT INTO recruitdb.occupation VALUES(default, #{oname}, #{odepartment}, #{onature}, #{ominsalary}, #{omaxsalary}, #{ocity}, #{olog}, #{oeducation}, #{owelfare}, #{odetail}, #{oaddress}, #{oemail}, #{ophone}, #{ostate}, NOW(), #{otype},#{ocid});")	
	int addOccupation(Occupation occ);
	List<Occupation> queryall();//热门搜索
	
	
	Occupation queryOccupation(@Param("oid")Integer oid);
	List<Occupation> queryBystate(@Param("ocid")int ocid,@Param("ostate")int ostate);//查看已发布的职位
	@Delete("delete from occupation where oid=#{oid}")
	int deleteOccupation(int oid);//删除发布的职位
	@Update("update occupation set ostate=#{ostate} where oid=#{oid}")
	int updateOccupation(@Param("oid")int oid,@Param("ostate")int ostate);//修改已发布职位的状态
}
