package com.woniuxy.uniformrental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.uniformrental.entity.CarType;
import org.apache.ibatis.annotations.Mapper;

/**
 * 车辆类型(CarType)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-27 14:05:49
 */
@Mapper
public interface CarTypeDao extends BaseMapper<CarType> {

}

