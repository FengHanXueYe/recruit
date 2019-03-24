package cn.kgc.tangcco.tcmp073.qizu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Integer pid;
	private String pname,paddress,pdetail;
	private Integer pcid;
}
