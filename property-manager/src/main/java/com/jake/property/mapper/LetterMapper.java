package com.jake.property.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jake.property.entity.Letter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 信件表 Mapper 接口
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Repository
@Mapper
public interface LetterMapper extends BaseMapper<Letter> {

}
