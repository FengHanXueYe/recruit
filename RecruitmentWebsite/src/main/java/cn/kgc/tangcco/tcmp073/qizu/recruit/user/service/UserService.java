package cn.kgc.tangcco.tcmp073.qizu.recruit.user.service;





import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;

public interface UserService {
	int addUser(RecruitingUsers ruser);
	
	int updateUser(RecruitingUsers ruser);
	
	//后台删除
	int deleteUser(Integer pk);
	
	RecruitingUsers loginRecruitingUsers(RecruitingUsers ruser);
	
	int queryRecruitingUsersCount(String email);
	
	RecruitingUsers detailRecruitingUsers(Integer userid);
	
	int updateTime(Integer userid);
	
	RecruitingUsers queryUserByEmail(String email);
	
	
}
