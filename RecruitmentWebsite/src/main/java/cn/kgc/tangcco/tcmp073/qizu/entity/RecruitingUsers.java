package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.security.Timestamp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class RecruitingUsers {
	private Integer userid;
	@NonNull
	private String username,password;
	private  Integer gender,education,userlog,jurisdiction;
	private String email,telephone,userpicture,resumeName;
	private Timestamp registrationTime;
}
