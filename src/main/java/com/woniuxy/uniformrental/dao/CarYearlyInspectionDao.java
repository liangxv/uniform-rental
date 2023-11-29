package com.woniuxy.uniformrental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.uniformrental.entity.CarYearlyInspection;
import org.apache.ibatis.annotations.Mapper;

/**
 * (CarYearlyInspection)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-27 19:26:10
 */
@Mapper
public interface CarYearlyInspectionDao extends BaseMapper<CarYearlyInspection> {

}

