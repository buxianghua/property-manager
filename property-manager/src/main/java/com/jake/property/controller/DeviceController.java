package com.jake.property.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.Device;
import com.jake.property.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    //测试
    @RequestMapping("/deviceFindAll")
    public Result deviceFindAll(){
        List<Device> devices = deviceService.deviceFindAll();
        return new Result(true, StatusCode.OK, MessageConstant.DEVICE_SEARCH_SUCCESS,devices);
    }

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    @PostMapping("/deviceSearch")
    public PageResult deviceSearch(@RequestBody Map searchMap){
        IPage<Device> deviceIPage = deviceService.deviceSearch(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.DEVICE_SEARCH_SUCCESS,deviceIPage.getRecords(),deviceIPage.getTotal());
    }

    /**
     * 新增设备信息
     * @param device
     * @return
     */
    @PostMapping("/deviceAdd")
    public Result deviceAdd(@RequestBody Device device){
        Boolean aBoolean = deviceService.deviceAdd(device);
        return new Result(true,StatusCode.OK,MessageConstant.DEVICE_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @RequestMapping("/getDeviceById")
    public Result getDeviceById(Integer id){
        Device deviceById = deviceService.getDeviceById(id);
        return new Result(true,StatusCode.OK,MessageConstant.DEVICE_FIND_BY_ID_SUCCESS,deviceById);
    }

    /**
     * 根据id更新数据
     * @param device
     * @return
     */
    @RequestMapping("/updateDeviceById")
    public Result updateDeviceById(@RequestBody Device device){
        Boolean aBoolean = deviceService.updateDeviceById(device);
        return new Result(true,StatusCode.OK,MessageConstant.DEVICE_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id删除数据
     * @param ids
     * @return
     */
    @RequestMapping("/deleteDeviceById")
    public Result deleteDeviceById(@RequestBody List<Integer> ids){
        Boolean aBoolean = deviceService.deleteDeviceById(ids);
        return new Result(true,StatusCode.OK,MessageConstant.DEVICE_DELETE_SUCCESS,aBoolean);
    }

}

