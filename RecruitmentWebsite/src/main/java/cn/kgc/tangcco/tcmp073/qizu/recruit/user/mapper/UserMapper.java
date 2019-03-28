package cn.kgc.tangcco.tcmp073.qizu.recruit.user.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
/**
 * 用户dao接口
 * @author HASEE
 *
 */
public interface UserMapper {
	@Insert(value="insert into recruitingusers(email,password,jurisdiction)values(#{ruser.email},#{ruser.password},#{ruser.jurisdiction}) ")
	int addUser(@Param("ruser")RecruitingUsers ruser);
	
	int updateUser(@Param("ruser")RecruitingUsers ruser);
	
	int deleteUser(Integer userid);
	@Select("select * from recruitingusers where email=#{ruser.email} and password=#{ruser.password}")
	RecruitingUsers loginRecruitingUsers(@Param("ruser")RecruitingUsers ruser);
	
	//查询邮箱是否被注册
	@Select(value="select count(*) from recruitingusers where email=#{email}")
	int queryRecruitingUsersCount(@Param("email")String email);
	
	@Select(value="select * from recruitingusers where userid=#{userid}")
	RecruitingUsers detailRecruitingUsers(@Param("userid")Integer userid);
	
	@Update(value="update recruitingusers set registrationtime=NOW() where userid=#{userid}")
	int updateTime(@Param("userid")Integer userid);
	
}
