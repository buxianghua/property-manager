package com.jake.property.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.Device;
import com.jake.property.entity.Repair;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface DeviceService extends IService<Device> {

    /**
     * 查询所有设备
     * @return
     */
    public List<Device> deviceFindAll();

    /**
     * 分页搜索设备信息
     * @param searchMap
     * @return
     */
    public IPage<Device> deviceSearch(Map searchMap);

    /**
     * 新增设备
     * @param device
     * @return
     */
    public Boolean deviceAdd(Device device);

    /**
     * 根据id获取对象信息
     * @param id
     * @return
     */
    public Device getDeviceById(Integer id);

    /**
     * 根据id更新对象信息
     * @param device
     * @return
     */
    public Boolean updateDeviceById(Device device);

    /**
     * 根据id删除数据
     * @param ids
     * @return
     */
    public Boolean deleteDeviceById(List<Integer> ids);

}
