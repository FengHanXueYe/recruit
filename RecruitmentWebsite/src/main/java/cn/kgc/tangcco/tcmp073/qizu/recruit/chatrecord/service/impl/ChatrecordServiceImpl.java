package cn.kgc.tangcco.tcmp073.qizu.recruit.chatrecord.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Chatrecord;
import cn.kgc.tangcco.tcmp073.qizu.recruit.chatrecord.mapper.ChatrecordMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.chatrecord.service.ChatrecordService;
@Service
public class ChatrecordServiceImpl implements ChatrecordService {

	@Resource
	private ChatrecordMapper chatrecordMapper;
	
	@Override
	public int insertChatrecord(Chatrecord chatrecord) {
		return chatrecordMapper.insertChatrecord(chatrecord);
	}

	@Override
	public int updateChatrecord(Chatrecord chatrecord) {
		return chatrecordMapper.updateChatrecord(chatrecord);
	}

	@Override
	public int deleteChatrecord(Chatrecord chatrecord) {
		return chatrecordMapper.deleteChatrecord(chatrecord);
	}

	@Override
	public List<Chatrecord> queryAllChatrecord(Chatrecord chatrecord) {
		return chatrecordMapper.queryAllChatrecord(chatrecord);
	}

	@Override
	public List<Chatrecord> queryAllChatrecordByrUserid(Integer ruserid) {
		return chatrecordMapper.queryAllChatrecordByrUserid(ruserid);
	}

}
