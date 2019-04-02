package cn.kgc.tangcco.tcmp073.qizu.recruit.deliverypost.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.kgc.tangcco.tcmp073.qizu.entity.Deliverypost;

public interface DeliverypostMapper {
	@Insert(value = "insert into Deliverypost value(null,#{dp.ruser.userid},#{dp.occupation.oid},#{dp.dstatus})")
	int addDeliverypost(@Param("dp") Deliverypost dp);

	@Update(value = "update Deliverypost set dstatus=#{dp.status} where did=#{dp.did}")
	int updateDeliverypost(@Param("dp") Deliverypost dp);

	@Delete(value = "delete from Deliverypost where did=#{did}")
	int deleteDeliverypost(@Param("did") Integer did);

	List<Deliverypost> queryAllDeliverypost(@Param("dp") Deliverypost dp);

}
