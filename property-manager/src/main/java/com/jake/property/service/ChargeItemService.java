package com.jake.property.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.ChargeItem;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收费项目表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface ChargeItemService extends IService<ChargeItem> {

    /**
     * 查询所有收费项目
     * @return
     */
    public List<ChargeItem> chargeItemFindAll();

    /**
     * 分页查询所有信息
     * @param searchMap
     * @return
     */
    public IPage<ChargeItem> chargeItemSearch(Map searchMap);

    /**
     *
     * @param chargeItem
     * @return
     */
    public Boolean chargeItemAdd(ChargeItem chargeItem);

    /**
     * 根据id获取收费项目对象信息
     * @param id
     * @return
     */
    public ChargeItem getChargeItemById(Integer id);

    /**
     * 根据id更新对象信息
     * @param chargeItem
     * @return
     */
    public Boolean updateChargeItemById(ChargeItem chargeItem);

    /**
     * 根据id删除数据
     * @param ids
     * @return
     */
    public Boolean deleteChargeItemById(List<Integer> ids);

}
