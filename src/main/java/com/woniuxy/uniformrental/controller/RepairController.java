package com.woniuxy.uniformrental.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.uniformrental.entity.Car;
import com.woniuxy.uniformrental.entity.CarRepair;
import com.woniuxy.uniformrental.service.CarRepairService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/repair")
@CrossOrigin
public class RepairController {
    @Autowired
    CarRepairService carRepairService;
    @GetMapping
    public ResponseEntity<Page<CarRepair>> list(@RequestParam(defaultValue = "1")Integer page,
                                                @RequestParam(defaultValue = "5")Integer size,
                                                @RequestParam(required = false) Integer state){
        LambdaQueryWrapper<CarRepair> wrapper = new LambdaQueryWrapper<>();
        if (state != null){
            wrapper.eq(CarRepair::getMaintenanceState, state);
        }
        return ResponseEntity
                .ok(carRepairService.page(new Page<>(page, size),wrapper));
    }

    @PostMapping
    public ResponseEntity<Boolean> add(@RequestBody CarRepair carRepair){
        return
                ResponseEntity.ok(carRepairService.save(carRepair));
    }

    @DeleteMapping
    public ResponseEntity
            <Boolean> delete(@RequestParam("id")Long id){
        return ResponseEntity.ok(carRepairService.removeById(id));
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody CarRepair carRepair){
        return ResponseEntity.ok(carRepairService.updateById(carRepair));
    }

    @GetMapping("/exportToExcel")    //要加上@RequestParam注解
    public void exportToExcel(HttpServletResponse response) throws IOException {

        //1.调用业务层获取要导出数据
        List<CarRepair> list = carRepairService.list();
        //获取当前页的数据导出

        //2.设置响应头：指定下载类型
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //设置响应头：指定下载的文件名
        response.setHeader("content-disposition", "attachment;filename=repair.xlsx");
        //3.调用EasyExcel的方法导出文件
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //write方法参数：输出流，实体类  sheet 表格名字 doWrite后面是要写的数据
        EasyExcel.write(out, Car.class).sheet("投诉信息").doWrite(list);
    }
}
