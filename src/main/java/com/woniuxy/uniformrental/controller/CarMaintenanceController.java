package com.woniuxy.uniformrental.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.uniformrental.entity.CarMaintenance;
import com.woniuxy.uniformrental.service.CarMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (CarMaintenance)表控制层
 *
 * @author makejava
 * @since 2023-11-27 19:07:05
 */
@RestController
@RequestMapping("carMaintenance")
public class CarMaintenanceController {
    /**
     * 服务对象
     */
    @Autowired
    private CarMaintenanceService carMaintenanceService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param carMaintenance 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseEntity<Page<CarMaintenance>> selectAll(@RequestParam(defaultValue = "1")Integer page,
                                                          @RequestParam(defaultValue = "1")Integer size,
                                                          CarMaintenance carMaintenance) {
        Page<CarMaintenance> result = carMaintenanceService.page(new Page<>(page,size),
                new QueryWrapper<>(carMaintenance));
        return ResponseEntity.ok(result);

    }



    /**
     * 新增数据
     *
     * @param carMaintenance 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Boolean> insert(@RequestBody CarMaintenance carMaintenance) {
        return ResponseEntity.ok(this.carMaintenanceService.save(carMaintenance));
    }

    /**
     * 修改数据
     *
     * @param carMaintenance 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody CarMaintenance carMaintenance) {
        return ResponseEntity.ok(carMaintenanceService.updateById(carMaintenance));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return ResponseEntity.ok(this.carMaintenanceService.removeByIds(idList));
    }
}

