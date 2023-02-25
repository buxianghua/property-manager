package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Manager;
import com.jake.property.mapper.ManagerMapper;
import com.jake.property.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物业管理人员表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public List<Manager> managerFindAll() {
        List<Manager> managers = managerMapper.selectList(null);
        return managers;
    }

    @Override
    public IPage<Manager> managerSearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<Manager> wrapper = new QueryWrapper<>();
        //条件查询
        if (!StringUtils.isEmpty(searchMap.get("startTime"))) {
            wrapper.gt("create_time", searchMap.get("startTime"));
        }
        if (!StringUtils.isEmpty(searchMap.get("endTime"))) {
            wrapper.lt("create_time", searchMap.get("endTime"));
        }
        //模糊查询
        if (!StringUtils.isEmpty(searchMap.get("name"))) {
            wrapper.like("name", searchMap.get("name"));
        }
        //分页查询
        if (searchMap.get("pageNum") != null) {
            pageNum = (int) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize") != null) {
            pageSize = (int) searchMap.get("pageSize");
        }
        Page<Manager> page = new Page<>(pageNum, pageSize);
        Page<Manager> managerPage = managerMapper.selectPage(page, wrapper);
        return managerPage;
    }

    @Override
    public Boolean managerAdd(Manager manager) {
        int result = managerMapper.insert(manager);
        return result > 0;
    }

    @Override
    public Manager getManagerById(Integer id) {
        Manager manager = managerMapper.selectById(id);
        return manager;
    }

    @Override
    public Boolean updateManagerById(Manager manager) {
        int result = managerMapper.updateById(manager);
        return result > 0;
    }

    @Override
    public Boolean deleteManagerById(List<Integer> ids) {
        int result = managerMapper.deleteBatchIds(ids);
        return result > 0;
    }
}
