package com.woniuxy.uniformrental.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.uniformrental.dto.InsuranceDto;
import com.woniuxy.uniformrental.entity.CarInsurance;

/**
 * (CarInsurance)表服务接口
 *
 * @author makejava
 * @since 2023-11-27 19:25:03
 */
public interface CarInsuranceService extends IService<CarInsurance> {
    Page<InsuranceDto> insurancePage(Integer pageNum, Integer pageSize, String frameNumber, String carNumber);
}

