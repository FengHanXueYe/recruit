package cn.kgc.tangcco.tcmp073.qizu.recruit.octhree.mapper;

import java.util.List;

public interface OcthreeMapper {
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
