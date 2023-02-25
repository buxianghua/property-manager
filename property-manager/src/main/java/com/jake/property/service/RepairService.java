package com.jake.property.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.Repair;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 维修表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface RepairService extends IService<Repair> {

    /**
     * 查询所有报修信息
     * @return
     */
    public List<Repair> repairFindAll();

    /**
     * 搜索所有报修
     * @param searchMap
     * @return
     */
    public IPage<Repair> repairSearch(Map searchMap);

    /**
     * 新增报修信息
     * @param repair
     * @return
     */
    public Boolean repairAdd(Repair repair);

    /**
     * 根据id获取对象信息
     * @param id
     * @return
     */
    public Repair getRepairById(Integer id);

    /**
     * 通过id修改对象信息
     * @param repair
     * @return
     */
    public Boolean updateRepairById(Repair repair);

    /**
     * 根据id修改维修状态
     * @param status
     * @param id
     * @return
     */
    public Boolean updateRepairStatus(int status, Integer id);

    /**
     * 根据id删除报修数据
     * @param ids
     * @return
     */
    public Boolean deleteCommunityById(List<Integer> ids);

}
