package com.woniuxy.uniformrental.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * (CarYearlyInspection)表实体类
 *
 * @author makejava
 * @since 2023-11-27 19:26:10
 */

@SuppressWarnings("serial")
@Data
public class CarYearlyInspection extends Model<CarYearlyInspection> {

    private Long id;
    //年检日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date maintenanceDate;
    //运营里程数
    private String operatingMileage;
    //年检标识名称
    private String yearlyInspectionIdentificationName;
    //年检标识
    private String yearlyInspectionIdentification;
    //年检状态 2:年检中1:已年检 0:未年检
    private Long maintenanceState;
    //年检提醒 1已开启 0未开启
    private String yearlyInspectionReminder;
    //备注
    private String remark;
    //外键
    private Long carId;




    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }
}

