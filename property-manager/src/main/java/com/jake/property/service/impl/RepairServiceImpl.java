package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Repair;
import com.jake.property.mapper.RepairMapper;
import com.jake.property.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 维修表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements RepairService {

    @Autowired
    private RepairMapper repairMapper;

    @Override
    public List<Repair> repairFindAll() {
        List<Repair> repairs = repairMapper.selectList(null);

        return repairs;
    }

    @Override
    public IPage<Repair> repairSearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<Repair> wrapper = new QueryWrapper<>();
        //条件查询
        if (!StringUtils.isEmpty(searchMap.get("startTime"))) {
            wrapper.gt("create_time", searchMap.get("startTime"));
        }
        if (!StringUtils.isEmpty(searchMap.get("endTime"))) {
            wrapper.lt("create_time", searchMap.get("endTime"));
        }
        //模糊查询
        if (!StringUtils.isEmpty(searchMap.get("ownerName"))){
            wrapper.like("owner_name",searchMap.get("ownerName"));
        }
        //分页
        if (searchMap.get("pageNum") != null) {
            pageNum = (int) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize") != null) {
            pageSize = (int) searchMap.get("pageSize");
        }
        Page<Repair> page = new Page<>(pageNum, pageSize);
        Page<Repair> repairPage = repairMapper.selectPage(page, wrapper);
        return repairPage;
    }

    @Override
    public Boolean repairAdd(Repair repair) {
        int result = repairMapper.insert(repair);
        return result > 0;
    }

    @Override
    public Repair getRepairById(Integer id) {
        Repair repair = repairMapper.selectById(id);
        return repair;
    }

    @Override
    public Boolean updateRepairById(Repair repair) {
        int result = repairMapper.updateById(repair);
        return result > 0;
    }

    @Override
    public Boolean updateRepairStatus(int status, Integer id) {
        Repair repair = new Repair();
        repair.setId(id);
        repair.setStatus(status);
        int result = repairMapper.updateById(repair);
        return result > 0;
    }

    @Override
    public Boolean deleteCommunityById(List<Integer> ids) {
        int result = repairMapper.deleteBatchIds(ids);
        return result > 0;
    }
}
