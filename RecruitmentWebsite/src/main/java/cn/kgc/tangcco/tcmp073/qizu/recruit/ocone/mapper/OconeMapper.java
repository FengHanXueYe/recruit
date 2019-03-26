package cn.kgc.tangcco.tcmp073.qizu.recruit.ocone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.Ocone;

public interface OconeMapper {
	/**
	 * 查询类别
	 * 
	 * @return
	 */
	@Select("select *from oncone ")
	List<Ocone> queryType();




}
