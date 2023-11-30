package com.woniuxy.uniformrental.dto;

import com.woniuxy.uniformrental.entity.CarAccident;
import lombok.Data;

@Data
public class AccidentDto extends CarAccident {
    //车牌号
    private String carNumber;
    //车架号
    private String frameNumber;
}
