package com.jake.property.controller;


import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.Repair;
import com.jake.property.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 维修表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    //测试
    @RequestMapping("/repairFindAll")
    public Result repairFindAll(){
        List<Repair> repairs = repairService.repairFindAll();
        return new Result(true, StatusCode.OK, MessageConstant.REPAIR_SEARCH_SUCCESS,repairs);
    }

    /**
     * 查询维修信息
     * @param searchMap
     * @return
     */
    @RequestMapping("/repairSearch")
    public PageResult repairSearch(@RequestBody Map searchMap){
        IPage<Repair> repairIPage = repairService.repairSearch(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.REPAIR_SEARCH_SUCCESS,repairIPage.getRecords(),repairIPage.getTotal());
    }

    /**
     * 新增维修信息
     * @param repair
     * @return
     */
    @PostMapping("/repairAdd")
    public Result repairAdd(@RequestBody Repair repair){
        Boolean aBoolean = repairService.repairAdd(repair);
        return new Result(true,StatusCode.OK,MessageConstant.REPAIR_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id查询单个维修信息
     * @param id
     * @return
     */
    @GetMapping("/getRepairById")
    public Result getRepairById(Integer id){
        Repair repairById = repairService.getRepairById(id);
        return new Result(true,StatusCode.OK,MessageConstant.REPAIR_FIND_BY_ID_SUCCESS,repairById);
    }

    /**
     * 根据id更新数据
     * @param repair
     * @return
     */
    @RequestMapping("/updateRepairById")
    public Result updateRepairById(@RequestBody Repair repair){
        Boolean aBoolean = repairService.updateRepairById(repair);
        return new Result(true,StatusCode.OK,MessageConstant.REPAIR_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id修改维修状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateRepairStatus/{status}/{id}")
    public Result updateRepairStatus(@PathVariable("id") Integer id,@PathVariable("status")Integer status){
        Boolean aBoolean = repairService.updateRepairStatus(status, id);
        return new Result(true,StatusCode.OK,MessageConstant.REPAIR_UPDATE_STATUS_SUCCESS,aBoolean);
    }

    /**
     * 根据id删除数据
     * @param ids
     * @return
     */
    @RequestMapping("/deleteRepairById")
    public Result deleteRepairById(@RequestBody List<Integer> ids){
        Boolean aBoolean = repairService.deleteCommunityById(ids);
        return new Result(true,StatusCode.OK,MessageConstant.REPAIR_DELETE_SUCCESS,aBoolean);
    }

}

