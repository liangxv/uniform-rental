package com.woniuxy.uniformrental.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (CarMaintenance)表实体类
 *
 * @author makejava
 * @since 2023-11-27 19:07:05
 */
@SuppressWarnings("serial")
public class CarMaintenance extends Model<CarMaintenance> {

    private Long id;
    //保养日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date maintenanceDate;
    //保养等级 1,2,3级
    private Long maintenanceGrade;
    //保养费用
    private Long maintenanceExpense;
    //保养周期（时间）
    private String maintenancePeriodDate;
    //保养周期（公里）
    private String maintenancePeriodKm;
    //状态 2:保养中 1:已保养 0:未保养
    private Long maintenanceState;
    //car外键
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

    public Long getMaintenanceExpense() {
        return maintenanceExpense;
    }

    public void setMaintenanceExpense(Long maintenanceExpense) {
        this.maintenanceExpense = maintenanceExpense;
    }

    public String getMaintenancePeriodDate() {
        return maintenancePeriodDate;
    }

    public void setMaintenancePeriodDate(String maintenancePeriodDate) {
        this.maintenancePeriodDate = maintenancePeriodDate;
    }

    public String getMaintenancePeriodKm() {
        return maintenancePeriodKm;
    }

    public void setMaintenancePeriodKm(String maintenancePeriodKm) {
        this.maintenancePeriodKm = maintenancePeriodKm;
    }

    public Long getMaintenanceState() {
        return maintenanceState;
    }

    public void setMaintenanceState(Long maintenanceState) {
        this.maintenanceState = maintenanceState;
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

