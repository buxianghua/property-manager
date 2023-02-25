package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.ChargeItem;
import com.jake.property.mapper.ChargeItemMapper;
import com.jake.property.service.ChargeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收费项目表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class ChargeItemServiceImpl extends ServiceImpl<ChargeItemMapper, ChargeItem> implements ChargeItemService {

    @Autowired
    private ChargeItemMapper chargeItemMapper;

    @Override
    public List<ChargeItem> chargeItemFindAll() {
        List<ChargeItem> chargeItems = chargeItemMapper.selectList(null);
        return chargeItems;
    }

    @Override
    public IPage<ChargeItem> chargeItemSearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<ChargeItem> wrapper = new QueryWrapper<>();
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
        Page<ChargeItem> page = new Page<>(pageNum, pageSize);
        Page<ChargeItem> chargeItemPage = chargeItemMapper.selectPage(page, wrapper);
        return chargeItemPage;
    }

    @Override
    public Boolean chargeItemAdd(ChargeItem chargeItem) {
        int result = chargeItemMapper.insert(chargeItem);
        return result > 0;
    }

    @Override
    public ChargeItem getChargeItemById(Integer id) {
        ChargeItem chargeItem = chargeItemMapper.selectById(id);
        return chargeItem;
    }

    @Override
    public Boolean updateChargeItemById(ChargeItem chargeItem) {
        int result = chargeItemMapper.updateById(chargeItem);
        return result > 0;
    }

    @Override
    public Boolean deleteChargeItemById(List<Integer> ids) {
        int result = chargeItemMapper.deleteBatchIds(ids);
        return result > 0;
    }
}
