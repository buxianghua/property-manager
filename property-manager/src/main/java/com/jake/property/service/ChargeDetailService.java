package com.jake.property.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.ChargeDetail;
import com.jake.property.entity.Repair;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收费名细表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface ChargeDetailService extends IService<ChargeDetail> {

    /**
     * 查询所有
     * @return
     */
    public List<ChargeDetail> chargeDetailFindAll();

    /**
     * 搜索所有收费信息
     * @param searchMap
     * @return
     */
    public IPage<ChargeDetail> chargeDetailSearch(Map searchMap);

    /**
     * 新增收费信息
     * @param chargeDetail
     * @return
     */
    public Boolean chargeDetailAdd(ChargeDetail chargeDetail);

    /**
     * 根据id获取对象信息
     * @param id
     * @return
     */
    public ChargeDetail getChargeDetailById(Integer id);

    /**
     * 通过id更新对象
     * @param chargeDetail
     * @return
     */
    public Boolean updateChargeDetailById(ChargeDetail chargeDetail);

    /**
     * 根据id修改缴费状态
     * @param status
     * @param id
     * @return
     */
    public Boolean updateChargeDetailStatus(int status,Integer id);

    /**
     * 根据id删除缴费信息
     * @param ids
     * @return
     */
    public Boolean deleteChargeDetailById(List<Integer> ids);

}
