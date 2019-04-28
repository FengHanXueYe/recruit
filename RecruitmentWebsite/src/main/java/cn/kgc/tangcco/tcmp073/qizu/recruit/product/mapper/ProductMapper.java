package cn.kgc.tangcco.tcmp073.qizu.recruit.product.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.Product;

public interface ProductMapper {
	@Insert("INSERT INTO recruitdb.product (pid, pname, paddress, pdetail, pcid,ptuxiang)VALUES(default,#{pname},#{paddress},#{pdetail},#{pcid},#{ptuxiang});")
	int  addProduct(Product pct);
	//公司页面修改产品信息
	@Update("update product set pname=#{pro.pname},paddress=#{pro.paddress},pdetail=#{pro.pdetail},ptuxiang=#{pro.ptuxiang} where pid=#{pro.pid}")
	int updateProduct(@Param("pro")Product pro);
	
}
