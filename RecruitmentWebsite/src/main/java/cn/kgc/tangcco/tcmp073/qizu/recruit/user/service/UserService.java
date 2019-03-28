package cn.kgc.tangcco.tcmp073.qizu.recruit.user.service;



import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;

public interface UserService {
	int addUser(RecruitingUsers ruser);
	
	int updateUser(RecruitingUsers ruser);
	
	int deleteUser(Integer userid);
	
	RecruitingUsers loginRecruitingUsers(RecruitingUsers ruser);
	
	int queryRecruitingUsersCount(String email);
	
	RecruitingUsers detailRecruitingUsers(Integer userid);
	
	int updateTime(Integer userid);
	
}
