package com.woniuxy.uniformrental.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.woniuxy.uniformrental.entity.Car;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Car)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-27 10:22:29
 */
@Mapper
public interface CarDao extends MPJBaseMapper<Car> {

}

