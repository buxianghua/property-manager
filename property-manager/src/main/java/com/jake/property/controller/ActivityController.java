package com.jake.property.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.Activity;
import com.jake.property.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    //查所有
    @GetMapping("/activityFindAll")
    public Result activityFindAll(){
        List<Activity> activities = activityService.activitySearchAll();
        return new Result(true, StatusCode.OK, MessageConstant.ACTIVITY_SEARCH_SUCCESS,activities);
    }

    /**
     * 分页查活动信息
     * @param searchMap
     * @return
     */
    @RequestMapping("/activitySearch")
    public PageResult activitySearch(@RequestBody Map searchMap){
        IPage<Activity> activityIPage = activityService.activitySearch(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.ACTIVITY_SEARCH_SUCCESS,activityIPage.getRecords(),activityIPage.getTotal());
    }

    /**
     * 新增数据
     * @param activity
     * @return
     */
    @PostMapping("/activityAdd")
    public Result activityAdd(@RequestBody Activity activity){
        Boolean aBoolean = activityService.activityAdd(activity);
        return new Result(true,StatusCode.OK,MessageConstant.ACTIVITY_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id查询单个活动信息
     * @param id
     * @return
     */
    @GetMapping("/getActivityById")
    public Result getActivityById(Integer id){
        Activity activityById = activityService.getActivityById(id);
        return new Result(true,StatusCode.OK,MessageConstant.ACTIVITY_FIND_BY_ID_SUCCESS,activityById);
    }

    /**
     * 根据id更新活动数据
     * @param activity
     * @return
     */
    @RequestMapping("/updateActivityById")
    public Result updateActivityById(@RequestBody Activity activity){
        Boolean aBoolean = activityService.updateActivityById(activity);
        return new Result(true,StatusCode.OK,MessageConstant.ACTIVITY_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id修改活动状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateActivityStatus/{status}/{id}")
    public Result updateActivityStatus(@PathVariable("id")Integer id,@PathVariable("status")Integer status){
        Boolean aBoolean = activityService.updateActivityStatus(status, id);
        return new Result(true,StatusCode.OK,MessageConstant.ACTIVITY_UPDATE_STATUS_SUCCESS,aBoolean);
    }

    /**
     * 根据id删除活动数据
     * @param ids
     * @return
     */
    @RequestMapping("/deleteActivityById")
    public Result deleteActivityById(@RequestBody List<Integer> ids){
        Boolean aBoolean = activityService.deleteActivityById(ids);
        return new Result(true,StatusCode.OK,MessageConstant.ACTIVITY_DELETE_SUCCESS,aBoolean);
    }

}

