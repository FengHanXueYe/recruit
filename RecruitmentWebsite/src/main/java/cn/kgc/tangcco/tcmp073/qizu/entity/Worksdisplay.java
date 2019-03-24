package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 作品展示
 * @author jiangwu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worksdisplay {
	private Integer wid;
	private String wlink,wexplain;
	private 	Integer wuserid;
}
