package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expectedwork {
		private Integer pid;
		private String pcity;
		private Integer ptype;
		private String pname,pmoney;
		private Integer puserid;
}
