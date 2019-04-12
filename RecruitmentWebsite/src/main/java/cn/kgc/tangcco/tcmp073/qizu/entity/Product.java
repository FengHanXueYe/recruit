package cn.kgc.tangcco.tcmp073.qizu.entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产品表 
 * @author jiangwu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Integer pid;
	private String pname,paddress,pdetail,ptuxiang;
	private Integer pcid;
	private MultipartFile file;
}
