package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.uniformrental.dao.CarInsuranceDao;
import com.woniuxy.uniformrental.dto.InsuranceDto;
import com.woniuxy.uniformrental.entity.Car;
import com.woniuxy.uniformrental.entity.CarInsurance;
import com.woniuxy.uniformrental.service.CarInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (CarInsurance)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 19:25:04
 */
@Service("carInsuranceService")
public class CarInsuranceServiceImpl extends ServiceImpl<CarInsuranceDao, CarInsurance> implements CarInsuranceService {

    @Autowired
    private CarInsuranceDao carInsuranceDao;

    @Override
    public Page<InsuranceDto> insurancePage(Integer pageNum, Integer pageSize, String frameNumber, String carNumber) {
        MPJLambdaWrapper<CarInsurance> wrapper = new MPJLambdaWrapper<CarInsurance>()
                .selectAll(CarInsurance.class)
                .select(Car::getCarNumber, Car::getFrameNumber)
                .leftJoin(Car.class, Car::getId, CarInsurance::getCarId);
        if (carNumber != null && !carNumber.trim().isEmpty()) {
            wrapper.like(Car::getCarNumber, carNumber.trim());
        }
        if (frameNumber != null && !frameNumber.trim().isEmpty()) {
            wrapper.like(Car::getFrameNumber, frameNumber.trim());
        }
        return carInsuranceDao.selectJoinPage(new Page<>(pageNum,pageSize), InsuranceDto.class,wrapper);
    }
}

