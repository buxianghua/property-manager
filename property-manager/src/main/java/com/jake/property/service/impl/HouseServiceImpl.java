package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.House;
import com.jake.property.mapper.HouseMapper;
import com.jake.property.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<House> houseFindAll() {
        List<House> houses = houseMapper.selectList(null);
        return houses;
    }

    @Override
    public IPage<House> houseSearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<House> wrapper = new QueryWrapper<>();
        //条件查询
        if (!StringUtils.isEmpty(searchMap.get("startTime"))){
            //大于
            wrapper.gt("create_time",searchMap.get("startTime"));
        }
        if (!StringUtils.isEmpty(searchMap.get("endTime"))){
            //小于
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
        Page<House> page = new Page<>(pageNum,pageSize);
        Page<House> housePage = houseMapper.selectPage(page, wrapper);
        return housePage;
    }

    @Override
    public Boolean houseOwnAdd(House house) {

        int result = houseMapper.insert(house);
        return result>0;
    }

    @Override
    public House getHouseById(Integer id) {
        House house = houseMapper.selectById(id);
        return house;
    }

    @Override
    public Boolean updateHouseById(House house) {
        int result = houseMapper.updateById(house);
        return result>0;
    }

    @Override
    public Boolean deleteHouseById(List<Integer> ids) {
        int result = houseMapper.deleteBatchIds(ids);
        return result>0;
    }
}
