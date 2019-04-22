package cn.kgc.tangcco.tcmp073.qizu.recruit.Corporate.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.kgc.tangcco.tcmp073.qizu.entity.Corporate;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.Corporate.service.CorporateService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

@Controller
public class CorporateController {
	

	@Resource
	private CorporateService corporateService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("doAddUpdateCorporate")
	public String doAddUpdateCorporate(Corporate cor,HttpSession session,Model model) {
		System.err.println("doAddUpdateCorporate"+cor);
		
		RecruitingUsers attribute = (RecruitingUsers)session.getAttribute("loginUser");
		
		Corporate queryCorporate = corporateService.queryAll(attribute.getUserid());
		if(queryCorporate==null) {
			cor.setCuserid(attribute.getUserid());
			corporateService.addCorporate(cor);
		}else {
			cor.setCid(queryCorporate.getCid());
			corporateService.updateCorporate(cor);
		}
		/*修改时间*/
		userService.updateTime(attribute.getUserid());
		session.setAttribute("loginUser",userService.detailRecruitingUsers(attribute.getUserid()));
		return "redirect:toResume.controller";
	}
	
	
	@RequestMapping("testUpload")
	public String testUpload(@RequestParam("desc")String desc, @RequestParam("file")MultipartFile file,HttpSession session,Model model) {
		System.out.println("------------->"+desc);//文件描述信息
		//jsp中上传文件
		try {
			//读取
			InputStream input = file.getInputStream();
			//获取原始的文件名
			String fileName = file.getOriginalFilename();
			System.err.println(fileName);
			//写入
			OutputStream out = new FileOutputStream("d:\\"+fileName);			
			
			byte[] bs = new byte[1024];
			int len=-1;
			while((len = input.read(bs)) != -1) {
				out.write(bs, 0, len);
			}
			out.close();
			input.close();
			System.out.println("上传成功");
		} catch (IOException e) {
			e.printStackTrace();
		}//io0
		return "index";
	}
	

}
