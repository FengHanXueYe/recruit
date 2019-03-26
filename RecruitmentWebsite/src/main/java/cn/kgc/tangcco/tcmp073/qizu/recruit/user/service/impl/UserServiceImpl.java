package cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.mapper.UserMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

/**
 * 用户service实现类
 * @author HASEE
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public int addUser(RecruitingUsers ruser) {
		return userMapper.addUser(ruser);
	}

	@Override
	public int updateUser(RecruitingUsers ruser) {
		return userMapper.updateUser(ruser);
	}

	@Override
	public int deleteUser(Integer userid) {
		return userMapper.deleteUser(userid);
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

	
	
}
