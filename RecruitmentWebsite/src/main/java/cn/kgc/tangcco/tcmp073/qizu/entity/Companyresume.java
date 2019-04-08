package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 公司查看简历类
 * @author HASEE
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Companyresume {
	private Integer crid ;
	private Company company ;
	private Occupation occupation ;
	private RecruitingUsers cuser ;
	private Integer dstatus ;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp ctime;
	private String ctext;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp ctouditime;
	
}
