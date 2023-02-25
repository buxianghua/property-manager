package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Activity;
import com.jake.property.mapper.ActivityMapper;
import com.jake.property.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> activitySearchAll() {
        List<Activity> activities = activityMapper.selectList(null);

        return activities;
    }

    @Override
    public IPage<Activity> activitySearch(Map searchMap) {
        int pageNum =1 ;
        int pageSize = 2;
        QueryWrapper<Activity> wrapper = new QueryWrapper<>();
        //条件查询
        if (!StringUtils.isEmpty(searchMap.get("startTime"))){
            wrapper.gt("create_time",searchMap.get("startTime"));
        }
        if (!StringUtils.isEmpty(searchMap.get("endTime"))){
            wrapper.lt("create_time",searchMap.get("endTime"));
        }
        //模糊查询
        if (!StringUtils.isEmpty(searchMap.get("title"))){
            wrapper.like("title",searchMap.get("title"));
        }
        //分页
        if (searchMap.get("pageNum")!=null){
            pageNum= (int) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize")!=null){
            pageSize = (int) searchMap.get("pageSize");
        }
        Page<Activity> page = new Page<>(pageNum,pageSize);
        Page<Activity> activityPage = activityMapper.selectPage(page, wrapper);
        return activityPage;
    }

    @Override
    public Boolean activityAdd(Activity activity) {
        int insert = activityMapper.insert(activity);
        return insert>0;
    }

    @Override
    public Activity getActivityById(Integer id) {
        Activity activity = activityMapper.selectById(id);
        return activity;
    }

    @Override
    public Boolean updateActivityStatus(int status, Integer id) {
        Activity activity = new Activity();
        activity.setId(id);
        activity.setStatus(status);
        int i = activityMapper.updateById(activity);
        return i>0;
    }

    @Override
    public Boolean updateActivityById(Activity activity) {
        int i = activityMapper.updateById(activity);
        return i>0;
    }

    @Override
    public Boolean deleteActivityById(List<Integer> ids) {
        int i = activityMapper.deleteBatchIds(ids);
        return i>0;
    }
}
