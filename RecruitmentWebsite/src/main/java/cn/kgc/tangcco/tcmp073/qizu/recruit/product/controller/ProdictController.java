package cn.kgc.tangcco.tcmp073.qizu.recruit.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.tangcco.tcmp073.qizu.entity.Product;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.product.service.ProductService;

@Controller

public class ProdictController {
	@Resource
	private ProductService service;
	@Resource
	private CompanyService comservice;
	@RequestMapping("doAddProductController")
	public String doAdd(Product pro,Model model,String cemail) throws IOException {
		//保存数据库的路径  
	      String sqlPath = null;   
	      //定义文件保存的本地路径  
	      File directory = new File("");// 参数为空
	      String courseFile = directory.getCanonicalPath();
	      System.out.println("---------------------------我是路径---》》》》"+courseFile);
	      String localPath=courseFile+"\\src\\main\\webapp\\images\\";  
	      //定义 文件名  
	      String filename=null;    
	      if(!pro.getFile().isEmpty()){    
	          //生成uuid作为文件名称    
	          String uuid = UUID.randomUUID().toString().replaceAll("-","");    
	          //获得文件类型（可以判断如果不是图片，禁止上传）    
	          String contentType=pro.getFile().getContentType();    
	          //获得文件后缀名   
	          String suffixName=contentType.substring(contentType.indexOf("/")+1);  
	          //得到 文件名  
	          filename=uuid+"."+suffixName;   
	          System.out.println(filename);  
	          //文件保存路径  
	          try {
	        	  pro.getFile().transferTo(new File(localPath+filename));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}    
	      }  
	      //把图片的相对路径保存至数据库  
	      sqlPath = "/images/"+filename;  
	      System.out.println(sqlPath);  
	      pro.setPtuxiang(sqlPath);
		int row=this.service.addProduct(pro);
		if(row>0) {
			model.addAttribute("company",this.comservice.queryByEmail(cemail));
			return "main/index03";
		}else {
			return "main/index02";
		}
	}
	
	//公司页面修改产品信息
	@RequestMapping("UpdateProduct")
	public String update(Product pro) throws IOException {
		//保存数据库的路径  
	      String sqlPath = null;   
	      //定义文件保存的本地路径  
	      File directory = new File("");// 参数为空
	      String courseFile = directory.getCanonicalPath();
	      System.out.println("---------------------------我是路径---》》》》"+courseFile);
	      String localPath=courseFile+"\\src\\main\\webapp\\images\\";  
	      //定义 文件名  
	      String filename=null;    
	      if(!pro.getFile().isEmpty()){    
	          //生成uuid作为文件名称    
	          String uuid = UUID.randomUUID().toString().replaceAll("-","");    
	          //获得文件类型（可以判断如果不是图片，禁止上传）    
	          String contentType=pro.getFile().getContentType();    
	          //获得文件后缀名   
	          String suffixName=contentType.substring(contentType.indexOf("/")+1);  
	          //得到 文件名  
	          filename=uuid+"."+suffixName;   
	          System.out.println(filename);  
	          //文件保存路径  
	          try {
	        	  pro.getFile().transferTo(new File(localPath+filename));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}    
	      }  
	      //把图片的相对路径保存至数据库  
	      sqlPath = "/images/"+filename;  
	      System.out.println(sqlPath);  
	      pro.setPtuxiang(sqlPath);
		int row=this.service.updateProduct(pro);
		return "redirect:tomyhome.controller";
	}
	
	
	
	
	
	
	
	
	
	
}
