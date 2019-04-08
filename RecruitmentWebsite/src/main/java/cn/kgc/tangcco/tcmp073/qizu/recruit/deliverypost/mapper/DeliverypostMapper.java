package cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.kgc.tangcco.tcmp073.qizu.entity.Deliverypost;

public interface DeliverypostMapper {
	@Insert(value = "insert into Deliverypost value(null,#{dp.ruser.userid},#{dp.occupation.oid},#{dp.dstatus},default,NOW(),null)")
	int addDeliverypost(@Param("dp") Deliverypost dp);

	int updateDeliverypost(@Param("dp") Deliverypost dp);

	@Delete(value = "delete from Deliverypost where did=#{did}")
	int deleteDeliverypost(@Param("did") Integer did);

	List<Deliverypost> queryAllDeliverypost(@Param("dp") Deliverypost dp);

	Deliverypost detailDeliverypost(@Param("dp") Deliverypost dp);
	
}
