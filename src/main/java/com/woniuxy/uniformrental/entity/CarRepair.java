package com.woniuxy.uniformrental.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * (CarRepair)表实体类
 *
 * @author makejava
 * @since 2023-11-27 19:23:34
 */
@SuppressWarnings("serial")
public class CarRepair extends Model<CarRepair> {
//id
    private Long id;
//故障日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date maintenanceDate;
//维修等级 1,2,3级
    private Long maintenanceGrade;
//维修金额
    private Double maintenanceAmount;
//运营里程数
    private String operatingMileage;
//维修状态 0:未维修 1:已维修 2:维修中
    private Long maintenanceState;
//故障原因
    private String causeFailure;
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

    public Long getMaintenanceGrade() {
        return maintenanceGrade;
    }

    public void setMaintenanceGrade(Long maintenanceGrade) {
        this.maintenanceGrade = maintenanceGrade;
    }

    public Double getMaintenanceAmount() {
        return maintenanceAmount;
    }

    public void setMaintenanceAmount(Double maintenanceAmount) {
        this.maintenanceAmount = maintenanceAmount;
    }

    public String getOperatingMileage() {
        return operatingMileage;
    }

    public void setOperatingMileage(String operatingMileage) {
        this.operatingMileage = operatingMileage;
    }

    public Long getMaintenanceState() {
        return maintenanceState;
    }

    public void setMaintenanceState(Long maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public String getCauseFailure() {
        return causeFailure;
    }

    public void setCauseFailure(String causeFailure) {
        this.causeFailure = causeFailure;
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

