package cn.kgc.tangcco.tcmp073.qizu.recruit.chatrecord.service;

import java.util.List;


import cn.kgc.tangcco.tcmp073.qizu.entity.Chatrecord;

public interface ChatrecordService {
	
	int insertChatrecord(Chatrecord chatrecord);

	int updateChatrecord(Chatrecord chatrecord);
	
	int deleteChatrecord(Chatrecord chatrecord);
	
	List<Chatrecord> queryAllChatrecord(Chatrecord chatrecord);
	
	List<Chatrecord> queryAllChatrecordByrUserid(Integer ruserid);
}
