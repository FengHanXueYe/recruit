package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 职业类别一级表 
 * @author jiangwu
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ocone {
	private Integer nid;
	private String nname;
	List<Octwo> octwo;
	//aaa
	
}
