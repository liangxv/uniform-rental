package com.woniuxy.uniformrental.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.uniformrental.dto.CarDto;
import com.woniuxy.uniformrental.entity.Car;

/**
 * (Car)表服务接口
 *
 * @author makejava
 * @since 2023-11-27 13:04:23
 */
public interface CarService extends IService<Car> {
    Page<CarDto> carPage(Integer pageNum, Integer pageSize ,Integer carTyped,String carNumber);
}

