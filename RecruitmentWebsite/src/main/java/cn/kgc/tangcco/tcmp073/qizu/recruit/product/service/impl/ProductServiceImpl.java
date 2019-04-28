package cn.kgc.tangcco.tcmp073.qizu.recruit.product.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Product;
import cn.kgc.tangcco.tcmp073.qizu.recruit.product.mapper.ProductMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.product.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductMapper mapper;
	
	@Override
	public int addProduct(Product pct) {
		return mapper.addProduct(pct);
	}
	//公司页面修改产品信息
	@Override
	public int updateProduct(Product pro) {
		return mapper.updateProduct(pro);
	}

}
