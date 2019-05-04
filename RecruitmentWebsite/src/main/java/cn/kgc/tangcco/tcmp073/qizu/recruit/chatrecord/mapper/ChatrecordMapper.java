package cn.kgc.tangcco.tcmp073.qizu.recruit.chatrecord.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.Chatrecord;

public interface ChatrecordMapper {
	
	@Insert("insert into Chatrecord value(null,#{chatrecord.ruserid.userid},#{chatrecord.iuserid.userid},NOW(),#{chatrecord.crtext},#{chatrecord.crqf})")
	int insertChatrecord(@Param("chatrecord")Chatrecord chatrecord);

	int updateChatrecord(@Param("chatrecord")Chatrecord chatrecord);
	
	@Delete("delete from chatrecord where ruserid=#{chatrecord.ruserid.userid} and iuserid=#{chatrecord.iuserid.userid}")
	int deleteChatrecord(@Param("chatrecord")Chatrecord chatrecord);
	
	List<Chatrecord> queryAllChatrecord(@Param("chatrecord")Chatrecord chatrecord);
	
	@Select("SELECT * FROM `recruitingusers` r,`recruitingusers` i,chatrecord c WHERE r.`userid`=c.`ruserid` AND i.`userid`=c.`iuserid`AND c.ruserid=#{ruserid} ORDER BY c.crtime ASC")
	List<Chatrecord> queryAllChatrecordByrUserid(@Param("ruserid")Integer ruserid);
	
	
}
