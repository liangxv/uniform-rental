package com.woniuxy.uniformrental.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * (CarYearlyInspection)表实体类
 *
 * @author makejava
 * @since 2023-11-27 19:26:10
 */
@SuppressWarnings("serial")
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getOperatingMileage() {
        return operatingMileage;
    }

    public void setOperatingMileage(String operatingMileage) {
        this.operatingMileage = operatingMileage;
    }

    public String getYearlyInspectionIdentificationName() {
        return yearlyInspectionIdentificationName;
    }

    public void setYearlyInspectionIdentificationName(String yearlyInspectionIdentificationName) {
        this.yearlyInspectionIdentificationName = yearlyInspectionIdentificationName;
    }

    public String getYearlyInspectionIdentification() {
        return yearlyInspectionIdentification;
    }

    public void setYearlyInspectionIdentification(String yearlyInspectionIdentification) {
        this.yearlyInspectionIdentification = yearlyInspectionIdentification;
    }

    public Long getMaintenanceState() {
        return maintenanceState;
    }

    public void setMaintenanceState(Long maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public String getYearlyInspectionReminder() {
        return yearlyInspectionReminder;
    }

    public void setYearlyInspectionReminder(String yearlyInspectionReminder) {
        this.yearlyInspectionReminder = yearlyInspectionReminder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

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

