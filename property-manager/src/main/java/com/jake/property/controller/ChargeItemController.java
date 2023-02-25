package com.jake.property.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.ChargeItem;
import com.jake.property.service.ChargeItemService;
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
 * 收费项目表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/chargeItem")
public class ChargeItemController {

    @Autowired
    private ChargeItemService chargeItemService;

    /**
     * 查所有
     * @return
     */
    @RequestMapping("/chargeItemFindAll")
    public Result chargeItemFindAll(){
        List<ChargeItem> chargeItems = chargeItemService.chargeItemFindAll();
        return new Result(true, StatusCode.OK, MessageConstant.CHARGEITEM_SEARCH_SUCCESS,chargeItems);
    }

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    @PostMapping("/chargeItemSearch")
    public PageResult chargeItemSearch(@RequestBody Map searchMap){
        IPage<ChargeItem> chargeItemIPage = chargeItemService.chargeItemSearch(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.CHARGEITEM_SEARCH_SUCCESS,chargeItemIPage.getRecords(),chargeItemIPage.getTotal());
    }

    /**
     * 新增项目信息
     * @param chargeItem
     * @return
     */
    @PostMapping("/chargeItemAdd")
    public Result chargeItemAdd(@RequestBody ChargeItem chargeItem){
        Boolean aBoolean = chargeItemService.chargeItemAdd(chargeItem);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGEITEM_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @RequestMapping("/getChargeItemById")
    public Result getChargeItemById(Integer id){
        ChargeItem chargeItemById = chargeItemService.getChargeItemById(id);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGEITEM_FIND_BY_ID_SUCCESS,chargeItemById);
    }

    /**
     * 根据id更新数据
     * @param chargeItem
     * @return
     */
    @RequestMapping("/updateChargeItemById")
    public Result updateChargeItemById(@RequestBody ChargeItem chargeItem){
        Boolean aBoolean = chargeItemService.updateChargeItemById(chargeItem);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGEITEM_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id删除数据
     * @param ids
     * @return
     */
    @RequestMapping("/deleteChargeItemById")
    public Result deleteChargeItemById(@RequestBody List<Integer> ids){
        Boolean aBoolean = chargeItemService.deleteChargeItemById(ids);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGEITEM_DELETE_SUCCESS,aBoolean);
    }

}

