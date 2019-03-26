package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;
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
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp registrationTime;
	private String currentstate;
}
