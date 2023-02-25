package com.jake.property.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jake.property.entity.Parking;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 车位表 Mapper 接口
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Repository
@Mapper
public interface ParkingMapper extends BaseMapper<Parking> {

}
