package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	private String cphone,cname,clang,cdetail,caddress,cfield,cemail,cscale,cindex,comtuxiang;
	private String cfs;
	private String cfinancing,cabbreviation;
	private Integer cinv;
	private String curl,companyProfile;
	private Founder founder;//创始团队实体
	private Product product;//产品实体
	private List<Occupation> occupation;
	private MultipartFile file;
	private List<String> biaoqian;
	private int cstate;
}
