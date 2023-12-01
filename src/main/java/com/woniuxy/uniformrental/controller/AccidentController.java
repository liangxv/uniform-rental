package com.woniuxy.uniformrental.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.uniformrental.dto.AccidentDto;
import com.woniuxy.uniformrental.entity.CarAccident;
import com.woniuxy.uniformrental.entity.CarInsurance;
import com.woniuxy.uniformrental.listener.ImportExcelListener;
import com.woniuxy.uniformrental.service.CarAccidentService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/accident")
@CrossOrigin
public class AccidentController {

    @Autowired
    CarAccidentService carAccidentService;

    @GetMapping
    public ResponseEntity<Page<AccidentDto>> list(@RequestParam(defaultValue = "1")Integer page,
                                                  @RequestParam(defaultValue = "5")Integer size,
                                                  @RequestParam(required = false) String frameNumber,
                                                  @RequestParam(required = false) String carNumber){
        //根据参数获取事故列表
        return ResponseEntity
                .ok(carAccidentService.accidentPage(page,size, frameNumber,carNumber));
    }

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody CarAccident carAccident){
        //保存事故
        return ResponseEntity.ok(carAccidentService.save(carAccident));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam Long id){
        //根据id删除事故
        return ResponseEntity.ok(carAccidentService.removeById(id));
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody CarAccident carAccident){
        //更新事故
        return ResponseEntity.ok(carAccidentService.updateById(carAccident));
    }

    @SneakyThrows
    @PostMapping("/importExcel")
    public ResponseEntity<String> importExcel(MultipartFile file) {
        //1.获取输入流
        InputStream inputStream = file.getInputStream();
        //2.创建Excel监听器
        ImportExcelListener<CarInsurance> listener = new ImportExcelListener<>();
        //3.读取：输入流，实体类对象，监听器对象
        EasyExcel.read(inputStream, CarAccident.class, listener).sheet().doRead();
        return ResponseEntity.ok("成功导入" + listener.getRow() + "条数据");
    }

    @GetMapping("/exportToExcel")    //要加上@RequestParam注解
    public void exportToExcel(HttpServletResponse response) throws IOException {

        //1.调用业务层获取要导出数据
        List<CarAccident> list = carAccidentService.list();
        //获取当前页的数据导出

        //2.设置响应头：指定下载类型
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //设置响应头：指定下载的文件名
        response.setHeader("content-disposition", "attachment;filename=maintenance.xlsx");
        //3.调用EasyExcel的方法导出文件
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //write方法参数：输出流，实体类  sheet 表格名字 doWrite后面是要写的数据
        EasyExcel.write(out, CarAccident.class).sheet("投诉信息").doWrite(list);
    }
}
