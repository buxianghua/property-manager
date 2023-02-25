package com.jake.property.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Pet;
import com.jake.property.mapper.PetMapper;
import com.jake.property.service.PetService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 宠物表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements PetService {

}
