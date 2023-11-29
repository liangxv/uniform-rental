package com.woniuxy.uniformrental;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.uniformrental.dao.CarDao;
import com.woniuxy.uniformrental.dto.CarDto;
import com.woniuxy.uniformrental.entity.Car;
import com.woniuxy.uniformrental.service.CarService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UniformRentalApplicationTests {

    @Autowired
    CarDao carDao;

    @Autowired
    CarService carService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void contextLoads() {
//        List<Car> cars = carDao.selectList(null);
        Car car = carDao.selectById(1L);
        System.out.println(car);
//        Assert.isTrue(5 == cars.size(), "");
//        cars.forEach(System.out::println);

    }

}
