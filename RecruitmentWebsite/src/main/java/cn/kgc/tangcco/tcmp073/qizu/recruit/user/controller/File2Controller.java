package cn.kgc.tangcco.tcmp073.qizu.recruit.user.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.kgc.tangcco.tcmp073.qizu.entity.Eclosure;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

@Controller
public class File2Controller {
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("upload")
    public String fileload(MultipartFile file,HttpSession session, HttpServletRequest request,Eclosure eclosure,Model model) throws IOException {
		Eclosure esure=new Eclosure();
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //生成新的文件名防止文件名冲突
        String newFileName = UUID.randomUUID()+"="+fileName;
        //获取用户id
        RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
        //设置上传路径
        File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();
		System.out.println("---------------------------我是路径---》》》》"+courseFile);
		String path=courseFile+"\\src\\main\\webapp\\resources\\";  
		//数据库存的路径
		String path1=courseFile+"\\src\\main\\webapp\\resources\\"+newFileName;  
        //文件上传
        File f = new File(path1);
        //判断路径是否存在，不存在则创建
        if(!f.exists()){
            f.mkdirs();
        }
        file.transferTo(f);
        esure.setEuid(attribute.getUserid());
        esure.setEsurename(path1);
		//上传后台
        Eclosure queryescName = userService.queryescName(attribute.getUserid());
        if(queryescName!=null) {
        	String escName = queryescName.getEsurename();
        	File fileLJ = new File(escName);
        	fileLJ.delete();
        	userService.updateEclosure(esure);
        }else {
        	this.userService.addEclosure(esure);
        }
        return "redirect:toResume.controller";
    }
	
	
	
	
/*	@RequestMapping("upload")
	public String fileload(MultipartFile file,HttpSession session, HttpServletRequest request,Eclosure eclosure,Model model) throws IOException {
		Eclosure esure=new Eclosure();
		
		System.out.println("我是file"+file);
		//获取文件名称
		String fileName = file.getOriginalFilename();
		//生成新的文件名防止文件名冲突
		String newFileName = UUID.randomUUID()+fileName;
		
		//获取用户id
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		//设置上传路径
//        String path =  request.getSession().getServletContext().getRealPath("/resources");
		File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();
		System.out.println("---------------------------我是路径---》》》》"+courseFile);
		String path=courseFile+"\\src\\main\\webapp\\resources\\";  
		
//        ServletContext sc = request.getSession().getServletContext();
//        String path = sc.getRealPath("/resources")+"/";
//        System.out.println("我是路径-------》"+path);
		//数据库存的路径
		String path1=courseFile+"\\src\\main\\webapp\\resources\\"+fileName;  
		
		//文件上传
		File f = new File(path1);
//        //处理图片url的编码格式
//        String newpath = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
//        String absolutePath = path + newpath;
		
//        esure.setEuid(attribute.getUserid());
//        esure.setEsurename(path1);
		//上传后台
//        this.userService.addEclosure(esure);
		
		
		
		
		//判断路径是否存在，不存在则创建
		if(!f.exists()){
			f.mkdirs();
		}
		file.transferTo(f);
		//判断上传文件是否为空
//        if(!file.isEmpty()){
//        	try {
//        		FileOutputStream fos = new FileOutputStream(path+fileName);
//        		InputStream in = file.getInputStream();
//        		System.out.println("ininin"+in);
//        		int a = 0;
//        		if((a = in.read())!=-1){
//        			fos.write(a);
//        		}
//        		in.close();
//        		fos.close();
//        	}catch (Exception e){
//        		e.printStackTrace();
//        	}
//        }
//        if(!file.isEmpty()){
//            try {
//                FileOutputStream fos = new FileOutputStream(fileName);
//                InputStream in = file.getInputStream();
//                int a = 0;
//                if((a = in.read())!=-1){
//                    fos.write(a);
//                }
//                in.close();
//                fos.close();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
		
		return "redirect:toResume.controller";
	}
*/	
	
	
}