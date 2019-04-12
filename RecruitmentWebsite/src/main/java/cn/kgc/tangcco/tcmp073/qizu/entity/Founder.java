package cn.kgc.tangcco.tcmp073.qizu.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 创始人
 * @author jiangwu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Founder {
	private Integer fid;
	private String fname,fposition,flang,fdescribe,fhead;
	private Integer cfid;
	private MultipartFile file;
}
