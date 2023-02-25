package com.jake.property.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.Activity;
import com.jake.property.entity.Admin;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface ActivityService extends IService<Activity> {
    /**
     * 查询所有活动信息
     * @return
     */
    List<Activity> activitySearchAll();

    /**
     * 分页查
     * @param searchMap
     * @return
     */
    public IPage<Activity> activitySearch(Map searchMap);

    /**
     * 新增活动信息
     * @param activity
     * @return
     */
    public Boolean activityAdd(Activity activity);

    /**
     * 根据id修改对象信息
     * @param id
     * @return
     */
    public Activity getActivityById(Integer id);

    /**
     * 根据id修改活动状态
     * @param status
     * @param id
     * @return
     */
    public Boolean updateActivityStatus(int status, Integer id);

    /**
     * 更新信息
     * @param activity
     * @return
     */
    public Boolean updateActivityById(Activity activity);

    /**
     * 根据id删除数据
     * @param ids
     * @return
     */
    public Boolean deleteActivityById(List<Integer> ids);

}
