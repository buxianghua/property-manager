package com.jake.property.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.House;
import com.jake.property.service.HouseService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    //测试方法
    @GetMapping("/houseFindAll")
    public Result houseFindAll(){
        List<House> houses = houseService.houseFindAll();
        return new Result(true, StatusCode.OK, MessageConstant.HOUSE_SEARCH_SUCCESS,houses);
    }

    /**
     * 分页查询房屋信息
     * @param searchMap
     * @return
     */
    @RequestMapping("/houseSearch")
    public PageResult houseSearch(@RequestBody Map searchMap){
        IPage<House> houseIPage = houseService.houseSearch(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.HOUSE_SEARCH_SUCCESS,houseIPage.getRecords(),houseIPage.getTotal());
    }

    /**
     * 添加业主信息
     * @param house
     * @return
     */
    @PostMapping("/houseOwnAdd")
    public Result houseOwnAdd(@RequestBody House house){
        Boolean aBoolean = houseService.houseOwnAdd(house);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    @RequestMapping("/getHouseById")
    public Result getHouseById(Integer id){
        House houseById = houseService.getHouseById(id);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_FIND_BY_ID_SUCCESS,houseById);
    }

    /**
     * 根据id更新业主信息
     * @param house
     * @return
     */
    @RequestMapping("/updateHouseById")
    public Result updateHouseById(@RequestBody House house){
        Boolean aBoolean = houseService.updateHouseById(house);
        return new Result(true,StatusCode.OK,MessageConstant.HOUSE_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id删除数据
     * @param ids
     * @return
     */
    @RequestMapping("/deleteHouseById")
    public Result deleteHouseById(@RequestBody List<Integer> ids){
        Boolean aBoolean = houseService.deleteHouseById(ids);
        return new Result(true, StatusCode.OK,MessageConstant.HOUSE_DELETE_SUCCESS,aBoolean);
    }

}

