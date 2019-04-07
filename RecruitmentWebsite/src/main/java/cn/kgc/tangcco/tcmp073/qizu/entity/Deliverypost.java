package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 用户投递职位表
 * @author HASEE
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deliverypost {
	
	private Integer did;
	private RecruitingUsers ruser;
	private Occupation occupation;
	private Integer dstatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp dtime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp dxytime;
	private String texttz;
	
}
