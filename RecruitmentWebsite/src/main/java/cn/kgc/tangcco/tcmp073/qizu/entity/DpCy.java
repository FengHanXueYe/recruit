package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 投递简历VO
 * @author HASEE
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DpCy {
	private Deliverypost deliverypost;
	private Company company;
	private RecruitingUsers cuser;
	
}
