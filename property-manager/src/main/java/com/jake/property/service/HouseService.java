package com.jake.property.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.Building;
import com.jake.property.entity.House;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface HouseService extends IService<House> {

    //查询所有业主信息
    public List<House> houseFindAll();
    //房屋信息搜索
    public IPage<House> houseSearch(Map searchMap);
    //添加业主信息
    public Boolean houseOwnAdd(House house);
    //根据id获取对象信息
    public House getHouseById(Integer id);
    //通过id获取对象信息 修改
    public Boolean updateHouseById(House house);
    //根据id删除房屋信息
    public Boolean deleteHouseById(List<Integer> ids);
}
