package cn.kgc.tangcco.tcmp073.qizu.recruit.product.service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Product;

public interface ProductService {
	int  addProduct(Product pct);
	//公司页面修改产品信息
	int updateProduct(Product pro);
	
	int deleteProduct(int pk);
}
