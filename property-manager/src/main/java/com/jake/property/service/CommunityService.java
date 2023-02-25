package com.jake.property.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.Community;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 小区表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface CommunityService extends IService<Community> {
    //查询所有社区信息
    public List<Community> communityFindAll();

    //社区搜索
    public IPage<Community> communitySearch(Map searchMap);

    //添加社区
    public Boolean communityAdd(Community community);

    //根据id获取对象信息
    public Community getCommunityById(Integer id);

    //通过id获取对象信息 修改
    public Boolean updateCommunityById(Community community);

    //根据id查询修改状态
    public Boolean updateCommunityStatus(int status, Integer id);

    //根据id删除社区数据
    public Boolean deleteCommunityById(List<Integer> ids);
}
