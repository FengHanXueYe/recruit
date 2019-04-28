package cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.Adminuser;

public interface AdminuserMapper {
//	@Insert("insert into adminuser value(null,#{adminuser.ausername},#{adminuser.apassword},#{adminuser.apicture},#{adminuser.astatus},NOW()")
	@Insert("insert into adminuser value(null,#{adminuser.ausername},#{adminuser.apassword},null,#{adminuser.astatus},NOW())")
	int addAdminUser(@Param("adminuser") Adminuser adminuser);

//	@Update("update adminuser set ausername=#{adminuser.ausername},apassword=#{adminuser.apassword},apicture=#{adminuser.apicture},astatus=#{adminuser.astatus},adatatime=NOW() where aid=#{adminuser.aid}")
	@Update("update adminuser set ausername=#{adminuser.ausername},apassword=#{adminuser.apassword},astatus=#{adminuser.astatus},adatatime=NOW() where aid=#{adminuser.aid}")
	int updateAdminUser(@Param("adminuser") Adminuser adminuser);

	@Delete("delete from adminuser where aid=#{aid}")
	int deleteAdminUser(@Param("aid") Integer aid);

	@Select("select * from adminuser where ausername=#{adminuser.ausername} and apassword=#{adminuser.apassword} limit 1")
	Adminuser loginAdminUser(@Param("adminuser") Adminuser adminuser);

	List<Adminuser> queryAllAdminUser(@Param("adminuser") Adminuser adminuser);

	@Select("select count(*) from adminuser ")
	int queryCountAdminUser();

	@Select("select * from adminuser where ausername=#{ausername}")
	Adminuser queryAusername(@Param("ausername") String ausername);

	@Select("select * from adminuser where aid=#{aid}")
	Adminuser queryAusernameById(@Param("aid") Integer aid);
	
	
}
