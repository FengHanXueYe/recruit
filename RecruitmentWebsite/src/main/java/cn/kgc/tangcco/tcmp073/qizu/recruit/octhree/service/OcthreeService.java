package cn.kgc.tangcco.tcmp073.qizu.recruit.octhree.service;

import java.util.List;

import cn.kgc.tangcco.tcmp073.qizu.recruit.octhree.mapper.OcthreeMapper;

public interface OcthreeService {
	/**
	 * 查询所有职位
	 * 
	 * @return
	 */
   List<OcthreeMapper> queryZhiwei(int pk);
   /**
    * 随机产生职位
    */
   List<OcthreeMapper> querySuiji(int pk);
}
