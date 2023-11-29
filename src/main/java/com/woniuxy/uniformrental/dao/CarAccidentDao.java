package com.woniuxy.uniformrental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.uniformrental.entity.CarAccident;
import org.apache.ibatis.annotations.Mapper;

/**
 * (CarAccident)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-27 19:25:52
 */
@Mapper
public interface CarAccidentDao extends BaseMapper<CarAccident> {

}

