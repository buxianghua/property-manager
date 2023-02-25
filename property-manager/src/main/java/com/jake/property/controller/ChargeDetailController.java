package com.jake.property.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.ChargeDetail;
import com.jake.property.entity.ChargeItem;
import com.jake.property.service.ChargeDetailService;
import com.jake.property.service.ChargeItemService;
import com.jake.property.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收费名细表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/chargeDetail")
public class ChargeDetailController {

    @Autowired
    private ChargeDetailService chargeDetailService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/chargeDetailFindAll")
    public Result chargeDetailFindAll(){
        List<ChargeDetail> chargeDetails = chargeDetailService.chargeDetailFindAll();
        return new Result(true, StatusCode.OK, MessageConstant.CHARGEDETAIL_SEARCH_SUCCESS,chargeDetails);
    }

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    @PostMapping("/chargeDetailSearch")
    public PageResult chargeDetailSearch(@RequestBody Map searchMap){
        IPage<ChargeDetail> chargeDetailIPage = chargeDetailService.chargeDetailSearch(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.CHARGEDETAIL_SEARCH_SUCCESS,chargeDetailIPage.getRecords(),chargeDetailIPage.getTotal());
    }

    /**
     * 新增收费信息
     * @param chargeDetail
     * @return
     */
    @PostMapping("/chargeDetailAdd")
    public Result chargeDetailAdd(@RequestBody ChargeDetail chargeDetail){
        Boolean aBoolean = chargeDetailService.chargeDetailAdd(chargeDetail);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGEDETAIL_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id查询收费信息
     * @param id
     * @return
     */
    @GetMapping("/getChargeDetailById")
    public Result getChargeDetailById(Integer id){
        ChargeDetail chargeDetailById = chargeDetailService.getChargeDetailById(id);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGEDETAIL_FIND_BY_ID_SUCCESS,chargeDetailById);
    }

    /**
     * 根据id更新数据
     * @param chargeDetail
     * @return
     */
    @RequestMapping("/updateChargeDetailById")
    public Result updateChargeDetailById(@RequestBody ChargeDetail chargeDetail){
        Boolean aBoolean = chargeDetailService.updateChargeDetailById(chargeDetail);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGEDETAIL_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id修改缴费状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateChargeDetailStatus/{status}/{id}")
    public Result updateChargeDetailStatus(@PathVariable("id") Integer id,@PathVariable("status")Integer status){
        Boolean aBoolean = chargeDetailService.updateChargeDetailStatus(status, id);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGEDETAIL_UPDATE_STATUS_SUCCESS,aBoolean);
    }

    /**
     * 根据id删除数据
     * @param ids
     * @return
     */
    @RequestMapping("/deleteChargeDetailById")
    public Result deleteChargeDetailById(@RequestBody List<Integer> ids){
        Boolean aBoolean = chargeDetailService.deleteChargeDetailById(ids);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGEDETAIL_DELETE_SUCCESS,aBoolean);
    }

}

