package com.jake.property.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.Building;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 楼栋表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface BuildingService extends IService<Building> {
    //查询所有楼宇信息
    public List<Building> buildingFindAll();

    //楼宇搜索
    public IPage<Building> buildingSearch(Map searchMap);

    //添加楼宇
    public Boolean buildingAdd(Building budding);

    //根据id获取对象信息
    public Building getBuildingById(Integer id);

    //通过id获取对象信息 修改
    public Boolean updateBuildingById(Building budding);

    //根据id删除楼宇数据
    public Boolean deleteBuildingById(List<Integer> ids);
}
