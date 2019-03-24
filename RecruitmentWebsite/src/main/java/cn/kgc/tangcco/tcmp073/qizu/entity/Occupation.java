package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Occupation {
	
	private Integer oid;
	private String oname,odepartment;
	private Integer onature;
	private double ominsalary,omaxsalary;
	private String ocity,olog;
	private Integer oeducation;
	private String owelfare,odetail,oaddress,oemail,ophone;
	private Integer ostate;
	
}
