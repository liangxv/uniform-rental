package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.uniformrental.dao.CarAccidentDao;
import com.woniuxy.uniformrental.entity.CarAccident;
import com.woniuxy.uniformrental.service.CarAccidentService;
import org.springframework.stereotype.Service;

/**
 * (CarAccident)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 19:25:52
 */
@Service("carAccidentService")
public class CarAccidentServiceImpl extends ServiceImpl<CarAccidentDao, CarAccident> implements CarAccidentService {

}

