package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.common.Result;
import com.jake.property.mapper.CommunityMapper;
import com.jake.property.entity.Community;
import com.jake.property.service.CommunityService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 小区表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements CommunityService {
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public List<Community> communityFindAll() {
        List<Community> communities = communityMapper.selectList(null);
        return communities;
    }

    @Override
    public IPage<Community> communitySearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<Community> wrapper = new QueryWrapper<>();
        //条件查询
        if (!StringUtils.isEmpty(searchMap.get("startTime"))) {
            wrapper.gt("create_time", searchMap.get("startTime"));
        }
        if (!StringUtils.isEmpty(searchMap.get("endTime"))) {
            wrapper.lt("create_time", searchMap.get("endTime"));
        }
        //模糊查询
        if (!StringUtils.isEmpty(searchMap.get("name"))) {
            wrapper.like("name", searchMap.get("name"));
        }
        //分页查询
        if (searchMap.get("pageNum") != null) {
            pageNum = (int) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize") != null) {
            pageSize = (int) searchMap.get("pageSize");
        }
        Page<Community> page = new Page<>(pageNum, pageSize);
        IPage<Community> communityIPage = communityMapper.selectPage(page, wrapper);

        return communityIPage;
    }

    @Override
    public Boolean communityAdd(Community community) {

        int insert = communityMapper.insert(community);
        //大于0添加成功
        return insert > 0;
    }

    @Override
    public Community getCommunityById(Integer id) {
        Community community = communityMapper.selectById(id);

        return community;
    }

    @Override
    public Boolean updateCommunityById(Community community) {
        int result = communityMapper.updateById(community);
        return result > 0;
    }

    @Override
    public Boolean updateCommunityStatus(int status, Integer id) {
        Community community = new Community();
        community.setId(id);
        community.setStatus(status);
        int result = communityMapper.updateById(community);
        return result > 0;
    }

    @Override
    public Boolean deleteCommunityById(List<Integer> ids) {
        int result = communityMapper.deleteBatchIds(ids);
        // System.out.println(result);
        return result > 0;
    }
}
