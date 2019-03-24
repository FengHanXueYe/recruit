package cn.kgc.tangcco.tcmp073.qizu.recruit.ocone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.kgc.tangcco.tcmp073.qizu.entity.Ocone;

public interface OconeMapper {
	/**
	 * 查询所有一级表
	 * @return
	 */
	@Select("select *from ocone order by nid desc")
    List<Ocone> queryAll();
}
