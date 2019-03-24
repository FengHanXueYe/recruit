package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Selfdescription {
	private Integer sid;
	private String sdescription;
	private Integer suserid;
}
