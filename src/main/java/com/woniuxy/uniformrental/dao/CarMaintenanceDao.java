package com.woniuxy.uniformrental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.uniformrental.entity.CarMaintenance;
import org.apache.ibatis.annotations.Mapper;

/**
 * (CarMaintenance)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-27 19:07:05
 */
@Mapper
public interface CarMaintenanceDao extends BaseMapper<CarMaintenance> {

}

