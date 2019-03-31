package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

/**
 * 收藏职位
 * @author HASEE
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collectionp {
	private Integer cid;
	private RecruitingUsers cuser;
	private Occupation occupation;
}
