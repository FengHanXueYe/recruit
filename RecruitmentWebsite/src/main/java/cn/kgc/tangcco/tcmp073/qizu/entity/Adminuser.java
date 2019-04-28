package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 管理员实体类
 * @author HASEE
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Adminuser {
	
	private Integer aid;
	@NonNull
	private String ausername,apassword;
	private String apicture;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Integer astatus;
	private Timestamp adatatime;
	
	
	
}
