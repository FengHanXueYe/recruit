package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 项目经验
 * @author jiangwu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Project {
	private Integer pid;
	private String pname,ppostition;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String pyear;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String  pyearover;
	private String pdescribe;
	private Integer puserid;
	
	
}
