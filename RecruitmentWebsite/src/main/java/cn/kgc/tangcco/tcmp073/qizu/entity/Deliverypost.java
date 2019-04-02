package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 用户投递职位表
 * @author HASEE
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deliverypost {
	
	private Integer did;
	private RecruitingUsers ruser;
	private Occupation occupation;
	private Integer dstatus;
	
	
}
