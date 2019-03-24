package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corporate {
	private Integer cid;
	private String cname,cposition;
	private Date cyear,cmonth,cyearover,cmonthover;
	private Integer cuserid;
}
