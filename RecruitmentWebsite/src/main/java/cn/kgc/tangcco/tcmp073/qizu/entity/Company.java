package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.util.List;

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
	private String cfs;
	private String cfinancing,cabbreviation;
	private Integer cinv;
	private String curl,companyProfile;
	
	private List<Founder> founder;//创始团队实体
	private List<Product> product;//产品实体
}
