package cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Adminuser;
import cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.mapper.AdminuserMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.service.AdminuserService;
@Service
public class AdminuserServiceImpl implements AdminuserService {
	
	@Resource
	private AdminuserMapper adminMapper;
	
	@Override
	public int addAdminUser(Adminuser adminuser) {
		return adminMapper.addAdminUser(adminuser);
	}

	@Override
	public int updateAdminUser(Adminuser adminuser) {
		return adminMapper.updateAdminUser(adminuser);
	}

	@Override
	public int deleteAdminUser(Integer aid) {
		return adminMapper.deleteAdminUser(aid);
	}

	@Override
	public Adminuser loginAdminUser(Adminuser adminuser) {
		return adminMapper.loginAdminUser(adminuser);
	}

	@Override
	public List<Adminuser> queryAllAdminUser(Adminuser adminuser) {
		return adminMapper.queryAllAdminUser(adminuser);
	}

	@Override
	public int queryCountAdminUser() {
		return adminMapper.queryCountAdminUser();
	}

	@Override
	public Adminuser queryAusername(String ausername) {
		return adminMapper.queryAusername(ausername);
	}

	@Override
	public Adminuser queryAusernameById(Integer aid) {
		return adminMapper.queryAusernameById(aid);
	}

}
