package com.jake.property.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.Owner;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface OwnerService extends IService<Owner> {

    //查询所有个体
    List<Owner> ownerFindAll();

    //个体分页检索
    IPage<Owner> ownerSearch(Map searchMap);

    //增加个体
    Boolean ownerAdd(Owner owner);

    //根据id查询对象信息
    Owner getOwnerById(Integer id);

    //根据id更新数据
    Boolean updateOwnerById(Owner owner);

    //根据id删除个体数据
    Boolean deleteOwnerById(List<Integer> ids);

    //根据电话查询用户
    public Owner getOwnerByTelephone(Map ownerMap);

}
