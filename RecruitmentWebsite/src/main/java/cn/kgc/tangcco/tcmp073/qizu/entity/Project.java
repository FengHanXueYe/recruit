package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Project {
	private Integer pid;
	private String pname,pposition;
	private Date pyear,pyearover;
	private String pdescribe;
	private Integer puserid;
	
	
}
