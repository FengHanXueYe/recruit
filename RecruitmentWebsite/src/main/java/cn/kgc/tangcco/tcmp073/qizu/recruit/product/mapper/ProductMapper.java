package cn.kgc.tangcco.tcmp073.qizu.recruit.product.mapper;

import org.apache.ibatis.annotations.Insert;

import cn.kgc.tangcco.tcmp073.qizu.entity.Product;

public interface ProductMapper {
	@Insert("INSERT INTO recruitdb.product (pid, pname, paddress, pdetail, pcid)VALUES(default,#{pname},#{paddress},#{pdetail},#{pcid});")
	int  addProduct(Product pct);
	
	
}
