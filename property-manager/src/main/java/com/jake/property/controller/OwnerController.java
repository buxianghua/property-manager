package com.jake.property.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.Owner;
import com.jake.property.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/getOwnerByTelephone")
    public Result getOwnerByTelephone(@RequestBody Map ownerMap){
        System.out.println(ownerMap);
        Owner ownerByTelephone = ownerService.getOwnerByTelephone(ownerMap);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_FIND_BY_ID_SUCCESS,ownerByTelephone);
    }

    //测试方法
    @GetMapping("/ownerFindAll")
    public Result ownerFindAll(){
        List<Owner> owners = ownerService.ownerFindAll();
        return new Result(true, StatusCode.OK, MessageConstant.OWNER_SEARCH_SUCCESS,owners);
    }

    /**
     * 查询所有业主对象
     * @param searchMap
     * @return
     */
    @RequestMapping("/ownerSearch")
    public PageResult ownerSearch(@RequestBody Map searchMap){
        IPage<Owner> ownerIPage = ownerService.ownerSearch(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.OWNER_SEARCH_SUCCESS,ownerIPage.getRecords(),ownerIPage.getTotal());
    }

    /**
     * 添加业主信息
     * @param owner
     * @return
     */
    @RequestMapping("/ownerAdd")
    public Result ownerAdd(@RequestBody Owner owner){
        Boolean aBoolean = ownerService.ownerAdd(owner);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id查询单个业主信息
     * @param id
     * @return
     */
    @GetMapping("/getOwnerById")
    public Result getOwnerById(Integer id){
        Owner ownerById = ownerService.getOwnerById(id);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_FIND_BY_ID_SUCCESS,ownerById);
    }

    /**
     * 根据id更新业主数据
     * @param owner
     * @return
     */
    @RequestMapping("/updateOwnerById")
    public Result updateOwnerById(@RequestBody Owner owner){
        Boolean aBoolean = ownerService.updateOwnerById(owner);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id删除业主信息
     * @param ids
     * @return
     */
    @RequestMapping("/deleteOwnerById")
    public Result deleteOwnerById(@RequestBody List<Integer> ids){
        Boolean aBoolean = ownerService.deleteOwnerById(ids);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_DELETE_SUCCESS,aBoolean);
    }

}

