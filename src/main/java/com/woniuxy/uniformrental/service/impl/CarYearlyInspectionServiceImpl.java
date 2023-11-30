package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.uniformrental.dao.CarYearlyInspectionDao;
import com.woniuxy.uniformrental.dto.AccidentDto;
import com.woniuxy.uniformrental.dto.YearlyInspectionDto;
import com.woniuxy.uniformrental.entity.Car;
import com.woniuxy.uniformrental.entity.CarAccident;
import com.woniuxy.uniformrental.entity.CarYearlyInspection;
import com.woniuxy.uniformrental.service.CarYearlyInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (CarYearlyInspection)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 19:26:10
 */
@Service("carYearlyInspectionService")
public class CarYearlyInspectionServiceImpl extends ServiceImpl<CarYearlyInspectionDao, CarYearlyInspection> implements CarYearlyInspectionService {

    @Autowired
    CarYearlyInspectionDao yearlyInspectionDao;
    public Page<YearlyInspectionDto> yearlyInspectionPage(Integer pageNum, Integer pageSize, String frameNumber, String carNumber) {
        MPJLambdaWrapper<CarYearlyInspection> wrapper = new MPJLambdaWrapper<CarYearlyInspection>()
                .selectAll(CarYearlyInspection.class)
                .select(Car::getCarNumber, Car::getFrameNumber)
                .leftJoin(Car.class, Car::getId, CarYearlyInspection::getCarId);
        if (carNumber != null && !carNumber.trim().isEmpty()) {
            wrapper.like(Car::getCarNumber, carNumber.trim());
        }
        if (frameNumber != null && !frameNumber.trim().isEmpty()) {
            wrapper.like(Car::getFrameNumber, frameNumber.trim());
        }
        return yearlyInspectionDao.selectJoinPage(new Page<>(pageNum,pageSize), YearlyInspectionDto.class,wrapper);
    }
}

