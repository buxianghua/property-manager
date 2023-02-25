package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.ChargeDetail;
import com.jake.property.mapper.ChargeDetailMapper;
import com.jake.property.service.ChargeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收费名细表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class ChargeDetailServiceImpl extends ServiceImpl<ChargeDetailMapper, ChargeDetail> implements ChargeDetailService {

    @Autowired
    private ChargeDetailMapper chargeDetailMapper;

    @Override
    public List<ChargeDetail> chargeDetailFindAll() {

        List<ChargeDetail> chargeDetails = chargeDetailMapper.selectList(null);

        return chargeDetails;
    }

    @Override
    public IPage<ChargeDetail> chargeDetailSearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<ChargeDetail> wrapper = new QueryWrapper<>();
        //条件查询
        if (!StringUtils.isEmpty(searchMap.get("startTime"))) {
            wrapper.gt("end_time", searchMap.get("startTme"));
        }
        if (!StringUtils.isEmpty(searchMap.get("endTime"))) {
            wrapper.lt("end_time", searchMap.get("endTime"));
        }
        //模糊查询
        if (!StringUtils.isEmpty(searchMap.get("contractor"))) {
            wrapper.like("contractor", searchMap.get("contractor"));
        }
        //分页
        if (searchMap.get("pageNum") != null) {
            pageNum = (int) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize") != null) {
            pageSize = (int) searchMap.get("pageSize");
        }
        Page<ChargeDetail> page = new Page<>(pageNum, pageSize);
        Page<ChargeDetail> chargeDetailPage = chargeDetailMapper.selectPage(page, wrapper);
        return chargeDetailPage;
    }

    @Override
    public Boolean chargeDetailAdd(ChargeDetail chargeDetail) {
        int result = chargeDetailMapper.insert(chargeDetail);
        return result > 0;
    }

    @Override
    public ChargeDetail getChargeDetailById(Integer id) {
        ChargeDetail chargeDetail = chargeDetailMapper.selectById(id);
        return chargeDetail;
    }

    @Override
    public Boolean updateChargeDetailById(ChargeDetail chargeDetail) {
        int result = chargeDetailMapper.updateById(chargeDetail);
        return result > 0;
    }

    @Override
    public Boolean updateChargeDetailStatus(int status, Integer id) {
        ChargeDetail chargeDetail = new ChargeDetail();
        chargeDetail.setId(id);
        chargeDetail.setStatus(status);
        int result = chargeDetailMapper.updateById(chargeDetail);
        return result > 0;
    }

    @Override
    public Boolean deleteChargeDetailById(List<Integer> ids) {
        int result = chargeDetailMapper.deleteBatchIds(ids);
        return result > 0;
    }
}
