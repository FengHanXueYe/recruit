package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公司查看简历vo
 * @author HASEE
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoRe {

	private Companyresume companyresume;
	private HopeJob hopeJob;
	private Corporate corporate;
	private Project project;
	
	private Educationalbackground eb;
	private Selfdescription selfdescription;
	private Worksdisplay worksdisplay;
	
}

