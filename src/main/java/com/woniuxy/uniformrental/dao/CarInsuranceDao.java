package com.woniuxy.uniformrental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.uniformrental.entity.CarInsurance;
import org.apache.ibatis.annotations.Mapper;

/**
 * (CarInsurance)表数据库访问层
 *
 * @author makejava
 * @since 2023-11-27 19:25:02
 */
@Mapper
public interface CarInsuranceDao extends BaseMapper<CarInsurance> {

}

