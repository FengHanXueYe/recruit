package cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.Adminuser;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;

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
	
	/**
	 * jiangwu 用户管理
	 * @param userid
	 * @return
	 */
	
	@Select("select * from RecruitingUsers where username=#{username}")
	RecruitingUsers queryUsername(@Param("username") String username);
	
	
	//根据id查询
	
	@Select("select * from RecruitingUsers where userid=#{userid}")
	RecruitingUsers queryRecuitUserById(@Param("userid")Integer userid);
	
	@Delete("delete from RecruitingUsers where userid=#{userid}")
	//删除用户
	int deleterecutUser(@Param("userid")Integer userid);
    //查询用户
	List<RecruitingUsers> queryAllrecuit(String username);
	//编辑用户
    @Update("update RecruitingUsers set username=#{recuitUser.username},password=#{recuitUser.password},identity=#{recuitUser.identity},gender=#{recuitUser.gender},email=#{recuitUser.email},telephone=#{recuitUser.telephone},education=#{recuitUser.education},userlog=#{recuitUser.userlog},currentstate=#{recuitUser.currentstate} where userid=#{recuitUser.userid}")
    int updateRecuitUser(@Param("recuitUser")RecruitingUsers recuitUser);
	
	//禁用
    @Update("UPDATE recruitingusers SET quanxian=1 WHERE userid=#{userid}")
    int  ProhibitRecuitUser(@Param("userid")Integer userid);
    
    //恢复
    @Update("UPDATE recruitingusers SET quanxian=0 WHERE userid=#{userid}")
    int  RecoveryUser(Integer userid);
	
	
	
	
}
