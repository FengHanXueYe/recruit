package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  工作经历
 * @author jiangwu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corporate {
	private Integer cid;
	private String cname,cposition;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String cyear;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String cmonth;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String cyearover;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String cmonthover;
	
	private Integer cuserid;
}
