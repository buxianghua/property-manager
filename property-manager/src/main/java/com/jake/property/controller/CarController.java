package com.jake.property.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.Car;
import com.jake.property.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    //测试查所有
    @RequestMapping("/carFindAll")
    public Result carFindAll(){
        List<Car> cars = carService.carFindAll();
        return new Result(true, StatusCode.OK, MessageConstant.CAR_SEARCH_SUCCESS,cars);
    }

    /**
     * 分页查车辆
     * @param searchMap
     * @return
     */
    @RequestMapping("/carSearch")
    public PageResult carSearch(@RequestBody Map searchMap){
        IPage<Car> carIPage = carService.carSearch(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.CAR_SEARCH_SUCCESS,carIPage.getRecords(),carIPage.getTotal());
    }

    /**
     * 添加车辆信息
     * @param car
     * @return
     */
    @PostMapping("/carAdd")
    public Result carAdd(@RequestBody Car car){
        Boolean aBoolean = carService.carAdd(car);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id查询社区信息
     * @param id
     * @return
     */
    @GetMapping("/getCarById")
    public Result getCarById(Integer id){
        Car carById = carService.getCarById(id);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_FIND_BY_ID_SUCCESS,carById);
    }

    /**
     * 根据id更新车辆数据
     * @param car
     * @return
     */
    @RequestMapping("/updateCarById")
    public Result updateCarById(@RequestBody Car car){
        Boolean aBoolean = carService.updateCarById(car);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id删除车辆
     * @param ids
     * @return
     */
    @RequestMapping("/deleteCarById")
    public Result deleteCarById(@RequestBody List<Integer> ids){
        Boolean aBoolean = carService.deleteCarById(ids);
        return new Result(true,StatusCode.OK,MessageConstant.CAR_DELETE_SUCCESS,aBoolean);
    }

}

