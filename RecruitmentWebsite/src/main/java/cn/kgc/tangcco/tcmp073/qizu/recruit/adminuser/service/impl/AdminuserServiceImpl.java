package cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Adminuser;
import cn.kgc.tangcco.tcmp073.qizu.entity.Company;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.mapper.AdminuserMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.adminuser.service.AdminuserService;
@Service
public class AdminuserServiceImpl implements AdminuserService {
	

	@Resource
	private AdminuserMapper adminMapper;
	
	@Override
	public int deleterecutUser(Integer userid) {
		return adminMapper.deleterecutUser(userid);
	}
	@Override
	public int addAdminUser(Adminuser adminuser) {
		return adminMapper.addAdminUser(adminuser);
	}

	@Override
	public int updateRecuitUser(RecruitingUsers recuitUser) {
		return adminMapper.updateRecuitUser(recuitUser);
	}
	@Override
	public RecruitingUsers queryRecuitUserById(Integer userid) {
		return adminMapper.queryRecuitUserById(userid);
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

	@Override
	public List<RecruitingUsers> queryAllrecuit(String username) {
		return adminMapper.queryAllrecuit(username);
	}
	@Override
	public RecruitingUsers queryUsername(String username) {
		return adminMapper.queryUsername(username);
	}
	@Override
	public int RecoveryUser(Integer userid) {
		
		return adminMapper.RecoveryUser(userid);
	}
	@Override
	public int ProhibitRecuitUser(Integer userid) {
		return adminMapper.ProhibitRecuitUser(userid);
	}
	@Override
	public List<Company> querylikeoname(String oname) {
		return adminMapper.querylikeoname(oname);
	}
	@Override
	public int deleteOcc(int oid) {
		return adminMapper.deleteOcc(oid);
	}
	@Override
	public List<Company> queryDatial(int oid) {
		return adminMapper.queryDatial(oid);
	}
	

}
