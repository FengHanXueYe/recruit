package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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
	private String identity;
	private  Integer gender,education,userlog,jurisdiction,quanxian;
	private String telephone,userpicture,resumeName;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp registrationTime;
	private String currentstate;
	private MultipartFile file;
	private List<HopeJob> hopejob;
	
}
