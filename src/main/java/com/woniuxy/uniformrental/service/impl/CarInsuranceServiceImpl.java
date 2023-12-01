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
        // 创建MPJLambdaWrapper对象
        MPJLambdaWrapper<CarInsurance> wrapper = new MPJLambdaWrapper<CarInsurance>()
                // 设置查询的实体类
                .selectAll(CarInsurance.class)
                // 设置查询的字段
                .select(Car::getCarNumber, Car::getFrameNumber)
                // 设置关联关系
                .leftJoin(Car.class, Car::getId, CarInsurance::getCarId);
        // 判断carNumber是否为空
        if (carNumber != null && !carNumber.trim().isEmpty()) {
            // 设置查询条件
            wrapper.like(Car::getCarNumber, carNumber.trim());
        }
        // 判断frameNumber是否为空
        if (frameNumber != null && !frameNumber.trim().isEmpty()) {
            // 设置查询条件
            wrapper.like(Car::getFrameNumber, frameNumber.trim());
        }
        // 返回查询结果
        return carInsuranceDao.selectJoinPage(new Page<>(pageNum,pageSize), InsuranceDto.class,wrapper);
    }
}

