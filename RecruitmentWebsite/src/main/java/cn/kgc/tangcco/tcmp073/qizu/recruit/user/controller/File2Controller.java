package cn.kgc.tangcco.tcmp073.qizu.recruit.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class File2Controller {
	
	
	@RequestMapping("upload")
    public String fileload(MultipartFile file, HttpServletRequest request) {

        //获取文件名称
        String fileName = file.getOriginalFilename();

        //设置上传路径
        String path =  request.getSession().getServletContext().getRealPath("/resources");

        //文件上传
        File f = new File(path);

        //判断路径是否存在，不存在则创建
        if(!f.exists()){
            f.mkdirs();
        }
        //判断上传文件是否为空
        if(!file.isEmpty()){
            try {
                FileOutputStream fos = new FileOutputStream(path + fileName);
                InputStream in = file.getInputStream();
                int a = 0;
                if((a = in.read())!=-1){
                    fos.write(a);
                }
                in.close();
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return "redirect:toResume.controller";
    }
}