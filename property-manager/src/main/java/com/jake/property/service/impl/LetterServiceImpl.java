package com.jake.property.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Letter;
import com.jake.property.mapper.LetterMapper;
import com.jake.property.service.LetterService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 信件表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class LetterServiceImpl extends ServiceImpl<LetterMapper, Letter> implements LetterService {

}
