package com.woniuxy.uniformrental.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.uniformrental.dto.MaintenanceDto;
import com.woniuxy.uniformrental.entity.CarMaintenance;

/**
 * (CarMaintenance)表服务接口
 *
 * @author makejava
 * @since 2023-11-27 19:07:05
 */
public interface CarMaintenanceService extends IService<CarMaintenance> {
    Page<MaintenanceDto> maintenancePage(Integer pageNum, Integer pageSize, String frameNumber, String carNumber, Integer state);
}

