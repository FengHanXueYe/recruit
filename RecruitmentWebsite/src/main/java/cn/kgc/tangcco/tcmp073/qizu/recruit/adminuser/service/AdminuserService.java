package cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Adminuser;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;

public interface AdminuserService {
	int addAdminUser(Adminuser adminuser);

	int updateAdminUser(Adminuser adminuser);

	int deleteAdminUser(Integer aid);

	Adminuser loginAdminUser(Adminuser adminuser);

	List<Adminuser> queryAllAdminUser(Adminuser adminuser);

	int queryCountAdminUser();

	Adminuser queryAusername(String ausername);

	Adminuser queryAusernameById(Integer aid);
	
	
	/*----------------------*/
	
	RecruitingUsers queryUsername(String username);
	
	List<RecruitingUsers> queryAllrecuit(String username);
	
    //删除用户	
	int deleterecutUser(Integer userid);
	
	//编辑用户
	int updateRecuitUser(RecruitingUsers recuitUser);
	
	//根据id查询用户
	RecruitingUsers queryRecuitUserById(Integer userid);
	
	//禁用
	 int  ProhibitRecuitUser(Integer userid);
	 
	 //恢复
	 int  RecoveryUser(Integer userid);
}
