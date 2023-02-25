package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Owner;
import com.jake.property.mapper.OwnerMapper;
import com.jake.property.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements OwnerService {

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public List<Owner> ownerFindAll() {
        List<Owner> owners = ownerMapper.selectList(null);
        return owners;
    }

    @Override
    public IPage<Owner> ownerSearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<Owner> wrapper = new QueryWrapper<>();
        //条件查询
        if (!StringUtils.isEmpty(searchMap.get("startTime"))){
            wrapper.ge("create_time",searchMap.get("startTime"));
        }
        if (!StringUtils.isEmpty(searchMap.get("endTime"))){
            wrapper.lt("create_time",searchMap.get("endTime"));
        }
        //模糊查询
        if (searchMap.get("name")!=null){
            wrapper.like("name",searchMap.get("name"));
        }
        //分页查询
        if (searchMap.get("pageNum")!=null){
            pageNum = (int) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize")!=null){
            pageSize = (int) searchMap.get("pageSize");
        }
        Page<Owner> page = new Page<>(pageNum,pageSize);
        Page<Owner> ownerPage = ownerMapper.selectPage(page, wrapper);
        return ownerPage;
    }

    @Override
    public Boolean ownerAdd(Owner owner) {
        int insert = ownerMapper.insert(owner);
        return insert>0;
    }

    @Override
    public Owner getOwnerById(Integer id) {
        Owner owner = ownerMapper.selectById(id);
        return owner;
    }

    @Override
    public Boolean updateOwnerById(Owner owner) {
        int result = ownerMapper.updateById(owner);
        return result>0;
    }

    @Override
    public Boolean deleteOwnerById(List<Integer> ids) {
        int result = ownerMapper.deleteBatchIds(ids);
        return result>0;
    }

    @Override
    public Owner getOwnerByTelephone(Map ownerMap) {
        System.out.println(ownerMap);
        QueryWrapper<Owner> wrapper = new QueryWrapper<>();
        wrapper.eq("telephone",ownerMap.get("telephone"));
        Owner owner = ownerMapper.selectOne(wrapper);
        boolean password = owner.getPassword().equals(ownerMap.get("password"));
        if (password){
            owner.setPassword(null);
            return owner;
        }else {
            return null;
        }
    }

}
