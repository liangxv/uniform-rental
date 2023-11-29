package com.woniuxy.uniformrental.dto;

import com.woniuxy.uniformrental.entity.Car;
import lombok.Data;

@Data
public class CarDto extends Car {
    private String typeName;
}
