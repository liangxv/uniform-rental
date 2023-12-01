package com.woniuxy.uniformrental.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * (CarAccident)表实体类
 *
 * @author makejava
 * @since 2023-11-27 19:25:52
 */
@SuppressWarnings("serial")
public class CarAccident extends Model<CarAccident> {

    private Long id;
//事故日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date accidentDate;
//理赔金额
    private Double claimsAmount;
//损失金额
    private Double lossAmount;
//事故处理情况 0:未处理 1:已处理
    private Long treatmentSituation;
//赔偿金到位情况 0:未到位 1:已到位
    private Long compensationSituation;
//运营里程数
    private String operatingMileage;
//事故原因
    private String accidentCause;
//附件名称
    private String attachmentUploadName;
//附件
    private String attachmentUpload;
//外键id
    private Long carId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(Date accidentDate) {
        this.accidentDate = accidentDate;
    }

    public Double getClaimsAmount() {
        return claimsAmount;
    }

    public void setClaimsAmount(Double claimsAmount) {
        this.claimsAmount = claimsAmount;
    }

    public Double getLossAmount() {
        return lossAmount;
    }

    public void setLossAmount(Double lossAmount) {
        this.lossAmount = lossAmount;
    }

    public Long getTreatmentSituation() {
        return treatmentSituation;
    }

    public void setTreatmentSituation(Long treatmentSituation) {
        this.treatmentSituation = treatmentSituation;
    }

    public Long getCompensationSituation() {
        return compensationSituation;
    }

    public void setCompensationSituation(Long compensationSituation) {
        this.compensationSituation = compensationSituation;
    }

    public String getOperatingMileage() {
        return operatingMileage;
    }

    public void setOperatingMileage(String operatingMileage) {
        this.operatingMileage = operatingMileage;
    }

    public String getAccidentCause() {
        return accidentCause;
    }

    public void setAccidentCause(String accidentCause) {
        this.accidentCause = accidentCause;
    }

    public String getAttachmentUploadName() {
        return attachmentUploadName;
    }

    public void setAttachmentUploadName(String attachmentUploadName) {
        this.attachmentUploadName = attachmentUploadName;
    }

    public String getAttachmentUpload() {
        return attachmentUpload;
    }

    public void setAttachmentUpload(String attachmentUpload) {
        this.attachmentUpload = attachmentUpload;
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

