package com.woniuxy.uniformrental.dto;

import com.woniuxy.uniformrental.entity.CarInsurance;
import lombok.Data;

@Data
public class InsuranceDto extends CarInsurance {
    //车牌号
    private String carNumber;
    //车架号
    private String frameNumber;
}
