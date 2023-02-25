package com.jake.property.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Complaint;
import com.jake.property.mapper.ComplaintMapper;
import com.jake.property.service.ComplaintService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 投诉表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {

}
