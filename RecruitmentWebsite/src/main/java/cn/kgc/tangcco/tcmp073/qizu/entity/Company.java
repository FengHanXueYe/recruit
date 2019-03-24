package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公司表   Company
 * @author jiangwu
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Company {
	
	private Integer cid,cuid;
	private String cphone,cname,clang,cdetail,caddress,cfield,cemail,cscale,cindex;
	private Integer cfs;
	private String cfinancing,cabbreviation;
	private Integer cinv;
}
