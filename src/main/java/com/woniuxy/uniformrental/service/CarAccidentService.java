package com.woniuxy.uniformrental.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.uniformrental.dto.AccidentDto;
import com.woniuxy.uniformrental.entity.CarAccident;

/**
 * (CarAccident)表服务接口
 *
 * @author makejava
 * @since 2023-11-27 19:25:52
 */
public interface CarAccidentService extends IService<CarAccident> {
    Page<AccidentDto> accidentPage(Integer pageNum, Integer pageSize, String frameNumber, String carNumber);
}

