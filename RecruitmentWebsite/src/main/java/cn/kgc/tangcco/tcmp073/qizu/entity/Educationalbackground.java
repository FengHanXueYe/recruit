package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 教育 
 * @author jiangwu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Educationalbackground {
	private Integer eid;
	private String ename;
	private Integer eeducation,emajor;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String pyear;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String pyearover;
	private  Integer puserid;
}
