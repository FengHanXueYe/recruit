package cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.impl;

import javax.annotation.Resource;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.mapper.CompanyMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.founder.mapper.FounderMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.occupation.mapper.OccupationMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.product.mapper.ProductMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.mapper.UserMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

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

	// 后台事务删除根据用户主键删除对应关系表
	@Transactional
	@Override
	public int deleteUser(Integer pk) {
		founderMapper.deleteFounder(pk);
		productMapper.deleteProduct(pk);
		occMapper.deleteAdminOccupation(pk);
		companyMapper.deleteAdminCompanys(pk);
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

	/**
	 * 啊实打实
	 */

}
