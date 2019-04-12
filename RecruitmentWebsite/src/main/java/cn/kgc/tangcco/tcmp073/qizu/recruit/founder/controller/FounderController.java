package cn.kgc.tangcco.tcmp073.qizu.recruit.founder.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Founder;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.founder.service.FounderService;

@Controller
public class FounderController {
	@Resource
	private FounderService service;
	@Resource
	private CompanyService comservice;
	@RequestMapping("doAddFounderController")
	public String addFounder(Founder founder,Model model,String cemail)throws IOException  {
		//保存数据库的路径  
	      String sqlPath = null;   
	      //定义文件保存的本地路径  
	      File directory = new File("");// 参数为空
	      String courseFile = directory.getCanonicalPath();
	      System.out.println("---------------------------我是路径---》》》》"+courseFile);
	      String localPath=courseFile+"\\src\\main\\webapp\\images\\";  
	      //定义 文件名  
	      String filename=null;    
	      if(!founder.getFile().isEmpty()){    
	          //生成uuid作为文件名称    
	          String uuid = UUID.randomUUID().toString().replaceAll("-","");    
	          //获得文件类型（可以判断如果不是图片，禁止上传）    
	          String contentType=founder.getFile().getContentType();    
	          //获得文件后缀名   
	          String suffixName=contentType.substring(contentType.indexOf("/")+1);  
	          //得到 文件名  
	          filename=uuid+"."+suffixName;   
	          System.out.println(filename);  
	          //文件保存路径  
	          try {
	        	  founder.getFile().transferTo(new File(localPath+filename));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}    
	      }  
	      //把图片的相对路径保存至数据库  
	      sqlPath = "/images/"+filename;  
	      System.out.println(sqlPath);  
	      founder.setFhead(sqlPath);
	      System.out.println("===============================+"+founder.getFhead());
		
		int row=this.service.addFounder(founder);
		if(row>0) {
			model.addAttribute("company",this.comservice.queryByEmail(cemail));
			return "main/index02";
		}else {
			return "main/founder";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
