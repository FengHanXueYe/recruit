package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.util.Date;

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
	private Date pyear,pyearover;
	private  Integer puserid;
}
