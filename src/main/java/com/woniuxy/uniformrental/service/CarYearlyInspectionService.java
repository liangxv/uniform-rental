package com.woniuxy.uniformrental.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.uniformrental.dto.YearlyInspectionDto;
import com.woniuxy.uniformrental.entity.CarYearlyInspection;

/**
 * (CarYearlyInspection)表服务接口
 *
 * @author makejava
 * @since 2023-11-27 19:26:10
 */
public interface CarYearlyInspectionService extends IService<CarYearlyInspection> {
    Page<YearlyInspectionDto> yearlyInspectionPage(Integer pageNum, Integer pageSize, String frameNumber, String carNumber);
}

