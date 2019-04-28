package cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Deliverypost;

public interface DeliverypostService {
int addDeliverypost(Deliverypost dp);
	
	int updateDeliverypost(Deliverypost dp);
	
	int deleteDeliverypost(Integer did);
	
	List<Deliverypost> queryAllDeliverypost(Deliverypost dp);
	
	
	
	
	Deliverypost detailDeliverypost(Deliverypost dp);
}
