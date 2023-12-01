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
        // 创建MPJLambdaWrapper对象，用于构建查询条件
        MPJLambdaWrapper<Car> wrapper = new MPJLambdaWrapper<Car>()
                // 查询Car表中的所有字段
                .selectAll(Car.class)
                // 查询CarType表中的typeName字段
                .select(CarType::getTypeName)
                // 左连接查询CarType表
                .leftJoin(CarType.class, CarType::getId, Car::getCarTypeId);
        // 如果传入的carTyped参数不为空，则添加查询条件
        if (carTyped != null) {
            wrapper.eq(Car::getCarTypeId, carTyped);
        }
        // 如果传入的carNumber参数不为空，则添加查询条件
        if (carNumber != null && !carNumber.trim().isEmpty()) {
            wrapper.like(Car::getCarNumber, carNumber.trim());
        }
        // 调用carDao的selectJoinPage方法，查询数据，并返回Page对象
        return carDao.selectJoinPage(new Page<>(pageNum, pageSize), CarDto.class, wrapper);
    }
}

