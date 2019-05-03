package cn.kgc.tangcco.tcmp073.qizu.recruit.chatrecord.controller;

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
		chatrecord.setIuserid(iuserid);
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
		Chatrecord chatrecord = new Chatrecord();
		RecruitingUsers ruser = new RecruitingUsers();
		ruser.setUserid(ruserid);
		chatrecord.setRuserid(ruser);
		chatrecord.setIuserid(iuserid);
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
	
	
	
}
