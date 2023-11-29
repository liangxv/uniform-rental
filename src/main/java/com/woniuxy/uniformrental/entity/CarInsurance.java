package com.woniuxy.uniformrental.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (CarInsurance)表实体类
 *
 * @author makejava
 * @since 2023-11-27 19:25:02
 */
@SuppressWarnings("serial")
public class CarInsurance extends Model<CarInsurance> {
//id
    private Long id;
//保险单号
    private String policyNumber;
//保险公司名称
    private String insuranceCompany;
//投保日期
    private Date insuranceDate;
//截止日期
    private Date deadlineDate;
//运营里程数
    private String operatingMileage;
//当前投保状态 0:未投保1:已投保 2:已到期
    private Long insuranceState;
//外键id
    private Long carId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getOperatingMileage() {
        return operatingMileage;
    }

    public void setOperatingMileage(String operatingMileage) {
        this.operatingMileage = operatingMileage;
    }

    public Long getInsuranceState() {
        return insuranceState;
    }

    public void setInsuranceState(Long insuranceState) {
        this.insuranceState = insuranceState;
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

