package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.uniformrental.dao.CarDao;
import com.woniuxy.uniformrental.dto.CarDto;
import com.woniuxy.uniformrental.entity.Car;
import com.woniuxy.uniformrental.entity.CarType;
import com.woniuxy.uniformrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Car)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 13:04:24
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarDao, Car> implements CarService {

    @Autowired
    CarDao carDao;

    @Override
    public Page<CarDto> carPage(Integer pageNum, Integer pageSize, Integer carTyped, String carNumber) {
        MPJLambdaWrapper<Car> wrapper = new MPJLambdaWrapper<Car>()
                .selectAll(Car.class)
                .select(CarType::getTypeName)
                .leftJoin(CarType.class, CarType::getId, Car::getCarTypeId);
        if (carTyped != null) {
            wrapper.eq(Car::getCarTypeId, carTyped);
        }
        if (carNumber != null && !carNumber.trim().isEmpty()){
            wrapper.like(Car::getCarNumber,carNumber.trim());
        }
        return carDao.selectJoinPage(new Page<>(pageNum,pageSize),CarDto.class,wrapper);
    }
}

