package cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Deliverypost;
import cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.mapper.DeliverypostMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.service.DeliverypostService;
@Service
public class DeliverypostServiceImpl implements DeliverypostService {



	@Resource
	private DeliverypostMapper dm;
	@Override
	public int addDeliverypost(Deliverypost dp) {
		return dm.addDeliverypost(dp);
	}
	
	@Override
	public int updateDeliverypost(Deliverypost dp) {
		return dm.updateDeliverypost(dp);
	}

	@Override
	public int deleteDeliverypost(Integer did) {
		return dm.deleteDeliverypost(did);
	}

	@Override
	public List<Deliverypost> queryAllDeliverypost(Deliverypost dp) {
		return dm.queryAllDeliverypost(dp);
	}

	@Override
	public Deliverypost detailDeliverypost(Deliverypost dp) {
		return dm.detailDeliverypost(dp);
	}

}
