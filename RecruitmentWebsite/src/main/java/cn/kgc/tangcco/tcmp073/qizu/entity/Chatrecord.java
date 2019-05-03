package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chatrecord {
	private Integer crid;
	private Integer ruserid,iuserid;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp crtime;
	private String crtext;
	
}
