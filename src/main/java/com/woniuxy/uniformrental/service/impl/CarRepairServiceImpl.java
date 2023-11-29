package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.uniformrental.dao.CarRepairDao;
import com.woniuxy.uniformrental.entity.CarRepair;
import com.woniuxy.uniformrental.service.CarRepairService;
import org.springframework.stereotype.Service;

/**
 * (CarRepair)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 19:23:34
 */
@Service("carRepairService")
public class CarRepairServiceImpl extends ServiceImpl<CarRepairDao, CarRepair> implements CarRepairService {

}

