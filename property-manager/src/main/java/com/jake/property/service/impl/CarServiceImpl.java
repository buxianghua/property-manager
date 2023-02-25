package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Car;
import com.jake.property.mapper.CarMapper;
import com.jake.property.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> carFindAll() {
        List<Car> cars = carMapper.selectList(null);
        return cars;
    }

    @Override
    public IPage<Car> carSearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<Car> wrapper = new QueryWrapper<>();
        //添加查询
        if (!StringUtils.isEmpty(searchMap.get("startTime"))) {
            wrapper.gt("create_time", searchMap.get("startTime"));
        }
        if (!StringUtils.isEmpty(searchMap.get("endTime"))) {
            wrapper.lt("create_time", searchMap.get("endTime"));
        }
        //模糊查询
        if (!StringUtils.isEmpty(searchMap.get("name"))) {
            wrapper.like("owner_name", searchMap.get("name"));
        }
        //分页查询
        if (searchMap.get("pageNum") != null) {
            pageNum = (int) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize") != null) {
            pageSize = (int) searchMap.get("pageSize");
        }
        Page<Car> page = new Page<>(pageNum, pageSize);
        Page<Car> carPage = carMapper.selectPage(page, wrapper);
        return carPage;
    }

    @Override
    public Boolean carAdd(Car car) {
        int insert = carMapper.insert(car);
        return insert > 0;
    }

    @Override
    public Car getCarById(Integer id) {
        Car car = carMapper.selectById(id);
        return car;
    }

    @Override
    public Boolean updateCarById(Car car) {
        int result = carMapper.updateById(car);
        return result > 0;
    }

    @Override
    public Boolean deleteCarById(List<Integer> ids) {
        int result = carMapper.deleteBatchIds(ids);
        return result > 0;
    }
}
