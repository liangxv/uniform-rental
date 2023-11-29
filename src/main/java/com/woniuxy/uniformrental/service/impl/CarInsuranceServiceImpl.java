package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.uniformrental.dao.CarInsuranceDao;
import com.woniuxy.uniformrental.entity.CarInsurance;
import com.woniuxy.uniformrental.service.CarInsuranceService;
import org.springframework.stereotype.Service;

/**
 * (CarInsurance)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 19:25:04
 */
@Service("carInsuranceService")
public class CarInsuranceServiceImpl extends ServiceImpl<CarInsuranceDao, CarInsurance> implements CarInsuranceService {

}

