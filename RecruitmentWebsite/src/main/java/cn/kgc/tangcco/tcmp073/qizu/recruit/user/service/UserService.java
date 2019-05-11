package cn.kgc.tangcco.tcmp073.qizu.recruit.user.service;





import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Eclosure;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;

public interface UserService {
	int addUser(RecruitingUsers ruser);
	
	int updateUser(RecruitingUsers ruser);
	
	//后台删除
	int deleteUser(Integer pk);
	
	RecruitingUsers loginRecruitingUsers(RecruitingUsers ruser);
	
	int queryRecruitingUsersCount(String email);
	
	RecruitingUsers detailRecruitingUsers(Integer userid);
	
	RecruitingUsers queryRecruitingUsers(Integer userid);
	
	int updateTime(Integer userid);
	
	RecruitingUsers queryUserByEmail(String email);
	
	int addEclosure(Eclosure esure);
	
	Eclosure queryescName(Integer userid);
	
	int updateEclosure(Eclosure eclosure);
}
