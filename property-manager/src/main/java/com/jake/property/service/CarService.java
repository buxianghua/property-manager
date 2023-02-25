package com.jake.property.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.Car;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface CarService extends IService<Car> {

    /**
     * 查询所有车辆信息
     * @return
     */
    public List<Car> carFindAll();

    /**
     * 车辆信息搜索
     * @param searchMap
     * @return
     */
    public IPage<Car> carSearch(Map searchMap);

    /**
     * 添加车辆信息
     * @param car
     * @return
     */
    public Boolean carAdd(Car car);

    /**
     * 根据id获取对象信息
     * @param id
     * @return
     */
    public Car getCarById(Integer id);

    /**
     * 根据id修改对象信息
     * @param car
     * @return
     */
    public Boolean updateCarById(Car car);

    /**
     * 根据id删除车辆数据
     * @param ids
     * @return
     */
    public Boolean deleteCarById(List<Integer> ids);

}
