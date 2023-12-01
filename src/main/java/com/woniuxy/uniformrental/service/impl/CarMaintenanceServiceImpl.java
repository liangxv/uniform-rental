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
        // 创建MPJLambdaWrapper对象，用于构建查询条件
        MPJLambdaWrapper<CarMaintenance> wrapper = new MPJLambdaWrapper<CarMaintenance>()
                // 查询CarMaintenance表中的所有字段
                .selectAll(CarMaintenance.class)
                // 查询Car表中的carNumber和frameNumber字段
                .select(Car::getCarNumber, Car::getFrameNumber)
                // 左连接Car表，查询CarMaintenance表中的carId字段
                .leftJoin(Car.class, Car::getId, CarMaintenance::getCarId);
        // 如果carNumber不为空，则添加查询条件
        if (carNumber != null && !carNumber.trim().isEmpty()) {
            wrapper.like(Car::getCarNumber, carNumber.trim());
        }
        // 如果frameNumber不为空，则添加查询条件
        if (frameNumber != null && !frameNumber.trim().isEmpty()) {
            wrapper.like(Car::getFrameNumber, frameNumber.trim());
        }
        // 如果state不为空，则添加查询条件
        if (state != null){
            wrapper.eq(CarMaintenance::getMaintenanceState, state);
        }
        // 返回查询结果，并使用MaintenanceDto类进行转换
        return carMaintenanceDao.selectJoinPage(new Page<>(pageNum,pageSize), MaintenanceDto.class,wrapper);
    }

}

