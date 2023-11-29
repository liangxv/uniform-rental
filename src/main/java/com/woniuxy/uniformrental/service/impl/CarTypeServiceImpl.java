package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.uniformrental.dao.CarTypeDao;
import com.woniuxy.uniformrental.entity.CarType;
import com.woniuxy.uniformrental.service.CarTypeService;
import org.springframework.stereotype.Service;

/**
 * 车辆类型(CarType)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 14:05:49
 */
@Service("carTypeService")
public class CarTypeServiceImpl extends ServiceImpl<CarTypeDao, CarType> implements CarTypeService {

}

