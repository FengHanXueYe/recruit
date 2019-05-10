package cn.kgc.tangcco.tcmp073.qizu.recruit.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.aliyun.util.HttpUtils;
import cn.kgc.tangcco.tcmp073.qizu.emailutils.Email;
import cn.kgc.tangcco.tcmp073.qizu.encryption.Encryption;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.company.service.CompanyService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.ocone.service.OconeService;
import cn.kgc.tangcco.tcmp073.qizu.recruit.user.service.UserService;

/**
 * 用户servlet
 * 
 * @author HASEE
 *
 */
@Controller
public class UserController {

	@Resource
	private UserService userService;
	@Resource
	private OconeService os;
	@Resource
	private CompanyService cs;

	/**
	 * 登录
	 * @param ruser
	 * @param session
	 * @param model
	 * @return
	 */
	
	@RequestMapping("userLogin")
	public String userLogin(RecruitingUsers ruser,String autoLogin,HttpServletRequest request,HttpServletResponse response, HttpSession session, Model model) {
		System.out.println("---------------->"+autoLogin);
		String ruserpwd = ruser.getPassword();
		// 设置session有效时间
		// session.setMaxInactiveInterval(15*60);
		// System.err.println("login---->"+ruser);
		// 得到密码
		String password = ruser.getPassword();
		// MD5加密
		password = Encryption.md5Encode(password.getBytes());
		// base64编码
		password = Encryption.base64Encode(password.getBytes());
		System.out.println("=====登录====>" + password);
		// 重新赋值给password
		ruser.setPassword(password);
		// 从数据库中查询是否有这样一个用户
		RecruitingUsers loginRecruitingUsers = userService.loginRecruitingUsers(ruser);
	
		// System.out.println("session==============>"+loginRecruitingUsers);
		session.setAttribute("ruserpwd", ruserpwd);
		
		if (loginRecruitingUsers == null ) {
			model.addAttribute("ruser", ruser);
			model.addAttribute("loginCuowu", "密码账号错误！");
			return "main/login";
		} else {
			session.setAttribute("loginUser", loginRecruitingUsers);
			session.setAttribute("companys",this.cs.queryByUid(loginRecruitingUsers.getUserid()));
			if(autoLogin!=null) {
				Cookie cookiename = new Cookie("cookiename",ruser.getEmail());
				cookiename.setMaxAge(60 * 60 * 24 * 3);
				Cookie cookiepwd = new Cookie("cookiepwd",ruserpwd);
				cookiepwd.setMaxAge(60 * 60 * 24 * 3);
				response.addCookie(cookiepwd);
				response.addCookie(cookiename);
//				model.addAttribute("cookiename", cookiename);
//				model.addAttribute("cookiepwd", cookiepwd);
			}
			
			Integer quanxian=loginRecruitingUsers.getQuanxian();
			if(quanxian==1) {
				model.addAttribute("cuo","用户已被禁用");
				return "main/login";
			}else {
			
			model.addAttribute("ocone",os.queryType());
			model.addAttribute("com", cs.queryalltoFounder());
			model.addAttribute("coo",cs.queryalltozuixin());
			for (int i = 0; i <7; i++) {
				model.addAttribute("ocone1"+i, os.querySuiji(i));
			}
			return "main/index";
		}
		}

	}

	/**
	 * 判断邮箱是否被注册
	 * 
	 * @param email
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxQueryEmail")
	public int ajaxQueryEmail(String email, Model model) {
		return userService.queryRecruitingUsersCount(email);
	}

	/**
	 * 注册
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("doRegister")
	public String doRegister(RecruitingUsers ruser,String veremail,HttpServletRequest request, Model model) {
		System.out.println("______>"+ruser);
		System.out.println("______>"+veremail);
		
		
		
		if(!"".equals(veremail)) {
			System.out.println("55555555555555555555555555555555555555555555555555555555555555");
			// 得到注册时的密码
			String password = ruser.getPassword();
			// 再次储存方便转发到登录界面
			String password1 = ruser.getPassword();
			// MD5
			password = Encryption.md5Encode(password.getBytes());
			// base64
			password = Encryption.base64Encode(password.getBytes());
			System.out.println("====注册====>" + password);
			// 赋值给password
			ruser.setPassword(password);
			// 增加一个用户
			userService.addUser(ruser);
			// 将注册时的密码储存
			ruser.setPassword(password1);
			request.setAttribute("username", ruser.getEmail());
			request.setAttribute("password", password1);
			return "main/login";
			/*Email email = new Email();
			// 实现邮箱发送
			String sendEamilCode = email.sendEamilCode(ruser.getEmail());
			// 判断是否成功
			if (sendEamilCode == "成功") {
			} else {
				model.addAttribute("errorEmail", "邮件发送失败！请稍后重试");
			}*/
		}else {
			Email email = new Email();
			// 实现邮箱发送
			String sendEamilCode = email.sendEamilCode(ruser.getEmail());
			// 储存发闪送到登录界面
			model.addAttribute("userEmail", "邮箱已发送！请到邮箱中点击！");
		}
		return "main/register";
	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doRemoveSession")
	public String doRemoveSession(HttpSession session, Model model) {
		// 消除session
//		session.invalidate();
		session.removeAttribute("loginUser");
		return "redirect:toIndex.controller";
	}

	/**
	 * 修改简历
	 * 
	 * @param ruser
	 * @param session
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("doidentyIdYanzheng")
	public String doidentdy(String number,String name) {
		String obj="";
		
		  String host = "http://aliyunverifyidcard.haoservice.com";
//		    String host = "http://aliyunverifyidcard.haoservice.com/idcard/VerifyIdcardv2";
		    String path = "/idcard/VerifyIdcardv2";
		    String method = "GET";
		    String appcode = "7264d6e7f48c43a3b2c07c78364cc493";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
		    Map<String, String> querys = new HashMap<String, String>();
		    querys.put("cardNo", number);
		    querys.put("realName", name);


		    try {
		    	
		    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
		    	String string = EntityUtils.toString(response.getEntity());
		    	System.out.println(string);
//		    	System.err.println(response.toString());
		    	org.json.JSONObject json = new org.json.JSONObject(string);
		    	org.json.JSONObject string2 = json.getJSONObject("result");
		    	Boolean object =(Boolean) string2.get("isok");
		    	if(object==true) {
		    		obj ="true";
		    	}
		    	else {
		    		obj ="false";
		    	}
		    	System.out.println();
//		    	Object object = json.get("result");
//		    	System.out.println("----->");
//		    	System.out.println("++++"+object);
		    	//获取response的body
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
			return obj;
			
				// 获取response的body
	}
	
	
	
	
	
	
	@RequestMapping("doUpdateResumename")
	public String doUpdateResumename(RecruitingUsers ruser, String xueli, String jingyan, HttpSession session,
			Model model) throws IOException {
		
		// 从session中取用户
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		// 查询该用户的详细信息
		RecruitingUsers detailUser = userService.detailRecruitingUsers(attribute.getUserid());
		if(ruser.getResumeName()==null) {
			if (xueli != null) {
				ruser.setEducation(Integer.parseInt(xueli));
			} else {
				ruser.setEducation(detailUser.getEducation());
			}
			
			
			if (jingyan != null) {
				ruser.setUserlog(Integer.parseInt(jingyan));
			} else {
				ruser.setUserlog(detailUser.getUserlog());
			}
			
		
			
			
			
			
			
			
			//保存数据库的路径  
			String sqlPath = null;   
			//定义文件保存的本地路径  
			File directory = new File("");// 参数为空
			String courseFile = directory.getCanonicalPath();
			System.out.println("---------------------------我是路径---》》》》"+courseFile);
			String localPath=courseFile+"\\src\\main\\webapp\\images\\";  
			//定义 文件名  
			String filename=null;    
			if(!ruser.getFile().isEmpty()){    
				//生成uuid作为文件名称    
				String uuid = UUID.randomUUID().toString().replaceAll("-","");    
				//获得文件类型（可以判断如果不是图片，禁止上传）    
				String contentType=ruser.getFile().getContentType();    
				//获得文件后缀名   
				String suffixName=contentType.substring(contentType.indexOf("/")+1);  
				//得到 文件名  
				filename=uuid+"."+suffixName;   
				System.out.println(filename);  
				//文件保存路径  
				try {
					ruser.getFile().transferTo(new File(localPath+filename));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}    
			}  
			//把图片的相对路径保存至数据库  
			sqlPath = "/images/"+filename;  
			System.out.println(sqlPath); 
			System.out.println(ruser.getUserpicture()); 
			if(filename!=null) {
				ruser.setUserpicture(sqlPath); 
			}
		}
		
	      
		// 将用户的id赋值给ruser（因为前台没传用户id）
		ruser.setUserid(attribute.getUserid());
		// 执行修改
		userService.updateUser(ruser);
		// 再次查询该用户信息储存到session中覆盖
		session.setAttribute("loginUser", userService.detailRecruitingUsers(attribute.getUserid()));
		return "redirect:toResume.controller";
	}

	/**
	 * 修改用户密码
	 * 
	 * @param newpassword
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doUpdatePassword")
	public String doUpdatePassword(String newpassword, HttpSession session, Model model) {
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		// MD5
		newpassword = Encryption.md5Encode(newpassword.getBytes());
		// base64
		newpassword = Encryption.base64Encode(newpassword.getBytes());
		RecruitingUsers ruser = new RecruitingUsers();
		ruser.setPassword(newpassword);
		ruser.setUserid(attribute.getUserid());
		int updateUser = userService.updateUser(ruser);
		if (updateUser > 0) {
			model.addAttribute("updatepwdruser", "修改成功！");
		}
		;
		return "main/accountBind";
	}

	/**
	 * 判断用户密码是否正确
	 * 
	 * @param password
	 * @param session
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxPdPassword")
	public boolean ajaxPdPassword(String password, HttpSession session, Model model) {
		// 从session中取用户密码
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		RecruitingUsers detailRecruitingUsers = userService.detailRecruitingUsers(attribute.getUserid());
		// MD5
		password = Encryption.md5Encode(password.getBytes());
		// base64
		password = Encryption.base64Encode(password.getBytes());
		System.out.println(detailRecruitingUsers.getPassword() + "+----------------");
		System.out.println(password + "pwd----------------");
		if (password.equals(detailRecruitingUsers.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 找回密码
	 * @param email
	 * @param model
	 * @return
	 */
	@RequestMapping("doRetrievePwd")
	public String doRetrievePwd(String email,Model model) {
		RecruitingUsers queryUserByEmail = userService.queryUserByEmail(email);
		if(queryUserByEmail!=null) {
			Email e = new Email();
			String pwd = e.sendEamilCodeDoRetrievePwd(email);
			if(!"失败".equals(pwd)) {
				// MD5
				pwd = Encryption.md5Encode(pwd.getBytes());
				// base64
				pwd = Encryption.base64Encode(pwd.getBytes());
				RecruitingUsers ruser = new RecruitingUsers();
				ruser.setPassword(pwd);
				ruser.setUserid(queryUserByEmail.getUserid());
				int updateUser = userService.updateUser(ruser);
				if(updateUser>0) {
					model.addAttribute("successEmail", "密码已发送至您的邮箱，请注意查收！");
					return "main/login";
				}else {
					model.addAttribute("errEmail1", "出现未知错误！");
					return "main/reset";
				}
			}else {
				model.addAttribute("errEmail2", email);
				return "main/reset";
			}
		}else {
			model.addAttribute("errEmail3", "没有该用户！");
			return "main/reset";
		}
	}
	
	
	
	@RequestMapping("verEmail")
	public String verEmail(String email,Model model) {
		model.addAttribute("email", email);
		return "main/register";
	}
	
	
	@RequestMapping("toqueryUser")
	public String queryUser() {
		
		return null;
	}
	
	
	
	
	
}
