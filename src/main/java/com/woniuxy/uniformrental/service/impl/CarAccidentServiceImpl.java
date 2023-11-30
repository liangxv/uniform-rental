package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.uniformrental.dao.CarAccidentDao;
import com.woniuxy.uniformrental.dto.AccidentDto;
import com.woniuxy.uniformrental.dto.MaintenanceDto;
import com.woniuxy.uniformrental.entity.Car;
import com.woniuxy.uniformrental.entity.CarAccident;
import com.woniuxy.uniformrental.entity.CarMaintenance;
import com.woniuxy.uniformrental.service.CarAccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (CarAccident)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 19:25:52
 */
@Service("carAccidentService")
public class CarAccidentServiceImpl extends ServiceImpl<CarAccidentDao, CarAccident> implements CarAccidentService {

    @Autowired
    CarAccidentDao carAccidentDao;
    public Page<AccidentDto> accidentPage(Integer pageNum, Integer pageSize, String frameNumber, String carNumber) {
        MPJLambdaWrapper<CarAccident> wrapper = new MPJLambdaWrapper<CarAccident>()
                .selectAll(CarAccident.class)
                .select(Car::getCarNumber, Car::getFrameNumber)
                .leftJoin(Car.class, Car::getId, CarAccident::getCarId);
        if (carNumber != null && !carNumber.trim().isEmpty()) {
            wrapper.like(Car::getCarNumber, carNumber.trim());
        }
        if (frameNumber != null && !frameNumber.trim().isEmpty()) {
            wrapper.like(Car::getFrameNumber, frameNumber.trim());
        }
        return carAccidentDao.selectJoinPage(new Page<>(pageNum,pageSize), AccidentDto.class,wrapper);
    }
}

