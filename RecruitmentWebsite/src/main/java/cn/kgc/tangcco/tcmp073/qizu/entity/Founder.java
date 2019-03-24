package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 创始人
 * @author jiangwu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Founder {
	private Integer fid;
	private String fname,fposition,flang,fdescribe,fhead;
	private Integer cfid;
}
