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

    // 注入CarAccidentDao
    @Autowired
    CarAccidentDao carAccidentDao;
    // 查询事故信息分页
    public Page<AccidentDto> accidentPage(Integer pageNum, Integer pageSize, String frameNumber, String carNumber) {
        // 创建MPJLambdaWrapper对象，用于查询数据
        MPJLambdaWrapper<CarAccident> wrapper = new MPJLambdaWrapper<CarAccident>()
                // 查询CarAccident表中的所有字段
                .selectAll(CarAccident.class)
                // 查询Car表中的carNumber和frameNumber字段
                .select(Car::getCarNumber, Car::getFrameNumber)
                // 左连接Car表，查询CarAccident表中的carId字段
                .leftJoin(Car.class, Car::getId, CarAccident::getCarId);
        // 如果传入的carNumber不为空，则添加查询条件
        if (carNumber != null && !carNumber.trim().isEmpty()) {
            wrapper.like(Car::getCarNumber, carNumber.trim());
        }
        // 如果传入的frameNumber不为空，则添加查询条件
        if (frameNumber != null && !frameNumber.trim().isEmpty()) {
            wrapper.like(Car::getFrameNumber, frameNumber.trim());
        }
        // 返回查询结果，并转换为AccidentDto类型
        return carAccidentDao.selectJoinPage(new Page<>(pageNum,pageSize), AccidentDto.class,wrapper);
    }
}

