package cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Eclosure;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.Corporate.mapper.CorporateMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.mapper.CompanyMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.education.mapper.EducationaMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.founder.mapper.FounderMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.hopejob.mapper.HopeJobMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.mapper.OccupationMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.product.mapper.ProductMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.project.mapper.ProjectMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.selfdescription.mapper.SelfdescriptionMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.mapper.UserMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.worksdisplay.mapper.WorksdisplayMapper;

/**
 * 用户service实现类
 * 
 * @author HASEE
 *
 */
@Service
public class UserServiceImpl implements UserService {


	@Resource
	private UserMapper userMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private OccupationMapper occMapper;
	@Resource
	private ProductMapper productMapper;
	@Resource
	private FounderMapper founderMapper;
	@Resource
	private HopeJobMapper hopejobMappper;
	@Resource
	private CorporateMapper corporateMapper;
	@Resource
	private ProjectMapper proMapper;
	@Resource
	private EducationaMapper educationMapper;
	@Resource
	private SelfdescriptionMapper selfdescriptionMapper;
	@Resource 
	private WorksdisplayMapper worksdisplayMapper;
	// 后台事务删除根据用户主键删除对应关系表
	@Transactional
	@Override
	public int deleteUser(Integer pk) {
		founderMapper.deleteFounder(pk);
		productMapper.deleteProduct(pk);
		occMapper.deleteAdminOccupation(pk);
		companyMapper.deleteAdminCompanys(pk);
		hopejobMappper.deleteHopeJobById(pk);
		corporateMapper.deleteCorporateById(pk);
		proMapper.deleteProjectById(pk);
		educationMapper.deleteEducationaById(pk);
		selfdescriptionMapper.deleteSelfdescriptionById(pk);
		worksdisplayMapper.deleteWorkdisplayById(pk);
		int rows = userMapper.deleteUser(pk);
		return rows;
	}

	@Override
	public int addUser(RecruitingUsers ruser) {
		return userMapper.addUser(ruser);
	}

	@Override
	public int updateUser(RecruitingUsers ruser) {
		return userMapper.updateUser(ruser);
	}

	@Override
	public RecruitingUsers loginRecruitingUsers(RecruitingUsers ruser) {
		return userMapper.loginRecruitingUsers(ruser);
	}

	@Override
	public int queryRecruitingUsersCount(String email) {
		return userMapper.queryRecruitingUsersCount(email);
	}

	@Override
	public RecruitingUsers detailRecruitingUsers(Integer userid) {
		return userMapper.detailRecruitingUsers(userid);
	}

	@Override
	public int updateTime(Integer userid) {
		return userMapper.updateTime(userid);
	}

	@Override
	public RecruitingUsers queryUserByEmail(String email) {
		return userMapper.queryUserByEmail(email);
	}

	@Override
	public int addEclosure(Eclosure esure) {
		return userMapper.addEclosure(esure);
	}

	@Override
	public Eclosure queryescName(Integer userid) {
		return userMapper.queryescName(userid);
	}

	@Override
	public int updateEclosure(Eclosure eclosure) {
		return userMapper.updateEclosure(eclosure);
	}

	/**
	 * 啊实打实
	 */
	

}
