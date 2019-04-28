package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscribe {
	
	
	private Integer subid,sendMailPer,suserid;
	private String positionName,email,city,financeStage,industryField,salary;

}