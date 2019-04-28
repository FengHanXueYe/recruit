package cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.service;

import java.util.List;



import cn.kgc.tangcco.tcmp073.qizu.entity.Adminuser;

public interface AdminuserService {
	int addAdminUser(Adminuser adminuser);

	int updateAdminUser(Adminuser adminuser);

	int deleteAdminUser(Integer aid);

	Adminuser loginAdminUser(Adminuser adminuser);

	List<Adminuser> queryAllAdminUser(Adminuser adminuser);

	int queryCountAdminUser();

	Adminuser queryAusername(String ausername);

	Adminuser queryAusernameById(Integer aid);
}
