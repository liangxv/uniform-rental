package com.woniuxy.uniformrental.dto;

import com.woniuxy.uniformrental.entity.CarYearlyInspection;
import lombok.Data;

@Data
public class YearlyInspectionDto extends CarYearlyInspection {
    //车牌号
    private String carNumber;
    //车架号
    private String frameNumber;
}
