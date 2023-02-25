package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Building;
import com.jake.property.mapper.BuildingMapper;
import com.jake.property.mapper.CommunityMapper;
import com.jake.property.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 楼栋表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> buildingFindAll() {
        List<Building> buildings = buildingMapper.selectList(null);
        return buildings;
    }

    @Override
    public IPage<Building> buildingSearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<Building> wrapper = new QueryWrapper<>();
        //条件查询
        if (!StringUtils.isEmpty(searchMap.get("startTime"))){
            wrapper.gt("create_time",searchMap.get("startTime"));
        }
        if (!StringUtils.isEmpty(searchMap.get("endTime"))){
            wrapper.lt("create_time",searchMap.get("endTime"));
        }
        //模糊查询
        if (!StringUtils.isEmpty(searchMap.get("name"))){
            wrapper.like("name",searchMap.get("name"));
        }
        //分页查询
        if (searchMap.get("pageNum")!=null){
            pageNum = (int) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize")!=null){
            pageSize = (int) searchMap.get("pageSize");
        }
        Page<Building> page = new Page<>(pageNum,pageSize);
        IPage<Building> bidiLineIPage = buildingMapper.selectPage(page,wrapper);
        return bidiLineIPage;
    }

    @Override
    public Boolean buildingAdd(Building budding) {
        int result = buildingMapper.insert(budding);
        //大于0则添加成功
        return result>0;
    }

    @Override
    public Building getBuildingById(Integer id) {
        Building building = buildingMapper.selectById(id);
        return building;
    }

    @Override
    public Boolean updateBuildingById(Building budding) {
        int result = buildingMapper.updateById(budding);
        return result>0;
    }

    @Override
    public Boolean deleteBuildingById(List<Integer> ids) {
        int result = buildingMapper.deleteBatchIds(ids);
        return result>0;
    }
}
