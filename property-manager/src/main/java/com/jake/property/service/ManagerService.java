package com.jake.property.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.Manager;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物业管理人员表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface ManagerService extends IService<Manager> {

    /**
     * 查询所有管理员信息
     * @return
     */
    public List<Manager> managerFindAll();

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    public IPage<Manager> managerSearch(Map searchMap);

    /**
     * 添加用户信息
     * @param manager
     * @return
     */
    public Boolean managerAdd(Manager manager);

    /**
     * 根据id获取对象信息
     * @param id
     * @return
     */
    public Manager getManagerById(Integer id);

    /**
     * 根据id获取对象信息 修改
     * @param manager
     * @return
     */
    public Boolean updateManagerById(Manager manager);

    /**
     * 根据id删除用户信息
     * @param ids
     * @return
     */
    public Boolean deleteManagerById(List<Integer> ids);

}
