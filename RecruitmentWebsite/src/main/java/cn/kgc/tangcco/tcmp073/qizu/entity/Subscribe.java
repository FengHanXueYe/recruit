package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscribe {
	
	
	private Integer subid,subweek;
	private String subname,subemail,subcity,substate,subrealm,subprice;

}