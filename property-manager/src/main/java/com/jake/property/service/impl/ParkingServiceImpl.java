package com.jake.property.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Parking;
import com.jake.property.mapper.ParkingMapper;
import com.jake.property.service.ParkingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车位表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements ParkingService {

}
