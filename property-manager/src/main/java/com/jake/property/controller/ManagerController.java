package com.jake.property.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.Manager;
import com.jake.property.service.ManagerService;
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
 * 物业管理人员表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    /**
     * 查询所有表单信息
     * @return
     */
    @RequestMapping("/managerFindAll")
    public Result managerFindAll(){
        List<Manager> managers = managerService.managerFindAll();
        return new Result(true, StatusCode.OK, MessageConstant.MANAGER_SEARCH_SUCCESS,managers);
    }

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    @RequestMapping("/managerSearch")
    public PageResult managerSearch(@RequestBody Map searchMap){
        IPage<Manager> managerIPage = managerService.managerSearch(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.MANAGER_SEARCH_SUCCESS,managerIPage.getRecords(),managerIPage.getTotal());
    }

    /**
     * 添加用户信息
     * @param manager
     * @return
     */
    @PostMapping("/managerAdd")
    public Result managerAdd(@RequestBody Manager manager){
        Boolean aBoolean = managerService.managerAdd(manager);
        return new Result(true,StatusCode.OK,MessageConstant.MANAGER_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id更新用户数据
     * @param manager
     * @return
     */
    @RequestMapping("/updateManagerById")
    public Result updateManagerById(@RequestBody Manager manager){
        Boolean aBoolean = managerService.updateManagerById(manager);
        return new Result(true,StatusCode.OK,MessageConstant.MANAGER_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id查询用户数据
     * @param id
     * @return
     */
    @RequestMapping("/getManagerById")
    public Result getManagerById(Integer id){
        Manager managerById = managerService.getManagerById(id);
        return new Result(true,StatusCode.OK,MessageConstant.MANAGER_FIND_BY_ID_SUCCESS,managerById);
    }

    /**
     * 根据id删除用户数据
     * @param ids
     * @return
     */
    @RequestMapping("/deleteManagerById")
    public Result deleteManagerById(@RequestBody List<Integer> ids){
        Boolean aBoolean = managerService.deleteManagerById(ids);
        return new Result(true,StatusCode.OK,MessageConstant.MANAGER_DELETE_SUCCESS,aBoolean);
    }

}

