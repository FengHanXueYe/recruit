package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.security.Timestamp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
/**
 * 用户表
 * @author jiangwu
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class RecruitingUsers {
	private Integer userid;
	private String username;
	@NonNull
	private String email,password;
	private  Integer gender,education,userlog,jurisdiction;
	private String telephone,userpicture,resumeName;
	private Timestamp registrationTime;
}
