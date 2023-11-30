package com.woniuxy.uniformrental.dto;

import com.woniuxy.uniformrental.entity.CarMaintenance;
import lombok.Data;

@Data
public class MaintenanceDto extends CarMaintenance {
    //车牌号
    private String carNumber;
    //车架号
    private String frameNumber;
}
