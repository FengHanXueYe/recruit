package cn.kgc.tangcco.tcmp073.qizu.recruit.chatrecord.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.tangcco.tcmp073.qizu.entity.Chatrecord;
import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;
import cn.kgc.tangcco.tcmp073.qizu.recruit.chatrecord.service.ChatrecordService;

@Controller
public class ChatrecordController {

	@Resource
	private ChatrecordService chatrecordService;
	
	/**
	 * 增加和查询
	 * @param chatrecord
	 * @param session
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxHandleChatrecord")
	public List<Chatrecord> ajaxHandleChatrecord(Integer iuserid,Integer ruserid,Integer crqf,String crtext,HttpSession session,Model model) {
		Chatrecord chatrecord = new Chatrecord();
		RecruitingUsers ruser = new RecruitingUsers();
		ruser.setUserid(ruserid);
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		chatrecord.setCrqf(crqf);
		chatrecord.setCrtext(crtext);
		chatrecord.setRuserid(ruser);
		chatrecord.setIuserid(attribute);
		System.err.println(chatrecord.getRuserid().getUserid()+"--------"+chatrecord.getIuserid());
		if(attribute!=null) {
			//增加聊天
			chatrecordService.insertChatrecord(chatrecord);
			//查询聊天记录
			List<Chatrecord> queryAllChatrecord = chatrecordService.queryAllChatrecord(chatrecord);
			System.err.println(queryAllChatrecord);
			return queryAllChatrecord;
		}else {
			return null;
		}
	}
	/**
	 * 查询
	 * @param chatrecord
	 * @param session
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxQueryChatrecord")
	public List<Chatrecord> ajaxQueryChatrecord(Integer iuserid,Integer ruserid,HttpSession session,Model model) {
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		Chatrecord chatrecord = new Chatrecord();
		RecruitingUsers ruser = new RecruitingUsers();
		ruser.setUserid(ruserid);
		chatrecord.setRuserid(ruser);
		chatrecord.setIuserid(attribute);
		List<Chatrecord> queryAllChatrecord = chatrecordService.queryAllChatrecord(chatrecord);
		return queryAllChatrecord;
	}
	
	
	
	
	/**
	 * 删除
	 * @param chatrecord
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("ajaxDeleteChatrecord")
	public boolean ajaxDeleteChatrecord(Chatrecord chatrecord,Model model) {
		int deleteChatrecord = chatrecordService.deleteChatrecord(chatrecord);
		if(deleteChatrecord>0) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 我的消息
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("doMyNews")
	public String doMyNews(HttpSession session,Model model) {
		//存iuserid
		List<Integer> listiuserid = new ArrayList<>();
		//登当前用户
		RecruitingUsers attribute = (RecruitingUsers) session.getAttribute("loginUser");
		//查询当前用户所有的消息
		List<Chatrecord> queryAllChatrecordByrUserid = chatrecordService.queryAllChatrecordByrUserid(attribute.getUserid());
		//System.err.println(queryAllChatrecordByrUserid);
		for (Chatrecord chatrecord : queryAllChatrecordByrUserid) {
			System.err.println(chatrecord);
			System.out.println();
			Integer userid = chatrecord.getIuserid().getUserid();
			if(listiuserid.size()==0) {
				listiuserid.add(userid);
			}else {
				for (Integer i : listiuserid) {
					if(userid!=i) {
						listiuserid.add(userid);
					}
				}
			}
		}
		System.err.println("我要回复的聊天记录："+listiuserid);
		//创建list的集合存放多个用户的聊天
		List<List<Chatrecord>> listChatrecord = new ArrayList<>();
		//实例聊天记录对象
		Chatrecord chatrecord = null;
		//循环当前的聊天数量
		for (Integer i : listiuserid) {
			chatrecord = new Chatrecord();
			//实例咨询者
			RecruitingUsers iuser = new RecruitingUsers();
			iuser.setUserid(i);
			//将咨询者的id赋值
			chatrecord.setIuserid(iuser);
			chatrecord.setRuserid(attribute);
			List<Chatrecord> queryAllChatrecord = chatrecordService.queryAllChatrecord(chatrecord);
			System.err.println(">>>>>>>>>>>>>>>"+queryAllChatrecord);
			listChatrecord.add(queryAllChatrecord);
		}
		System.out.println(listChatrecord.size()+"=================");
		System.out.println(listChatrecord);
		for (List<Chatrecord> listxxx : listChatrecord) {
			for (Chatrecord chatrecord2 : listxxx) {
				System.out.println("---"+chatrecord2);
			}
		}
		
		//发送至页面
		model.addAttribute("listChatrecord", listChatrecord);
		return "main/wodexiaoxi";
	}
	
	
}
