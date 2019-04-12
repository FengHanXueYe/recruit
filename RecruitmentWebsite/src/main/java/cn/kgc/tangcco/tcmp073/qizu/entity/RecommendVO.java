package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 推荐职位VO类
 * @author HASEE
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendVO {

	private RecruitingUsers ruser;
	private Occupation occupation;
	private Company company;
	private HopeJob hopeJob;
}
