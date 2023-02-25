package com.jake.property.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.Community;
import com.jake.property.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 小区表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    //测试方法
    @RequestMapping("/communityFindAll")
    public Result communityFindAll() {
        List<Community> all = communityService.communityFindAll();
        return new Result(false, 200, "请求成功", all);
    }

    /**
     * RequestBody把前端Json格式数据转换成对象
     * 查询社区
     * @param searchMap
     * @return
     */
    @RequestMapping("/communitySearch")
    public PageResult communitySearch(@RequestBody Map searchMap) {
        IPage<Community> page = communityService.communitySearch(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, page.getRecords(), page.getTotal());
    }

    /**
     * 添加社区
     * @param community
     * @return
     */
    @PostMapping("/communityAdd")
    public Result communityAdd(@RequestBody Community community){
        Boolean aBoolean = communityService.communityAdd(community);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_ADD_SUCCESS,aBoolean);
    }

    /**
     * 根据id查询单个社区信息
     * @param id
     * @return
     */
    @GetMapping("/getCommunityById")
    public Result getCommunityById(Integer id){
        Community communityById = communityService.getCommunityById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,communityById);
    }

    /**
     * 根据id更新社区数据
     * @param community
     * @return
     */
    @RequestMapping("/updateCommunityById")
    public Result updateCommunityById(@RequestBody Community community){
        Boolean aBoolean = communityService.updateCommunityById(community);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_SUCCESS,aBoolean);
    }

    /**
     * 根据id修改社区状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateCommunityStatus/{status}/{id}")
    public Result updateCommunityStatus(@PathVariable("id") Integer id,@PathVariable("status") int status){
        Boolean aBoolean = communityService.updateCommunityStatus(status, id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_STATUS_SUCCESS,aBoolean);
    }

    /**
     * 根据id删除社区
     * @param ids
     * @return
     */
    @RequestMapping("/deleteCommunityById")
    public Result deleteCommunityById(@RequestBody List<Integer> ids){
        Boolean aBoolean = communityService.deleteCommunityById(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS,aBoolean);
    }
}

