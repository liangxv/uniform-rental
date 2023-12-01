package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.uniformrental.dao.CarYearlyInspectionDao;
import com.woniuxy.uniformrental.dto.YearlyInspectionDto;
import com.woniuxy.uniformrental.entity.Car;
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

    @Override
    public Page<YearlyInspectionDto> yearlyInspectionPage(Integer pageNum, Integer pageSize, String frameNumber, String carNumber) {
        // 创建一个MPJLambdaWrapper对象，用于查询CarYearlyInspection表中的数据
        MPJLambdaWrapper<CarYearlyInspection> wrapper = new MPJLambdaWrapper<CarYearlyInspection>()
                .selectAll(CarYearlyInspection.class)
                .select(Car::getCarNumber, Car::getFrameNumber)
                .leftJoin(Car.class, Car::getId, CarYearlyInspection::getCarId);
        // 判断carNumber是否为空，不为空则添加查询条件
        if (carNumber != null && !carNumber.trim().isEmpty()) {
            wrapper.like(Car::getCarNumber, carNumber.trim());
        }
        // 判断frameNumber是否为空，不为空则添加查询条件
        if (frameNumber != null && !frameNumber.trim().isEmpty()) {
            wrapper.like(Car::getFrameNumber, frameNumber.trim());
        }
        // 调用yearlyInspectionDao的selectJoinPage方法，查询数据，并返回Page对象
        return yearlyInspectionDao.selectJoinPage(new Page<>(pageNum, pageSize), YearlyInspectionDto.class, wrapper);
    }
}

