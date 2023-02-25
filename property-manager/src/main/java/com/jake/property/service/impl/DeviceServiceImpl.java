package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Device;
import com.jake.property.mapper.DeviceMapper;
import com.jake.property.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<Device> deviceFindAll() {
        List<Device> devices = deviceMapper.selectList(null);
        return devices;
    }

    @Override
    public IPage<Device> deviceSearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<Device> wrapper = new QueryWrapper<>();
        //条件查询
        if (!StringUtils.isEmpty(searchMap.get("startTime"))) {
            wrapper.gt("create_time", searchMap.get("startTime"));
        }
        if (!StringUtils.isEmpty(searchMap.get("endTime"))) {
            wrapper.lt("create_time", searchMap.get("endTime"));
        }
        //模糊查询
        if (!StringUtils.isEmpty("name")) {
            wrapper.like("name", searchMap.get("name"));
        }
        //分页
        if (searchMap.get("pageNum") != null) {
            pageNum = (int) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize") != null) {
            pageSize = (int) searchMap.get("pageSize");
        }
        Page<Device> page = new Page<>(pageNum, pageSize);
        Page<Device> devicePage = deviceMapper.selectPage(page, wrapper);
        return devicePage;
    }

    @Override
    public Boolean deviceAdd(Device device) {
        int insert = deviceMapper.insert(device);
        return insert > 0;
    }

    @Override
    public Device getDeviceById(Integer id) {
        Device device = deviceMapper.selectById(id);
        return device;
    }

    @Override
    public Boolean updateDeviceById(Device device) {
        int result = deviceMapper.updateById(device);
        return result > 0;
    }

    @Override
    public Boolean deleteDeviceById(List<Integer> ids) {
        int result = deviceMapper.deleteBatchIds(ids);
        return result > 0;
    }
}
