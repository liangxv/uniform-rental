package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.uniformrental.dao.CarMaintenanceDao;
import com.woniuxy.uniformrental.dto.MaintenanceDto;
import com.woniuxy.uniformrental.entity.Car;
import com.woniuxy.uniformrental.entity.CarMaintenance;
import com.woniuxy.uniformrental.service.CarMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (CarMaintenance)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 19:07:05
 */
@Service
public class CarMaintenanceServiceImpl extends ServiceImpl<CarMaintenanceDao, CarMaintenance> implements CarMaintenanceService {

    @Autowired
    CarMaintenanceDao carMaintenanceDao;

    @Override
    public Page<MaintenanceDto> maintenancePage(Integer pageNum, Integer pageSize, String frameNumber, String carNumber, Integer state) {
        MPJLambdaWrapper<CarMaintenance> wrapper = new MPJLambdaWrapper<CarMaintenance>()
                .selectAll(CarMaintenance.class)
                .select(Car::getCarNumber, Car::getFrameNumber)
                .leftJoin(Car.class, Car::getId, CarMaintenance::getCarId);
        if (carNumber != null && !carNumber.trim().isEmpty()) {
            wrapper.like(Car::getCarNumber, carNumber.trim());
        }
        if (frameNumber != null && !frameNumber.trim().isEmpty()) {
            wrapper.like(Car::getFrameNumber, frameNumber.trim());
        }
        if (state != null){
            wrapper.eq(CarMaintenance::getMaintenanceState, state);
        }
        return carMaintenanceDao.selectJoinPage(new Page<>(pageNum,pageSize), MaintenanceDto.class,wrapper);
    }

}

