package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.uniformrental.dao.CarMaintenanceDao;
import com.woniuxy.uniformrental.entity.CarMaintenance;
import com.woniuxy.uniformrental.service.CarMaintenanceService;
import org.springframework.stereotype.Service;

/**
 * (CarMaintenance)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 19:07:05
 */
@Service("carMaintenanceService")
public class CarMaintenanceServiceImpl extends ServiceImpl<CarMaintenanceDao, CarMaintenance> implements CarMaintenanceService {

}

