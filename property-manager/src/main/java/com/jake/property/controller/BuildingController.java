package com.jake.property.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.Building;
import com.jake.property.mapper.BuildingMapper;
import com.jake.property.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 楼栋表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;
    //测试方法查所有
    @RequestMapping("/buildingFindAll")
    public Result buildingFindAll(){
        List<Building> buildings = buildingService.buildingFindAll();
        return new Result(true, StatusCode.OK, MessageConstant.BUILDING_SEARCH_SUCCESS,buildings);
    }

    /**
     * RequestBody把前端Json格式数据转换成对象
     * 查询楼栋
     * @param searchMap
     * @return
     */
    @RequestMapping("/buildingSearch")
    public PageResult buildingSearch(@RequestBody Map searchMap){
        IPage<Building> buildingIPage = buildingService.buildingSearch(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.BUILDING_SEARCH_SUCCESS,buildingIPage.getRecords(),buildingIPage.getTotal());
    }

    /**
     * 添加楼栋
     * @param building
     * @return
     */
    @PostMapping("/buildingAdd")
    public Result buildingAdd(@RequestBody Building building){
        Boolean aBoolean = buildingService.buildingAdd(building);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id更新楼栋信息
     * @param building
     * @return
     */
    @RequestMapping("/updateBuildingById")
    public Result updateBuildingById(@RequestBody Building building){
        Boolean aBoolean = buildingService.updateBuildingById(building);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id查询楼栋信息
     * @param id
     * @return
     */
    @RequestMapping("/getBuildingById")
    public Result getBuildingById(Integer id){
        Building buildingById = buildingService.getBuildingById(id);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_FIND_BY_ID_SUCCESS,buildingById);
    }

    /**
     * 根据id数据删除楼栋
     * @param ids
     * @return
     */
    @RequestMapping("/deleteBuildingById")
    public Result deleteBuildingById(@RequestBody List<Integer> ids){
        Boolean aBoolean = buildingService.deleteBuildingById(ids);
        return new Result(true, StatusCode.OK,MessageConstant.BUILDING_DELETE_SUCCESS,aBoolean);
    }
}

