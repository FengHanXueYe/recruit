package cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.service;

import java.util.List;

import cn.kgc.tangcco.tcmp073.qizu.entity.Deliverypost;

public interface DeliverypostService {
int addDeliverypost(Deliverypost dp);
	
	int updateDeliverypost(Deliverypost dp);
	
	int deleteDeliverypost(Integer did);
	
	List<Deliverypost> queryAllDeliverypost(Deliverypost dp);
}
